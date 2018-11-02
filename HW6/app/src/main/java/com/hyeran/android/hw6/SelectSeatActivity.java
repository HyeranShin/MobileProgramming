package com.hyeran.android.hw6;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SelectSeatActivity extends AppCompatActivity {

    TextView total_person, total_price;
    int person, price, index;

    String[] seats = new String[50];

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
        index = 0;

        total_person = findViewById(R.id.total_person);
        total_price = findViewById(R.id.total_price);

        btnComplete = findViewById(R.id.btn_complete_select_seat);
        btnComplete.setOnClickListener(complete);

        A1 = findViewById(R.id.A1); A1.setOnClickListener(seat);
        A2 = findViewById(R.id.A2); A2.setOnClickListener(seat);
        A3 = findViewById(R.id.A3); A3.setOnClickListener(seat);
        A4 = findViewById(R.id.A4); A4.setOnClickListener(seat);
        A5 = findViewById(R.id.A5); A5.setOnClickListener(seat);
        A6 = findViewById(R.id.A6); A6.setOnClickListener(seat);
        A7 = findViewById(R.id.A7); A7.setOnClickListener(seat);
        A8 = findViewById(R.id.A8); A8.setOnClickListener(seat);
        A9 = findViewById(R.id.A9); A9.setOnClickListener(seat);
        A10 = findViewById(R.id.A10); A10.setOnClickListener(seat);

        B1 = findViewById(R.id.B1); B1.setOnClickListener(seat);
        B2 = findViewById(R.id.B2); B2.setOnClickListener(seat);
        B3 = findViewById(R.id.B3); B3.setOnClickListener(seat);
        B4 = findViewById(R.id.B4); B4.setOnClickListener(seat);
        B5 = findViewById(R.id.B5); B5.setOnClickListener(seat);
        B6 = findViewById(R.id.B6); B6.setOnClickListener(seat);
        B7 = findViewById(R.id.B7); B7.setOnClickListener(seat);
        B8 = findViewById(R.id.B8); B8.setOnClickListener(seat);
        B9 = findViewById(R.id.B9); B9.setOnClickListener(seat);
        B10 = findViewById(R.id.B10); B10.setOnClickListener(seat);

        C1 = findViewById(R.id.C1); C1.setOnClickListener(seat);
        C2 = findViewById(R.id.C2); C2.setOnClickListener(seat);
        C3 = findViewById(R.id.C3); C3.setOnClickListener(seat);
        C4 = findViewById(R.id.C4); C4.setOnClickListener(seat);
        C5 = findViewById(R.id.C5); C5.setOnClickListener(seat);
        C6 = findViewById(R.id.C6); C6.setOnClickListener(seat);
        C7 = findViewById(R.id.C7); C7.setOnClickListener(seat);
        C8 = findViewById(R.id.C8); C8.setOnClickListener(seat);
        C9 = findViewById(R.id.C9); C9.setOnClickListener(seat);
        C10 = findViewById(R.id.C10); C10.setOnClickListener(seat);

        D1 = findViewById(R.id.D1); D1.setOnClickListener(seat);
        D2 = findViewById(R.id.D2); D2.setOnClickListener(seat);
        D3 = findViewById(R.id.D3); D3.setOnClickListener(seat);
        D4 = findViewById(R.id.D4); D4.setOnClickListener(seat);
        D5 = findViewById(R.id.D5); D5.setOnClickListener(seat);
        D6 = findViewById(R.id.D6); D6.setOnClickListener(seat);
        D7 = findViewById(R.id.D7); D7.setOnClickListener(seat);
        D8 = findViewById(R.id.D8); D8.setOnClickListener(seat);
        D9 = findViewById(R.id.D9); D9.setOnClickListener(seat);
        D10 = findViewById(R.id.D10); D10.setOnClickListener(seat);

        E1 = findViewById(R.id.E1); E1.setOnClickListener(seat);
        E2 = findViewById(R.id.E2); E2.setOnClickListener(seat);
        E3 = findViewById(R.id.E3); E3.setOnClickListener(seat);
        E4 = findViewById(R.id.E4); E4.setOnClickListener(seat);
        E5 = findViewById(R.id.E5); E5.setOnClickListener(seat);
        E6 = findViewById(R.id.E6); E6.setOnClickListener(seat);
        E7 = findViewById(R.id.E7); E7.setOnClickListener(seat);
        E8 = findViewById(R.id.E8); E8.setOnClickListener(seat);
        E9 = findViewById(R.id.E9); E9.setOnClickListener(seat);
        E10 = findViewById(R.id.E10); E10.setOnClickListener(seat);
    }

    View.OnClickListener seat = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.isSelected() == false) {
                v.setSelected(true);
                v.setBackgroundDrawable(ContextCompat.getDrawable(SelectSeatActivity.this, R.drawable.selected_seat));
                person++;
                seats[index] = v.getId()+"";
                index++;
                Toast.makeText(SelectSeatActivity.this, seats[index-1], Toast.LENGTH_SHORT).show();
            } else {
                v.setSelected(false);
                v.setBackgroundDrawable(ContextCompat.getDrawable(SelectSeatActivity.this, R.drawable.empty_seat));
                person--;
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
                Intent intent = new Intent(SelectSeatActivity.this, FinishActivity.class);
                intent.putExtra("person", person);
                intent.putExtra("movieinfo", getIntent().getIntExtra("movieinfo", 0));
                startActivity(intent);
            }
        }
    };
}
