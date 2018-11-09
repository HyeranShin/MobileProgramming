package com.hyeran.android.part7_1_4_storageplay;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayMedia02 extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.play);

        VideoView videoView = findViewById(R.id.videoview);
        MediaController mediaController = new MediaController(this);

        String path = Environment.getExternalStorageDirectory().getAbsolutePath();

        videoView.setVideoPath(path + "/video_recorded1.mp4");  // /storage/emulated/0
        videoView.setMediaController(mediaController);
        mediaController.show(0);    // 미디어컨트롤러 보이게 하기
        videoView.requestFocus();
        videoView.start();  // 재생하기
    }
}
