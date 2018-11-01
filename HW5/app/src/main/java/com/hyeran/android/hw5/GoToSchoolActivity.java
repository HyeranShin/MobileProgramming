package com.hyeran.android.hw5;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class GoToSchoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_school);

        final ImageView me = findViewById(R.id.iv_me_gotoschool);
        Animation anim_me_gotoschool = AnimationUtils.loadAnimation(this, R.anim.go_to_school);

        me.startAnimation(anim_me_gotoschool);

        final ImageView bus = findViewById(R.id.iv_bus_gotoschool);
        Animation anim_bus = AnimationUtils.loadAnimation(this, R.anim.bus);

        bus.startAnimation(anim_bus);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(GoToSchoolActivity.this, SchoolArrivalActivity.class);
                startActivity(intent);
            }
        }, 2100 );
    }
}
