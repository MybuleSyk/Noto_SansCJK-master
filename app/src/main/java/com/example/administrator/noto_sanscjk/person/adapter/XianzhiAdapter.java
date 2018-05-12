package com.example.administrator.noto_sanscjk.person.adapter;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.person.bean.Xianzhi;

import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */

public class XianzhiAdapter extends BaseAdapter {


    private Context context;
    private List<Xianzhi> list;
    private XzViewHolder holder;

    public XianzhiAdapter(Context context, List<Xianzhi> list) {
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

            holder = new XzViewHolder();
            convertView=View.inflate(context, R.layout.item_xianzhi,null);

            holder.buy=convertView.findViewById(R.id.buy);

            convertView.setTag(holder);

        }else {

            holder = (XzViewHolder) convertView.getTag();
        }


        holder.buy.setText(list.get(position).getBuy());

        return convertView;
    }

    static class XzViewHolder{

        TextView buy;


    }
}
