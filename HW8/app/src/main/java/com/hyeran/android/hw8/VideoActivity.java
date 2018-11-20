package com.hyeran.android.hw8;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = getIntent();
        String name = intent.getStringExtra("FILE");
//        Toast.makeText(this, name+"", Toast.LENGTH_SHORT).show();

        VideoView videoView = findViewById(R.id.vv_video);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
//        Toast.makeText(this, path+"", Toast.LENGTH_SHORT).show();
//        videoView.setVideoPath("/storage/emulated/0/DCIM/Camera/20181109_091403.mp4");
//        Toast.makeText(this, path+"/DCIM/Camera/"+name, Toast.LENGTH_LONG).show();
        videoView.setVideoPath(path+"/DCIM/Camera/"+name);
        videoView.requestFocus();
        videoView.start();
    }
}