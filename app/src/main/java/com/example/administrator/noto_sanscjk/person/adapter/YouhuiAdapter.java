package com.example.administrator.noto_sanscjk.person.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.person.bean.Youhui;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 2018/5/3.
 */

public class YouhuiAdapter extends BaseAdapter {

    private Context context;
    private List<Youhui> list;
    private YouhuiViewHolder holder;

    public YouhuiAdapter(Context context, List<Youhui> list) {
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

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            holder = new YouhuiViewHolder();

            convertView=View.inflate(context, R.layout.item_youhui,null);

            holder.title=convertView.findViewById(R.id.title);
            holder.qian=convertView.findViewById(R.id.qian);
            holder.jiazhi =convertView.findViewById(R.id.jiazhi);
            holder.money=convertView.findViewById(R.id.money);
            holder.shiyong=convertView.findViewById(R.id.shiyong);
            holder.text_time=convertView.findViewById(R.id.text_time);

            holder.youhui_img=convertView.findViewById(R.id.youhui_img);

            convertView.setTag(holder);

        }else {

            holder = (YouhuiViewHolder) convertView.getTag();
        }

        holder.title.setText(list.get(position).getTitle());

        int background = list.get(position).getBackground();

        if (background == 0) {

            Resources resources = context.getResources();
            Drawable drawable = resources.getDrawable(R.drawable.youhui_t);
            holder.youhui_img.setBackground(drawable);
            holder.shiyong.setText("未使用");

            holder.qian.setTextColor(context.getResources().getColor(R.color.black));
            holder.shiyong.setTextColor(context.getResources().getColor(R.color.black));
            holder.money.setTextColor(context.getResources().getColor(R.color.black));
            holder.title.setTextColor(context.getResources().getColor(R.color.black));
            holder.text_time.setTextColor(context.getResources().getColor(R.color.black));


        }else if (background == 1) {

            Resources resources = context.getResources();
            Drawable drawable = resources.getDrawable(R.drawable.youhui_f);
            holder.youhui_img.setBackground(drawable);
            holder.qian.setTextColor(context.getResources().getColor(R.color.youhui));
            holder.shiyong.setTextColor(context.getResources().getColor(R.color.youhui));
            holder.money.setTextColor(context.getResources().getColor(R.color.youhui));
            holder.title.setTextColor(context.getResources().getColor(R.color.youhui));
            holder.text_time.setTextColor(context.getResources().getColor(R.color.youhui));
            holder.shiyong.setText("已过期");
        }

        return convertView;
    }

    static class YouhuiViewHolder{
        ImageView youhui_img;
        TextView title,jiazhi,qian,text_time,money,shiyong;

    }
}
