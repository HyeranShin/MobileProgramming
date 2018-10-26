package com.hyeran.android.part5_4_1_frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable mframeAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Start Button --Added
        final Button onButton = findViewById(R.id.ButtonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button --Added
        final Button offButton = findViewById(R.id.ButtonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void startAnimation() {
        ImageView img = findViewById(R.id.ImageView_Jnggle);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.pairi1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.pairi2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.pairi3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.pairi4);

        int reasonableDuration = 200;
        mframeAnimation = new AnimationDrawable();

        mframeAnimation.setOneShot(false);
        mframeAnimation.addFrame(frame1, reasonableDuration);
        mframeAnimation.addFrame(frame2, reasonableDuration);
        mframeAnimation.addFrame(frame3, reasonableDuration);
        mframeAnimation.addFrame(frame4, reasonableDuration);

        img.setBackgroundDrawable(mframeAnimation);

        mframeAnimation.setVisible(true, true);
        mframeAnimation.start();
    }

    private void stopAnimation() {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false, false);
    }
}
