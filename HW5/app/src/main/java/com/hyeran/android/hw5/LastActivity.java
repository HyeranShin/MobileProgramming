package com.hyeran.android.hw5;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        final ImageView me = findViewById(R.id.iv_me_last);
        Animation anim_me_jump = AnimationUtils.loadAnimation(this, R.anim.jump);

        me.startAnimation(anim_me_jump);

        final TextView speech_bubble = findViewById(R.id.speech_bubble_last);
        final ImageView table = findViewById(R.id.iv_table_last);
        final ImageView dinner = findViewById(R.id.iv_dinner);
        final ImageView books = findViewById(R.id.iv_books);
        final Button btn = findViewById(R.id.btn_sleep_last);
        final ImageView notebook = findViewById(R.id.iv_notebook_last);
        final ImageView pencil = findViewById(R.id.iv_pencil_last);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                me.clearAnimation();
                table.setVisibility(View.VISIBLE);
                dinner.setVisibility(View.VISIBLE);
                speech_bubble.setText("맵지만 맛있다!");

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        notebook.setVisibility(View.VISIBLE);
                        pencil.setVisibility(View.VISIBLE);

                        Animation anim_pencil = AnimationUtils.loadAnimation(getBaseContext(), R.anim.pencil_last);
                        pencil.startAnimation(anim_pencil);

                        books.setVisibility(View.VISIBLE);
                        dinner.setVisibility(View.INVISIBLE);
                        speech_bubble.setText("과제가 너무 많아ㅠㅠ");
                        btn.setVisibility(View.VISIBLE);
                    }
                }, 2300);
            }
        }, 2300 );

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table.setVisibility(View.INVISIBLE);
                books.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.INVISIBLE);
                speech_bubble.setVisibility(View.INVISIBLE);
                notebook.setVisibility(View.INVISIBLE);
                pencil.clearAnimation();
                pencil.setVisibility(View.INVISIBLE);

                ImageView moon = findViewById(R.id.iv_moon);
                moon.setVisibility(View.VISIBLE);
                Animation anim_moon = AnimationUtils.loadAnimation(getBaseContext(), R.anim.start_rotate);
                moon.startAnimation(anim_moon);

                TextView speech_bubble = findViewById(R.id.speech_bubble2_last);
                speech_bubble.setVisibility(View.VISIBLE);

                Animation anim_me_sleep = AnimationUtils.loadAnimation(getBaseContext(), R.anim.sleep);

                me.startAnimation(anim_me_sleep);
            }
        });


    }
}
