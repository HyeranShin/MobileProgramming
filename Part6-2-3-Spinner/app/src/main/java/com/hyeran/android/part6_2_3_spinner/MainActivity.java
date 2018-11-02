package com.hyeran.android.part6_2_3_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Spinner 실습");

        String[] movie = {"암수살인", "할로윈", "해리포터와 마법사의 돌", "완벽한 타인", "미쓰백", "창궐", "벽 속에 숨은 마법시계"};

        final Integer[] posterID = {R.drawable.dark_figure_of_crime, R.drawable.halloween, R.drawable.harry_potter, R.drawable.intimate_strangers
        , R.drawable.miss_baek, R.drawable.rampant, R.drawable.the_house_with_a_clock_in_its_walls};

        Spinner spinner = findViewById(R.id.spinner1);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, movie);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView ivPoster = findViewById(R.id.ivPoster);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ivPoster.setPadding(5, 5, 5, 5);
                ivPoster.setImageResource(posterID[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
