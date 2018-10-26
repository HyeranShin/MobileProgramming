package com.hyeran.android.part5_4_3_movinganimation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv_moon = findViewById(R.id.moon);
        Animation anim_moon = AnimationUtils.loadAnimation(this, R.anim.moon);
        iv_moon.startAnimation(anim_moon);

        ImageView iv_bird = findViewById(R.id.bird);
        Animation anim_bird = AnimationUtils.loadAnimation(this, R.anim.bird);
        iv_bird.startAnimation(anim_bird);

        AnimationDrawable animationDrawable = new AnimationDrawable();
        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.bird3);
        animationDrawable.addFrame(frame1, 400);
        animationDrawable.addFrame(frame2, 400);
        animationDrawable.addFrame(frame3, 400);
        iv_bird.setBackgroundDrawable(animationDrawable);
        animationDrawable.start();

        ImageView iv_mountain = findViewById(R.id.mountain);
        Animation anim_mountain = AnimationUtils.loadAnimation(this, R.anim.mountain);
        iv_mountain.startAnimation(anim_mountain);
    }
}
