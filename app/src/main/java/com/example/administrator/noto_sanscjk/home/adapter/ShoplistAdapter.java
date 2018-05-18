package com.example.administrator.noto_sanscjk.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.home.bean.ShopList;

import java.util.List;

/**
 * Created by LiYRong on 2018/5/15.
 */

public class ShoplistAdapter extends BaseAdapter {


    private Context context;

    private List<ShopList.DataBean> list;
    private ViewHolder holder;

    public ShoplistAdapter(Context context, List<ShopList.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {

            view= View.inflate(context, R.layout.item_shoplist, null);

            holder = new ViewHolder();

            holder.shopcompay=view.findViewById(R.id.shopcompay);

            holder.shopimg=view.findViewById(R.id.shopimg);

            view.setTag(holder);

        }else {

            holder = (ViewHolder) view.getTag();

        }


        holder.shopcompay.setText(list.get(i).getName());

        String imgurl="http://api.xfg666.com";

        Glide.with(context).load(imgurl+list.get(i).getShopimg()).into(holder.shopimg);


        return view;
    }

    static class ViewHolder{

        TextView shopcompay;
        ImageView shopimg;


    }
}
