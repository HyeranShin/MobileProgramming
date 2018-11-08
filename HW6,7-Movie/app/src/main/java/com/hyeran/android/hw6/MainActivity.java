package com.hyeran.android.hw6;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static Integer[] posterID = { R.drawable.dark_figure_of_crime, R.drawable.halloween, R.drawable.bohemian_rhapsody,
            R.drawable.intimate_strangers, R.drawable.miss_baek, R.drawable.rampant};

    static String[] posterTitle = { "암수살인", "할로윈", "보헤미안 랩소디", "완벽한 타인", "미쓰백", "창궐"};
    static String[] posterGenre = { "범죄, 드라마", "공포", "드라마", "드라마, 코미디", "드라마", "액션"};
    static String[] posterTime = { "110분", "106분", "134분", "115분", "98분", "121분"};
    static Integer[] movieCharatorFile = { R.drawable.dark_figure_of_crime_ch, R.drawable.halloween_ch, R.drawable.bohemian_rhapsody_ch,
            R.drawable.intimate_strangers_ch, R.drawable.missbaek_ch, R.drawable.rampant_ch };
    static String[] videoID = { "dfnKOAmaQM8", "KbkWuEbACDM", "XTZko22Ze3o", "-UWdeFywycs", "EywPeg8BqyY", "qHmQE93hVmA" };

    // 창궐 qHmQE93hVmA
    // 보헤미안 랩소디 XTZko22Ze3o
    // 할로윈 KbkWuEbACDM
    // 미쓰백 EywPeg8BqyY
    // 암수살인 dfnKOAmaQM8
    // 완벽한타인 UWdeFywycs

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
