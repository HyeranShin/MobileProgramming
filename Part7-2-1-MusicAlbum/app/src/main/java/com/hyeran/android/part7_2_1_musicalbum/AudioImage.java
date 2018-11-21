package com.hyeran.android.part7_2_1_musicalbum;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AudioImage extends AppCompatActivity {

    MediaPlayer mp = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_image);
        setTitle("노래 재생");

        Intent it = getIntent();
        String tag = it.getStringExtra("it_tag");

        TextView title = findViewById(R.id.title);
        ImageView image = findViewById(R.id.song_image);
        TextView lyrics = findViewById(R.id.lyrics);

        Resources res = getResources();

        int stringId;
        String myKey;

        stringId = res.getIdentifier("title"+tag, "string", getPackageName());
        myKey = res.getString(stringId);
        title.setText(myKey);

        stringId = res.getIdentifier("song_image"+tag, "string", getPackageName());
        myKey = res.getString(stringId);

        int id_image = res.getIdentifier(myKey, "drawable", getPackageName());
        image.setImageResource(id_image);

        stringId = res.getIdentifier("lyrics"+tag, "string", getPackageName());
        myKey = res.getString(stringId);
        lyrics.setText(myKey);

        stringId = res.getIdentifier("audio"+tag, "string", getPackageName());
        myKey = res.getString(stringId);
        int id_audio = res.getIdentifier(myKey, "raw", getPackageName());
        mp = MediaPlayer.create(this, id_audio);
        mp.setLooping(false);
        mp.start();
    }

    public void goBack(View view) {
        mp.stop();
        mp.release();
        finish();
    }
}
