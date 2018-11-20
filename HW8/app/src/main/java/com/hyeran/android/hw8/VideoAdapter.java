package com.hyeran.android.hw8;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import io.realm.Realm;
import io.realm.RealmResults;


public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Realm realm;
    ArrayList<RealmVO> realmVOS;
    RealmResults<RealmVO> results;

    Context context;
    View v;
    TextView title;


    public VideoAdapter(ArrayList<RealmVO> realmVOS) {
        this.realmVOS = realmVOS;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);

        init();

        return new VideolistViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        title.setText(realmVOS.get(position).title);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoActivity.class);
                String name = realmVOS.get(position).filename;
                intent.putExtra("FILE", name);
                context.startActivity(intent);
            }
        });

        v.findViewById(R.id.ib_delete_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Realm.init(context);
                realm = Realm.getDefaultInstance();

                results = realm.where(RealmVO.class).equalTo("title", title.getText().toString()).findAll();
                realm.beginTransaction();
                results.deleteAllFromRealm();
                realm.commitTransaction();
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return realmVOS.size();
    }

    public class VideolistViewHolder extends RecyclerView.ViewHolder {


        public VideolistViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();

            title = itemView.findViewById(R.id.tv_videotitle_item);

        }
    }

    private void init() {
        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }
}
