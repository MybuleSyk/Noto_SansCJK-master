package com.example.administrator.noto_sanscjk.trading.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.trading.bean.Liuyan;

import java.util.List;

/**
 * Created by Administrator on 2018/5/5.
 */

public class LiuyanAdapter extends BaseAdapter {

    private Context context;
    private List<Liuyan> list;
    private LiuyanViewHolder holder;

    public LiuyanAdapter(Context context, List<Liuyan> list) {
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

            convertView = View.inflate(context, R.layout.item_liuyan, null);
            holder = new LiuyanViewHolder();

            holder.liuyanname=convertView.findViewById(R.id.liuyan_name);

            convertView.setTag(holder);

        }else {

            holder = (LiuyanViewHolder) convertView.getTag();
        }


        holder.liuyanname.setText(list.get(position).getName());

        return convertView;
    }

    static class LiuyanViewHolder{

        TextView liuyanname;

    }
}
