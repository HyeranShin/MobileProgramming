package com.hyeran.android.part3_2_4_tablayout;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
    TabHost myTabHost = null;   //TabHost 객체 선언
    TabHost.TabSpec spec;       //TabSpec 객체 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTabHost = getTabHost();

        //Tab 추가
        spec = myTabHost.newTabSpec("Artists").setIndicator("Artists").setContent(R.id.TextView01);
        myTabHost.addTab(spec);

        spec = myTabHost.newTabSpec("Albums").setIndicator("Albums").setContent(R.id.TextView02);
        myTabHost.addTab(spec);

        spec = myTabHost.newTabSpec("Songs").setIndicator("Songs").setContent(R.id.TextView03);
        myTabHost.addTab(spec);

        myTabHost.setCurrentTab(0);
    }
}
