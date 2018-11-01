package com.hyeran.android.hw5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SchoolArrivalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_arrival);

        final ImageView me = findViewById(R.id.iv_me_gotoschool);
        Animation anim_me_jump = AnimationUtils.loadAnimation(this, R.anim.jump);

        me.startAnimation(anim_me_jump);

        Button btn = findViewById(R.id.btn_next_schoolarrival);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SchoolArrivalActivity.this, TakingClassActivity.class);
                startActivity(intent);
            }
        });
    }
}
