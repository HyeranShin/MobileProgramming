package com.hyeran.android.part7_2_2_audiorecord;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static String EXTERNAL_STORAGE_PATH = "";
    private static String RECORDED_FILE = "audio_recorder";
    private static int fileindex = 0;
    private static String filename = "";
    private MediaPlayer mp;
    private MediaRecorder mr;
    EditText audio;
    Button rStart;
    Button rStop;
    CheckBox repeat;
    Button mPlay;
    Button mStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*외장 메모리가 있는지 확인*/
        // Environment.getExternalStorageState() 를 통해서 현재 외장 메모리 상태를 알 수 있다.
        String state = Environment.getExternalStorageState();
        // Environment.MEDIA_MOUNTED 외장 메모리가 마운트 flog
        if(!state.equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(getApplicationContext(), "외장 메모리가 마운트 되지 않았습니다.", Toast.LENGTH_LONG).show();
        } else {
            EXTERNAL_STORAGE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
        }

        mr = new MediaRecorder();
        mp = new MediaPlayer();
        audio = findViewById(R.id.audioName);
        rStart = findViewById(R.id.recstart);
        rStop = findViewById(R.id.recstop);
        repeat = findViewById(R.id.repeatCheck);
        mPlay = findViewById(R.id.play);
        mStop = findViewById(R.id.stop);

        rStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "녹음 시작", Toast.LENGTH_LONG).show();
                startRec();
            }
        });

        rStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "녹음 중지", Toast.LENGTH_LONG).show();
                stopRec();
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repeatPlay();
            }
        });

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });
        
        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });

        checkDangerousPermission();
    }

    private void startRec() {
        try {
            if(mr == null) {
                mr = new MediaRecorder();
            }
            initRecorder();
            filename = createFilename();
            mr.setOutputFile(filename);
            mr.prepare();
            mr.start();
        } catch (IOException ioe) {
            Toast.makeText(getApplicationContext(), "IOException", Toast.LENGTH_SHORT).show();
            mr.release();
            mr = null;
        }
    }

    private String createFilename() {
        fileindex++;
        String newFilename = "";
        String getAudio = audio.getText().toString();

        if(getAudio == null) {
            getAudio = RECORDED_FILE + fileindex;
        }
        if (EXTERNAL_STORAGE_PATH == null || EXTERNAL_STORAGE_PATH.equals("")){
            // 내장 메모리를 사용합니다.
            newFilename = getAudio + ".mp3";
        } else {
            // 외장 메모리를 사용합니다.
            newFilename = EXTERNAL_STORAGE_PATH + "/" + getAudio + ".mp3";
        }
        return newFilename;
    }

    private void initRecorder() {
        // 오디오 입력 형식 설정
        mr.setAudioSource(MediaRecorder.AudioSource.MIC);
        mr.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        // 오디오 인코더 설정
        mr.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
    }

    private void stopRec() {
        if(mr == null) return;
        mr.stop();
        mr.release();
        mr = null;

        ContentValues values = new ContentValues(10);

        values.put(MediaStore.MediaColumns.TITLE, "RecordedAudio");
        values.put(MediaStore.Audio.Media.ALBUM, "Audio Album");
        values.put(MediaStore.Audio.Media.ARTIST, "Mike");
        values.put(MediaStore.Audio.Media.DISPLAY_NAME, "Recorded Audio");
        values.put(MediaStore.MediaColumns.DATE_ADDED, System.currentTimeMillis() / 1000);
        values.put(MediaStore.MediaColumns.MIME_TYPE, "Audio/mp3");
        values.put(MediaStore.Audio.Media.DATA, filename);

        Uri audioUri = getContentResolver().insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, values);
        if(audioUri == null) {
            Log.d("SampleAudioRecorder", "Audio insert failed.");
            return;
        }
        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, audioUri));
    }

    private void play() {
        if (mp == null) {
            mp = new MediaPlayer();
        }
        try {
            Toast.makeText(getApplicationContext(), "사운드 재생", Toast.LENGTH_SHORT).show();
            mp.setDataSource(EXTERNAL_STORAGE_PATH+"/"+audio.getText().toString()+".mp3");
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "재생 도중 오류가 발생하였습니다.", Toast.LENGTH_LONG).show();
        }
    }

    private void repeatPlay() {
        if(mp == null) {
            mp = new MediaPlayer();
        }
        if(repeat.isChecked()) {    // 체크 박스에 체크하면
            Toast.makeText(getApplicationContext(), "반복 활성화됨", Toast.LENGTH_SHORT).show();
            mp.setLooping(true);    // 반복을 활성화합니다.
        } else {
            Toast.makeText(getApplicationContext(), "반복 해제됨", Toast.LENGTH_SHORT).show();
            mp.setLooping(false);   // 반복을 비활성화합니다.
        }
    }

    private void stop() {
        Toast.makeText(getApplicationContext(), "사운드 정지", Toast.LENGTH_SHORT).show();
        if(mp == null) return;
        mp.stop();
        mp.release();
        mp = null;
    }

    private void checkDangerousPermission() {
        String[] permissions = {
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for(int i=0; i<permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
//            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
//            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if(ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
//                Toast.makeText(this, "권한 설명 필요함", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

}
