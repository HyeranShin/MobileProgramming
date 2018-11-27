package com.hyeran.android.hw9_audioroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Window;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/*
리스트 뷰 검색 기능 구현 참고 사이트
http://sharp57dev.tistory.com/11
 */

public class MainActivity extends AppCompatActivity {

    private List<String> list;
    private List<Integer> indexlist;
    private ListView listView;
    private EditText editSearch;
    private SearchAdapter searchAdapter;
    private ArrayList<String> arrayList;
    private ArrayList<Integer> arrayIndexList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        editSearch = findViewById(R.id.et_search);
        listView = findViewById(R.id.listview_main);

        list = new ArrayList<>();
        indexlist = new ArrayList<>();

        settingList();  // 데이터

        arrayList = new ArrayList<>(); // list 복사본
        arrayList.addAll(list);

        arrayIndexList = new ArrayList<>();
        arrayIndexList.addAll(indexlist);

        searchAdapter = new SearchAdapter(list, indexlist, this);
        listView.setAdapter(searchAdapter);

        // EditView 문자 입력 시 이벤트 리스터
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // 문자 입력할 때마다 호출
                String text = editSearch.getText().toString();
                search(text);
            }
        });


    }

    private void search(String text) {

        // 문자 입력할 때 마다 리스트 지우고 새로 뿌림
        list.clear();
        indexlist.clear();

        if (text.length() == 0) {   // 문자 입력이 없을 떄는 모든 데이터
            list.addAll(arrayList);
            indexlist.addAll(arrayIndexList);
        } else {
            for(int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).toLowerCase().contains(text)) {
                    list.add(arrayList.get(i));
                    indexlist.add(arrayIndexList.get(i));
                }
            }
        }
        // 아답터 갱신
        searchAdapter.notifyDataSetChanged();
    }

    private void settingList() {
        int stringId;
        for (int i=1; i<=20; i++) {
            stringId = getResources().getIdentifier("title" + i, "string", getPackageName());
            list.add(getResources().getString(stringId));
            indexlist.add(i);
        }
    }
}
