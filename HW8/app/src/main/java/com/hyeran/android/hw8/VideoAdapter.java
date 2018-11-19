package com.hyeran.android.hw8;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<RealmVO> realmVOS;

    public VideoAdapter(ArrayList<RealmVO> realmVOS) {
        this.realmVOS = realmVOS;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return new VideolistViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VideolistViewHolder videolistViewHolder = (VideolistViewHolder) holder;

        videolistViewHolder.title.setText(realmVOS.get(position).title);
    }

    @Override
    public int getItemCount() {
        return realmVOS.size();
    }

    public class VideolistViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public VideolistViewHolder(View itemView) {
            super(itemView);

            itemView.findViewById(R.id.tv_videotitle_item);
        }
    }
}
