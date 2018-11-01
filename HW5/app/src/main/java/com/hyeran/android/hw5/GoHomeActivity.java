package com.hyeran.android.hw5;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class GoHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_home);

        final ImageView me = findViewById(R.id.iv_me_gohome);
        Animation anim_me_gotohome = AnimationUtils.loadAnimation(this, R.anim.go_home);

        me.startAnimation(anim_me_gotohome);

        final ImageView car = findViewById(R.id.iv_car_gohome);
        Animation anim_car = AnimationUtils.loadAnimation(this, R.anim.car);

        car.startAnimation(anim_car);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(GoHomeActivity.this, LastActivity.class);
                startActivity(intent);
            }
        }, 2100 );
    }
}
