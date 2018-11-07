package com.hyeran.android.hw6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static Integer[] posterID = { R.drawable.dark_figure_of_crime, R.drawable.halloween, R.drawable.harry_potter,
            R.drawable.intimate_strangers, R.drawable.miss_baek, R.drawable.rampant};

    static String[] posterTitle = { "암수살인", "할로윈", "해리포터와 마법사의 돌", "완벽한 타인", "미쓰백", "창궐"};
    static String[] posterGenre = { "범죄, 드라마", "공포", "판타지, 가족, 모험, 액션", "드라마, 코미디", "드라마", "액션"};
    static String[] posterTime = { "110분", "106분", "152분", "115분", "98분", "121분"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");

        TextView btn_grid = findViewById(R.id.btn_grid_main);
        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GridActivity.class);
                startActivity(intent);
            }
        });

        TextView btn_gallery = findViewById(R.id.btn_gallery_main);
        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });

        TextView btn_spinner = findViewById(R.id.btn_spinner_main);
        btn_spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
                startActivity(intent);
            }
        });
    }
}
