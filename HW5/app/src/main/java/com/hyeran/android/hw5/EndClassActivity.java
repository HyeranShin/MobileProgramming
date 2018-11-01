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

public class EndClassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_class);

        ImageView me = findViewById(R.id.iv_me_endclass);
        Animation anim_endclass = AnimationUtils.loadAnimation(this, R.anim.end_class);

        me.startAnimation(anim_endclass);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(EndClassActivity.this, GoHomeActivity.class);
                startActivity(intent);
            }
        }, 3000 );

    }
}
