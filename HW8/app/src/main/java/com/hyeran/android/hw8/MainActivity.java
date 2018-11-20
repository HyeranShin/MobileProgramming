package com.hyeran.android.hw8;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import io.realm.Realm;

/*
비디오 가져오기 참고 링크
http://susemi99.tistory.com/887?category=328112
 */

public class MainActivity extends AppCompatActivity {
    Realm realm;
    RecyclerView recyclerView;

    static String title;
    static Context context;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getBaseContext();

        recyclerView = findViewById(R.id.rv_video_main);

        init();

        ImageButton imageButton = findViewById(R.id.ib_add_video_main);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        checkDangerousPermission();

    }

    public void init() {
        Realm.init(getBaseContext());
        realm = Realm.getDefaultInstance();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<RealmVO> realmVOS = new ArrayList<>(realm.where(RealmVO.class).findAll());
        VideoAdapter videoAdapter = new VideoAdapter(realmVOS);
        videoAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(videoAdapter);
    }

    private void checkDangerousPermission() {
        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for(int i=0; i<permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
//            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
//            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if(ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
//                Toast.makeText(this, "권한 설명 필요함", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }
}



