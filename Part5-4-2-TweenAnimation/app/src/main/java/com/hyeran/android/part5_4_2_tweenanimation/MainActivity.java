package com.hyeran.android.part5_4_2_tweenanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
    }

    private void perfomrAnimation(int transparency) {
    }
}
