package com.hyeran.android.part7_1_5_videoplaywithurl;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btnOnce, btnContinuously, btnStop, btnPlay, btnVolume;
    VideoView videoView;
    MediaController mediaController;
    Uri uri;
    Boolean isContinuously = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOnce = findViewById(R.id.btn_once);
        btnContinuously = findViewById(R.id.btn_continuously);
        btnStop = findViewById(R.id.btn_stop);
        btnPlay = findViewById(R.id.btn_play);
        btnVolume = findViewById(R.id.btn_volume_max);
        videoView = findViewById(R.id.videoview);

        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        String uriPath = "http://www.demonuts.com/Demonuts/smallvideo.mp4";
        uri = Uri.parse(uriPath);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if(isContinuously) {
                    videoView.start();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });

        btnOnce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContinuously = false;
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
            }
        });

        btnContinuously.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isContinuously = true;
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
            }
        });

        btnVolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
                int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, AudioManager.FLAG_SHOW_UI);
            }
        });

    }
}
