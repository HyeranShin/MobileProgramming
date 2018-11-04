package com.hyeran.android.hw6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.hyeran.android.hw6.MainActivity.posterID;
import static com.hyeran.android.hw6.MainActivity.posterTitle;

public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        int position = getIntent().getIntExtra("movieinfo", 0);
        int person = getIntent().getIntExtra("person", 0);
        String seats = getIntent().getStringExtra("seatinfo");

        ImageView ivPoster = findViewById(R.id.iv_poster_finish);
        ivPoster.setScaleType(ImageView.ScaleType.FIT_XY);
        ivPoster.setImageResource(posterID[position]);
        TextView title = findViewById(R.id.tv_title_finish);
        title.setText(posterTitle[position]);
        TextView total_person = findViewById(R.id.tv_person_finish);
        total_person.setText(person+"");
        TextView seat_num = findViewById(R.id.tv_seat_num_finish);
        seat_num.setText(seats);

        TextView btn = findViewById(R.id.btn_complete_finish);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);   // 액티비티 스택 삭제
                startActivity(intent);
            }
        });

    }
}
