package com.hyeran.android.hw6;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.hyeran.android.hw6.MainActivity.movieCharatorFile;
import static com.hyeran.android.hw6.MainActivity.posterGenre;
import static com.hyeran.android.hw6.MainActivity.posterID;
import static com.hyeran.android.hw6.MainActivity.posterTime;
import static com.hyeran.android.hw6.MainActivity.posterTitle;
import static com.hyeran.android.hw6.MainActivity.videoID;

public class GalleryActivity extends AppCompatActivity {

    Gallery gallery;
    TextView btn;
    int chosen, pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        setTitle("Home > 영화선택");

        gallery = findViewById(R.id.gallery);

        GalleryAdapter galleryAdapter = new GalleryAdapter(this);
        gallery.setAdapter(galleryAdapter);

        btn = findViewById(R.id.btn_complete_gallery);

        chosen = 0;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chosen == 0) {
                    Toast toast = Toast.makeText(GalleryActivity.this, "영화가 선택되지 않았습니다.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                } else {
                    Intent intent = new Intent(GalleryActivity.this, SelectSeatActivity.class);
                    intent.putExtra("movieinfo" ,pos);
                    startActivity(intent);
                }
            }
        });

    }

    protected class GalleryAdapter extends BaseAdapter {
        Context context;

        public GalleryAdapter(Context c) {
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
            imageView.setLayoutParams(new Gallery.LayoutParams(350, 530));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(posterID[position]);

            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    chosen = 1;
                    pos = position;
                    ImageView ivPoster = findViewById(R.id.iv_poster_gallery);
                    ivPoster.setScaleType(ImageView.ScaleType.FIT_XY);
                    ivPoster.setImageResource(posterID[position]);
                    TextView title = findViewById(R.id.tv_title_gallery);
                    title.setText(posterTitle[position]);
                    TextView genre = findViewById(R.id.tv_genre_gallery);
                    genre.setText(posterGenre[position]);
                    TextView time = findViewById(R.id.tv_time_gallery);
                    time.setText(posterTime[position]);
                    ImageView movieCharactor = findViewById(R.id.iv_movie_ch);
                    movieCharactor.setImageDrawable(getDrawable(movieCharatorFile[position]));
                    Animation anim = AnimationUtils.loadAnimation(GalleryActivity.this, R.anim.translate);
                    movieCharactor.startAnimation(anim);
                    Button btn = findViewById(R.id.btn_preview_gallery);
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse( "http://youtu.be/" + videoID[position] ));
                            startActivity( intent );
                        }
                    });
                    return false;
                }
            });

            return imageView;
        }
    }
}
