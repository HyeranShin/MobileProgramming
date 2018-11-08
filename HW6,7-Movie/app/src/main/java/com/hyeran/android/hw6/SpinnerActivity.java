package com.hyeran.android.hw6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.hyeran.android.hw6.MainActivity.posterGenre;
import static com.hyeran.android.hw6.MainActivity.posterID;
import static com.hyeran.android.hw6.MainActivity.posterTime;
import static com.hyeran.android.hw6.MainActivity.posterTitle;

public class SpinnerActivity extends AppCompatActivity {

    TextView btn;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        setTitle("Home > 영화선택");

        btn = findViewById(R.id.btn_complete_gallery);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpinnerActivity.this, SelectSeatActivity.class);
                intent.putExtra("movieinfo" ,pos);
                startActivity(intent);
            }
        });

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, posterTitle);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
                ImageView ivPoster = findViewById(R.id.iv_poster_spinner);
                ivPoster.setScaleType(ImageView.ScaleType.FIT_XY);
                ivPoster.setImageResource(posterID[position]);
                TextView title = findViewById(R.id.tv_title_spinner);
                title.setText(posterTitle[position]);
                TextView genre = findViewById(R.id.tv_genre_spinner);
                genre.setText(posterGenre[position]);
                TextView time = findViewById(R.id.tv_time_spinner);
                time.setText(posterTime[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
