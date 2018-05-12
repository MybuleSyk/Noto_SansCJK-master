package com.example.administrator.noto_sanscjk.person.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.person.bean.Address;
import com.example.administrator.noto_sanscjk.person.bean.Reapair;

import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */

public class RepairAdapter extends BaseAdapter {

    private Context context;
    private List<Reapair> list;
    private ViewHolder holder;

    public RepairAdapter(Context context, List<Reapair> list) {
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

            convertView = View.inflate(context, R.layout.item_repairlist, null);

            holder.repairname=convertView.findViewById(R.id.repairname);

            convertView.setTag(holder);

        }else {

            holder = (ViewHolder) convertView.getTag();
        }


        holder.repairname.setText(list.get(position).getName());

        return convertView;
    }

    static class ViewHolder{

        TextView repairname;

    }
}
