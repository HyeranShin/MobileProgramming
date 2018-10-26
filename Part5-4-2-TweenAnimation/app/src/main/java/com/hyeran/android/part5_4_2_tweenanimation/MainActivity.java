package com.hyeran.android.part5_4_2_tweenanimation;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Handle Fade Button1
        final Button fadeButton = findViewById(R.id.buttonAlpha);
        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfomrAnimation(R.anim.transparency);
            }
        });

        // Handle Grow Button1
        final Button growButton = findViewById(R.id.buttonScale);
        growButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfomrAnimation(R.anim.grow);
            }
        });

        // Handle Move Button3
        final Button moveButton = findViewById(R.id.buttonTranslate);
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfomrAnimation(R.anim.translate_position);
            }
        });

        // Handle Fade Button1
        final Button spinButton = findViewById(R.id.buttonRotate);
        spinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfomrAnimation(R.anim.spin);
            }
        });

        // Handle Fade Button1
        final Button allButton = findViewById(R.id.buttonAll);
        allButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perfomrAnimation(R.anim.shakennotstirred);
            }
        });
    }

    private void perfomrAnimation(int animationResourceID) {
        ImageView reusableImageView = findViewById(R.id.imageViewForTweening);
        reusableImageView.setImageResource(R.drawable.img);
        reusableImageView.setVisibility(View.VISIBLE);

        Animation an = AnimationUtils.loadAnimation(this, animationResourceID);
        an.setAnimationListener(new MyAnimationListener());
        reusableImageView.startAnimation(an);
    }

    class MyAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            ImageView reusableImageView = findViewById(R.id.imageViewForTweening);
            reusableImageView.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }

}
