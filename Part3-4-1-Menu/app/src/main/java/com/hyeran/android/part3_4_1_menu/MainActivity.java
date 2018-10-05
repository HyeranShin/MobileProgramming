package com.hyeran.android.part3_4_1_menu;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Group No.
    public static final int ID_GROUP_TEXT_COLOR = 1;
    public static final int ID_GROUP_TEXT_STYLE = 2;
    public static final int ID_GROUP_TEXT_SIZE = 3;
    public static final int ID_GROUP_ARTIST = 4;
    public static final int ID_GROUP_ALBUM = 5;
    public static final int ID_GROUP_SONG = 6;
    public static final int ID_GROUP_MOVIE = 7;

    // Text Color Item No.
    public static final int ID_COLOR_RED = 11;
    public static final int ID_COLOR_GREEN = 12;
    public static final int ID_COLOR_BLUE = 13;

    // Text Style Item No.
    public static final int ID_TEXT_NORMAL = 21;
    public static final int ID_TEXT_BOLD = 22;
    public static final int ID_TEXT_ITALIC = 23;

    // Text Size Item No.
    public static final int ID_TEXT_20P = 31;
    public static final int ID_TEXT_30P = 32;
    public static final int ID_TEXT_40P = 33;

    // 1st 삽입
    TextView objTxView; // TextView 객체 선언
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    // 나 자신의 액티비티 생성
        // super(기존에 돌던 거) 저장하고 화면 생성
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 초기화 - 객체 생성

        // 2nd 삽입
        objTxView = findViewById(R.id.textView1);
        layout = findViewById(R.id.layout);
        // findViewById - 레이아웃에 선언한 태그 부르기
        registerForContextMenu(layout);  // Context menu 제공
    }

    // ========================== Menu ==========================
    // 3rd 3개의 method 추가
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        SubMenu mnuTextColor = menu.addSubMenu("Text Color");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_RED, 1, "Red");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_GREEN, 2, "Green");
        mnuTextColor.add(ID_GROUP_TEXT_COLOR, ID_COLOR_BLUE, 3, "Blue");

        SubMenu mnuTextStyle = menu.addSubMenu("Text Style");
        mnuTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_NORMAL, 1, "Normal").setChecked(true);
        mnuTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_BOLD, 2, "Bold");
        mnuTextStyle.add(ID_GROUP_TEXT_STYLE, ID_TEXT_ITALIC, 3, "Italic");
        mnuTextStyle.setGroupCheckable(ID_GROUP_TEXT_SIZE, true, true);

        SubMenu mnuTextSize = menu.addSubMenu("Text Size");
        mnuTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXT_20P, 1, "20pt");
        mnuTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXT_30P, 2, "30pt");
        mnuTextSize.add(ID_GROUP_TEXT_SIZE, ID_TEXT_40P, 3, "40pt");

        SubMenu etc = menu.addSubMenu("Etc");

        SubMenu mnuArtist = etc.addSubMenu("Artist");
        mnuArtist.setIcon(R.drawable.img1);

        SubMenu mnuAlbum = etc.addSubMenu("Album");
        mnuAlbum.setIcon(R.drawable.img2);

        SubMenu mnuSong = etc.addSubMenu("Song");
        mnuSong.setIcon(R.drawable.img3);

        SubMenu mnuMovie = etc.addSubMenu("Movie");
        mnuMovie.setIcon(R.drawable.img4);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case ID_COLOR_RED:
                objTxView.setTextColor(Color.RED);
                return true;
            case ID_COLOR_GREEN:
                objTxView.setTextColor(Color.GREEN);
                return true;
            case ID_COLOR_BLUE:
                objTxView.setTextColor(Color.BLUE);
                return true;
            case ID_TEXT_NORMAL:
                objTxView.setTypeface(Typeface.DEFAULT, Typeface.NORMAL);
                return true;
            case ID_TEXT_BOLD:
                objTxView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
                return true;
            case ID_TEXT_ITALIC:
                objTxView.setTypeface(Typeface.DEFAULT, Typeface.ITALIC);
                return true;
            case ID_TEXT_20P:
                objTxView.setTextSize(20);
                return true;
            case ID_TEXT_30P:
                objTxView.setTextSize(30);
                return true;
            case ID_TEXT_40P:
                objTxView.setTextSize(40);
                return true;
        }

//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    // ========================== Context Menu ==========================
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        SubMenu mnuTextBackGroundColor = menu.addSubMenu("Layout Background");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_RED, Menu.NONE, "RED");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_GREEN, Menu.NONE, "GREEN");
        mnuTextBackGroundColor.add(Menu.NONE, ID_COLOR_BLUE, Menu.NONE, "BLUE");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case ID_COLOR_RED:
                layout.setBackgroundColor(Color.RED);
                return true;
            case ID_COLOR_BLUE:
                layout.setBackgroundColor(Color.BLUE);
                return true;
            case ID_COLOR_GREEN:
                layout.setBackgroundColor(Color.GREEN);
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
