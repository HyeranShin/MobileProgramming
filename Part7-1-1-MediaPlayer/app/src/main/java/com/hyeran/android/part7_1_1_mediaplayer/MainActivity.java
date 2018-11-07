package com.hyeran.android.part7_1_1_mediaplayer;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView vv = findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);

        Uri uri = Uri.parse("android.resource://com.hyeran.android.part7_1_1_mediaplayer/"
        + "raw" + "/" + "video1");
        vv.setMediaController(mc);
        vv.setVideoURI(uri);
        vv.start();
    }
}
