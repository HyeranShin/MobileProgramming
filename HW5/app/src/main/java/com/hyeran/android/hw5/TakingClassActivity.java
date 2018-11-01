package com.hyeran.android.hw5;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TakingClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taking_class);

        final ImageView pencil = findViewById(R.id.iv_pencil_class);
        Animation anim_pencil = AnimationUtils.loadAnimation(this, R.anim.pencil);

        pencil.startAnimation(anim_pencil);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView speech_bubble = findViewById(R.id.speech_bubble_takingclass);
                speech_bubble.setVisibility(View.VISIBLE);
                pencil.clearAnimation();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(TakingClassActivity.this, EndClassActivity.class);
                        startActivity(intent);
                    }
                }, 1500 );
            }
        }, 2000 );

    }
}
