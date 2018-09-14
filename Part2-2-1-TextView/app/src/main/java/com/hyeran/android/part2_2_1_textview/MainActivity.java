package com.hyeran.android.part2_2_1_textview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        TextView obj1 = new TextView(this);
        obj1.setText("Welcome! 2018 모바일 프로그래밍 (Java Code)");
        setContentView(obj1);
    }
}
