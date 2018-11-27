package com.hyeran.android.hw9_audioroom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class SongActivity extends AppCompatActivity implements View.OnClickListener {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Intent intent = getIntent();
        String index = intent.getStringExtra("index");
        int songId = getResources().getIdentifier("song" + index, "string", getPackageName());
        String song = getResources().getString(songId);
        int songFile = getResources().getIdentifier(song, "raw", getPackageName());
        mp = MediaPlayer.create(this, songFile);
        mp.setLooping(false);
        mp.start();

        TextView tvTitle = findViewById(R.id.tv_label_song);
        int titleId = getResources().getIdentifier("title" + index, "string", getPackageName());
        String title = getResources().getString(titleId);
        tvTitle.setText(title);

        TextView tvLyrics = findViewById(R.id.tv_lyrics_song);
        int lyricsId = getResources().getIdentifier("lyrics" + index, "string", getPackageName());
        String lyrics = getResources().getString(lyricsId);
        tvLyrics.setText(lyrics);


        ImageView ivPasue = findViewById(R.id.iv_pause);
        ivPasue.setOnClickListener(this);
        ImageView ivPlay = findViewById(R.id.iv_play);
        ivPlay.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
        mp.release();
    }

    @Override
    public void onClick(View v) {
        ViewSwitcher viewSwitcher = findViewById(R.id.viewswitcher_song);

        switch (v.getId()) {
            case R.id.iv_pause:
                mp.pause();
                break;
            case R.id.iv_play:
                mp.start();
                break;
        }

        viewSwitcher.showNext();
    }
}
