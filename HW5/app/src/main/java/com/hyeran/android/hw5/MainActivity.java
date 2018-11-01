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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView me = findViewById(R.id.iv_me_main);
        Animation anim_me_wakeup = AnimationUtils.loadAnimation(this, R.anim.wakeup);
        me.startAnimation(anim_me_wakeup);

        final ImageView sun = findViewById(R.id.iv_sun);
        Animation anim_sun = AnimationUtils.loadAnimation(this, R.anim.start_rotate);
        sun.startAnimation(anim_sun);

        final Handler handler = new Handler();

        final Button prepare = findViewById(R.id.btn_prepare_main);
        final TextView speech_bubble = findViewById(R.id.speech_bubble_main);
        final ImageView table = findViewById(R.id.iv_table);
        final ImageView breakfast = findViewById(R.id.iv_breakfast);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                table.setVisibility(View.VISIBLE);
                breakfast.setVisibility(View.VISIBLE);
                speech_bubble.setText("냠냠 맛있다!");

                prepare.setVisibility(View.VISIBLE);
            }
        }, 2300 );

        prepare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speech_bubble.setText("다녀오겠습니다!");
                table.setVisibility(View.INVISIBLE);
                breakfast.setVisibility(View.INVISIBLE);
                ImageView bag = findViewById(R.id.iv_bag_main);
                bag.setVisibility(View.VISIBLE);
                prepare.setVisibility(View.INVISIBLE);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, GoToSchoolActivity.class);
                        startActivity(intent);
                    }
                }, 1000 );
            }
        });
    }
}
