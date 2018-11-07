package com.hyeran.android.part7_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void play(View view) {
        int id = view.getId();
        LinearLayout layout = findViewById(id);

        String tag = (String)layout.getTag();

        Intent it = new Intent(this, VideoPlayback.class);
        it.putExtra("it_tag", tag);
        startActivity(it);
    }
}
