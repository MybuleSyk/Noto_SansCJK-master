package com.example.administrator.noto_sanscjk.wrench.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.wrench.bean.Shangjia;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class ShangjiaAdapter extends BaseAdapter {

    private Context context;
    private List<Shangjia> list;
    private ViewHolder holder;

    public ShangjiaAdapter(Context context, List<Shangjia> list) {
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

            convertView= View.inflate(context, R.layout.item_dengshangjia, null);

            holder.juli_text=convertView.findViewById(R.id.juli_text);

            convertView.setTag(holder);


        }else {
           holder= (ViewHolder) convertView.getTag();

        }

        holder.juli_text.setText(list.get(position).getJuli());

        return convertView;
    }

    static class ViewHolder{

        TextView juli_text;

    }
}
