package com.example.administrator.noto_sanscjk.trading.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;

import java.util.List;

/**
 * Created by LiYRong on 2018/5/2.
 */

public class SXianzhiAdapter extends BaseAdapter {
    private Context context;
    private List list;
    private ViewHolder holder;

    public SXianzhiAdapter(Context context, List list) {
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

            holder = new ViewHolder();

            convertView = View.inflate(context, R.layout.item_sxianzhi, null);
   holder.addressname=convertView.findViewById(R.id.name);

            convertView.setTag(holder);

        }else {

            holder = (ViewHolder) convertView.getTag();
        }
holder.addressname.setText(list.get(position)+"");



        return convertView;
    }

    static class ViewHolder{

        TextView addressname;

    }
}

