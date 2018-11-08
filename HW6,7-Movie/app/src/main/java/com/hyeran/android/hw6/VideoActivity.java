package com.hyeran.android.hw6;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URL;

public class VideoActivity extends AppCompatActivity {


    private static final String rampant_path = "https://tv.naver.com/v/4100472";
    private static final String bohemian_path = "https://tv.naver.com/v/3973465";
    private static final String dark_figure_path = "https://tv.naver.com/v/4100472";
    private static final String halloween_path = "https://tv.naver.com/v/4188292";
    private static final String strangers_path = "https://tv.naver.com/v/4030078";
    private static final String missbaek_path = "https://tv.naver.com/v/4075184";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse( "http://youtu.be/" + "qHmQE93hVmA" ));

        startActivity( intent );

        // 창궐 qHmQE93hVmA
        // 보헤미안 랩소디 XTZko22Ze3o
        // 할로윈 KbkWuEbACDM
        // 미쓰백 EywPeg8BqyY
        // 암수살인 dfnKOAmaQM8
        // 완벽한타인 UWdeFywycs


    }
}
