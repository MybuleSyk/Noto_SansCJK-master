package com.example.administrator.noto_sanscjk.trading.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.trading.bean.Goumai;

import java.util.List;

/**
 * Created by Administrator on 2018/5/5.
 */

public class GoumaiAdapter extends BaseAdapter {

    private Context context;
    private List<Goumai> list;
    private GoumaiViewHolder holder;

    public GoumaiAdapter(Context context, List<Goumai> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {

            convertView = View.inflate(context, R.layout.item_goumai, null);

            holder = new GoumaiViewHolder();

            holder.name=convertView.findViewById(R.id.goumai_name);

            convertView.setTag(holder);

        }else {

            holder = (GoumaiViewHolder) convertView.getTag();
        }

        holder.name.setText(list.get(position).getName());


        return convertView;
    }
    static class GoumaiViewHolder{

        private TextView name;

    }
}
