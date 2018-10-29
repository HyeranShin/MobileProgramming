package com.hyeran.android.hw4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 각 학번의 인원 수
    static int classOf17 = 16;
    static int classOf16 = 9;
    static int classOf15 = 1;
    static int classOf14 = 2;

    // 각 학번의 고유 색상
    static String color17 = "#ffe082";
    static String color16 = "#ffca28";
    static String color15 = "#ffb300";
    static String color14 = "#ff8f00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView circle = findViewById(R.id.circle);
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CircleActivity.class);
                startActivity(intent);
            }
        });

        TextView curved_line = findViewById(R.id.curved_line);
        curved_line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), CurvedLineActivity.class);
                startActivity(intent);
            }
        });

        TextView vertical_bar = findViewById(R.id.vertical_bar);
        vertical_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), VerticalBarActivity.class);
                startActivity(intent);
            }
        });

        TextView horizontal_bar = findViewById(R.id.horizontal_bar);
        horizontal_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), HorizontalBarActivity.class);
                startActivity(intent);
            }
        });
    }
}
