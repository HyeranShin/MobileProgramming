package com.hyeran.android.hw6;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static junit.runner.Version.id;

public class SelectSeatActivity extends AppCompatActivity {

    TextView total_person, total_price;
    int person, price;

    TreeSet<String> seats = new TreeSet<>();

    TextView btnComplete;

    TextView A1, A2, A3, A4, A5, A6, A7, A8, A9, A10,
             B1, B2, B3, B4, B5, B6, B7, B8, B9, B10,
             C1, C2, C3, C4, C5, C6, C7, C8, C9, C10,
             D1, D2, D3, D4, D5, D6, D7, D8, D9, D10,
             E1, E2, E3, E4, E5, E6, E7, E8, E9, E10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seat);
        setTitle("Home > 영화 선택 > 좌석 선택");

        person = 0;

        total_person = findViewById(R.id.total_person);
        total_price = findViewById(R.id.total_price);

        btnComplete = findViewById(R.id.btn_complete_select_seat);
        btnComplete.setOnClickListener(complete);

        A1 = findViewById(R.id.A01); A1.setOnClickListener(seat);
        A2 = findViewById(R.id.A02); A2.setOnClickListener(seat);
        A3 = findViewById(R.id.A03); A3.setOnClickListener(seat);
        A4 = findViewById(R.id.A04); A4.setOnClickListener(seat);
        A5 = findViewById(R.id.A05); A5.setOnClickListener(seat);
        A6 = findViewById(R.id.A06); A6.setOnClickListener(seat);
        A7 = findViewById(R.id.A07); A7.setOnClickListener(seat);
        A8 = findViewById(R.id.A08); A8.setOnClickListener(seat);
        A9 = findViewById(R.id.A09); A9.setOnClickListener(seat);
        A10 = findViewById(R.id.A10); A10.setOnClickListener(seat);

        B1 = findViewById(R.id.B01); B1.setOnClickListener(seat);
        B2 = findViewById(R.id.B02); B2.setOnClickListener(seat);
        B3 = findViewById(R.id.B03); B3.setOnClickListener(seat);
        B4 = findViewById(R.id.B04); B4.setOnClickListener(seat);
        B5 = findViewById(R.id.B05); B5.setOnClickListener(seat);
        B6 = findViewById(R.id.B06); B6.setOnClickListener(seat);
        B7 = findViewById(R.id.B07); B7.setOnClickListener(seat);
        B8 = findViewById(R.id.B08); B8.setOnClickListener(seat);
        B9 = findViewById(R.id.B09); B9.setOnClickListener(seat);
        B10 = findViewById(R.id.B10); B10.setOnClickListener(seat);

        C1 = findViewById(R.id.C01); C1.setOnClickListener(seat);
        C2 = findViewById(R.id.C02); C2.setOnClickListener(seat);
        C3 = findViewById(R.id.C03); C3.setOnClickListener(seat);
        C4 = findViewById(R.id.C04); C4.setOnClickListener(seat);
        C5 = findViewById(R.id.C05); C5.setOnClickListener(seat);
        C6 = findViewById(R.id.C06); C6.setOnClickListener(seat);
        C7 = findViewById(R.id.C07); C7.setOnClickListener(seat);
        C8 = findViewById(R.id.C08); C8.setOnClickListener(seat);
        C9 = findViewById(R.id.C09); C9.setOnClickListener(seat);
        C10 = findViewById(R.id.C10); C10.setOnClickListener(seat);

        D1 = findViewById(R.id.D01); D1.setOnClickListener(seat);
        D2 = findViewById(R.id.D02); D2.setOnClickListener(seat);
        D3 = findViewById(R.id.D03); D3.setOnClickListener(seat);
        D4 = findViewById(R.id.D04); D4.setOnClickListener(seat);
        D5 = findViewById(R.id.D05); D5.setOnClickListener(seat);
        D6 = findViewById(R.id.D06); D6.setOnClickListener(seat);
        D7 = findViewById(R.id.D07); D7.setOnClickListener(seat);
        D8 = findViewById(R.id.D08); D8.setOnClickListener(seat);
        D9 = findViewById(R.id.D09); D9.setOnClickListener(seat);
        D10 = findViewById(R.id.D10); D10.setOnClickListener(seat);

        E1 = findViewById(R.id.E01); E1.setOnClickListener(seat);
        E2 = findViewById(R.id.E02); E2.setOnClickListener(seat);
        E3 = findViewById(R.id.E03); E3.setOnClickListener(seat);
        E4 = findViewById(R.id.E04); E4.setOnClickListener(seat);
        E5 = findViewById(R.id.E05); E5.setOnClickListener(seat);
        E6 = findViewById(R.id.E06); E6.setOnClickListener(seat);
        E7 = findViewById(R.id.E07); E7.setOnClickListener(seat);
        E8 = findViewById(R.id.E08); E8.setOnClickListener(seat);
        E9 = findViewById(R.id.E09); E9.setOnClickListener(seat);
        E10 = findViewById(R.id.E10); E10.setOnClickListener(seat);
    }

    View.OnClickListener seat = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = v.toString();
            String seat_num = str.substring(str.length()-4, str.length()-1);
            if(v.isSelected() == false) {
                v.setSelected(true);
                v.setBackgroundDrawable(ContextCompat.getDrawable(SelectSeatActivity.this, R.drawable.selected_seat));
                person++;
                seats.add(seat_num);
            } else {
                v.setSelected(false);
                v.setBackgroundDrawable(ContextCompat.getDrawable(SelectSeatActivity.this, R.drawable.empty_seat));
                person--;
                seats.remove(seat_num);
            }

            total_person.setText(person+"");
            price = person * 10000;
            total_price.setText(price+"");
        }
    };

    View.OnClickListener complete = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(person == 0) {
                Toast toast = Toast.makeText(SelectSeatActivity.this, "좌석이 선택되지 않았습니다.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            } else {
                String seatinfo = String.valueOf(seats);
                Intent intent = new Intent(SelectSeatActivity.this, FinishActivity.class);
                intent.putExtra("person", person);
                intent.putExtra("seatinfo", seatinfo);
                intent.putExtra("movieinfo", getIntent().getIntExtra("movieinfo", 0));
                startActivity(intent);
            }
        }
    };
}
