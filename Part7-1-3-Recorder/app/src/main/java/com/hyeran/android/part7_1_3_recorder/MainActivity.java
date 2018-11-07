package com.hyeran.android.part7_1_3_recorder;

import android.Manifest;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "error";
    private static String EXTERNAL_STORAGE_PATH = "";
    private static String RECORDER_FILE = "video_recorded";
    private static int fileIndex = 0;
    private static String filename = "";

    MediaPlayer player;
    MediaRecorder recorder;

    private Camera camera = null;
    SurfaceView surfaceView;
    SurfaceHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* 외장메모리가 있는지 확인한다. */
        // Environment.getExternalStorageState() 등 통해서 현재 외장메모리 상태를 알 수 있다.
        String state = Environment.getExternalStorageState();
        // Environment.MEDIA_MOUNTED 외장메모리가 마운트 flog
        if (!state.equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(getApplicationContext(), "외장 메모리가 마운트 되지않았습니다.", Toast.LENGTH_LONG).show();
        } else {
            EXTERNAL_STORAGE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
        }

        surfaceView = findViewById(R.id.videoLayout);
        // SurfaceView 클래스를 컨트롤하기위한 SurfaceHolder 생성
        holder = surfaceView.getHolder();
        // 버퍼 없음
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        final Button recordBtn = findViewById(R.id.recordBtn);
        Button recordStopBtn = findViewById(R.id.recordStopBtn);
        final Button playBtn = findViewById(R.id.playBtn);
        Button playStopBtn = findViewById(R.id.playStopBtn);

        // 녹화 시작 버튼
        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // 녹화 시작을 위해 MediaRecorder 객체 recorder를 생성
                    if(recorder == null) {
                        recorder = new MediaRecorder();
                    }
                    recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    recorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                    recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                    recorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);

                    // 저장할 파일 지정
                    filename = createFilename();
                    Log.d(TAG, "current filename : " + filename);
                    recorder.setOutputFile(filename);
                    recorder.setPreviewDisplay(holder.getSurface());
                    recorder.prepare();
                    recorder.start();
                } catch (Exception ex) {
                    Log.e(TAG, "Exception", ex);
                    recorder.release();
                    recorder = null;
                }
            }
        });

        // 녹화 정지 버튼
        recordStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recorder == null)
                    return;

                recorder.stop();
                recorder.reset();
                recorder.release(); // 영상 재생에 필요한 공간 해제
                recorder = null;

                ContentValues values = new ContentValues(10);

                values.put(MediaStore.MediaColumns.TITLE, "RecorderVideo");
                values.put(MediaStore.Audio.Media.ALBUM, "Video Album");
                values.put(MediaStore.Audio.Media.ARTIST, "Mike");
                values.put(MediaStore.Audio.Media.DISPLAY_NAME, "Recorded Video");
                values.put(MediaStore.MediaColumns.DATE_ADDED, System.currentTimeMillis() / 1000);
                values.put(MediaStore.MediaColumns.MIME_TYPE, "video/mp4");
                values.put(MediaStore.Audio.Media.DATA, filename);

                Uri videoUri = getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, values);
                if(videoUri == null) {
                    Log.d("SampleVideoRecorder", "Video insert failed.");
                    return;
                }
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, videoUri));

            }
        });

        // 재생 시작 버튼
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 영상 재생기
                if (player == null) {
                    player = new MediaPlayer();
                }

                try {
                    player.setDataSource(filename); // 재생할 파일
                    player.setDisplay(holder);  // 재생할 공간(뷰)
                    player.prepare();
                    player.start();
                } catch (Exception e) {
                    Log.e(TAG, "Video play failed.", e);
                }
            }
        });

        // 재생 종료 버튼
        playStopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 영상 중지 방법
                if (player == null)
                    return;
                // 영상 중지
                player.stop();
                // 메모리 해제, 객체 소멸
                player.release();
                player = null;
            }
        });

        checkDangerousPermission();
    }

    private void checkDangerousPermission() {
        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.CAMERA
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for(int i=0; i<permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if(ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            for (int i=0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, permissions[i] + "권한이 승인됨", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + "권한이 승인되지 않음", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private String createFilename() {
        fileIndex++;

        String newFilename = "";
        if(EXTERNAL_STORAGE_PATH == null || EXTERNAL_STORAGE_PATH.equals("")) {
            newFilename = RECORDER_FILE + fileIndex + ".mp4";
        } else {
            newFilename = EXTERNAL_STORAGE_PATH + "/" + RECORDER_FILE + fileIndex + ".mp4";
        }

        return newFilename;
    }

    protected void onPause() {
        if(camera != null) {
            camera.release();
            camera = null;
        }

        if(recorder != null) {
            recorder.release();
            recorder = null;
        }

        if(player != null) {
            player.release();
            player = null;
        }
        super.onPause();
    }
}
