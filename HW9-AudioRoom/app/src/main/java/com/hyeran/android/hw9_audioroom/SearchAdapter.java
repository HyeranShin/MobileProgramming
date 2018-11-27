package com.hyeran.android.hw9_audioroom;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class SearchAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;
    private List<Integer> indexlist;
    private LayoutInflater inflater;
    private ViewHolder viewHolder;

    public SearchAdapter(List<String> list, List<Integer> indexlist, Context context) {
        this.list = list;
        this.indexlist = indexlist;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
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
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_list, null);

            viewHolder = new ViewHolder();
            viewHolder.label = convertView.findViewById(R.id.tv_label);
            viewHolder.index = convertView.findViewById(R.id.tv_index);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 리스트에 있는 데이터를 리스트뷰 셀에 뿌린다.
        viewHolder.label.setText(list.get(position));
        viewHolder.index.setText(indexlist.get(position)+"");

        final String index = viewHolder.index.getText().toString();

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SongActivity.class);
                intent.putExtra("index", index);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class ViewHolder{
        public TextView label;
        public TextView index;
    }
}
