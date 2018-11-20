package com.hyeran.android.hw8;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

import io.realm.Realm;

public class AddActivity extends AppCompatActivity {

    Realm realm;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        init();

        Button video = findViewById(R.id.btn_video_add);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(intent);
            }
        });

        Button select = findViewById(R.id.btn_select_add);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSelectMovie();
            }
        });

        final EditText editText = findViewById(R.id.et_title_add);

        Button btnOk = findViewById(R.id.btn_ok_add);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(editText.getText().toString());
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void insertData(String title) {
        RealmVO realmVO = new RealmVO();
        realm.beginTransaction();
        realmVO.title = title;
        realmVO.filename = name;
        realm.copyToRealm(realmVO);
        realm.commitTransaction();
    }

    public void init() {
        Realm.init(getBaseContext());
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        super.onActivityResult(requestCode, resultCode, intent);

        if (resultCode == RESULT_OK)
        {
            if (requestCode == 2)
            {
                Uri uri = intent.getData();
                name = getName(uri);
            }
        }

        VideoView videoView = findViewById(R.id.vv_add);
        MediaController mediaController = new MediaController(this);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        videoView.setVideoPath(path+"/DCIM/Camera/"+name);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        videoView.start();

    }

    // 동영상선택
    private void doSelectMovie()
    {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.setType("video/*");
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        try
        {
            startActivityForResult(i, 2);
        } catch (android.content.ActivityNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    // 파일명 찾기
    private String getName(Uri uri)
    {
        String[] projection = { MediaStore.Images.ImageColumns.DISPLAY_NAME };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.ImageColumns.DISPLAY_NAME);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}
