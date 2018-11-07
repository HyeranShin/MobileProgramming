package com.hyeran.android.hw6;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.hyeran.android.hw6.MainActivity.posterGenre;
import static com.hyeran.android.hw6.MainActivity.posterID;
import static com.hyeran.android.hw6.MainActivity.posterTime;
import static com.hyeran.android.hw6.MainActivity.posterTitle;

public class GridActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        setTitle("Home > 영화선택");

        gridView = findViewById(R.id.grid_view);
        GridAdapter gridAdapter = new GridAdapter(this);
        gridView.setAdapter(gridAdapter);
    }

    protected class GridAdapter extends BaseAdapter {
        Context context;

        public GridAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return posterID.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(450, 700));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(posterID[position]);
            imageView.setPadding(0, 0, 0, 30);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = View.inflate(GridActivity.this, R.layout.dialog_grid, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(GridActivity.this);
                    ImageView ivPoster = dialogView.findViewById(R.id.iv_poster_dialog_grid);
                    ivPoster.setImageResource(posterID[position]);
                    TextView title = dialogView.findViewById(R.id.tv_title_dialog_grid);
                    TextView genre = dialogView.findViewById(R.id.tv_genre_dialog_grid);
                    TextView time = dialogView.findViewById(R.id.tv_time_dialog_grid);
                    title.setText(posterTitle[position]);
                    genre.setText(posterGenre[position]);
                    time.setText(posterTime[position]);
                    TextView btn = dialogView.findViewById(R.id.btn_complete_dialog_grid);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(GridActivity.this, SelectSeatActivity.class);
                            intent.putExtra("movieinfo" ,position);
                            startActivity(intent);
                        }
                    });
                    dlg.setView(dialogView);
                    dlg.show();
                }
            });

            return imageView;
        }
    }
}
