package com.example.administrator.noto_sanscjk.home.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.customize.ImageViewRoundOval;
import com.example.administrator.noto_sanscjk.home.bean.Index;

import java.util.List;

/**
 * Created by LiYRong on 2018/5/15.
 */

public class HomeOneAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<Index.DataBean.ListOneBean> list;

    public HomeOneAdapter(Context context, List<Index.DataBean.ListOneBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.item_homerecyc, null);

        OneViewHolder holder=new OneViewHolder(inflate);


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        OneViewHolder holder1= (OneViewHolder) holder;


        holder1.name.setText(list.get(position).getName());
        holder1.price.setText(list.get(position).getPrice());

        holder1.shop_img.setType(ImageViewRoundOval.TYPE_ROUND);
        holder1.shop_img.setRoundRadius(10);//矩形凹行大小

        String imgurl="http://api.xfg666.com";

        Glide.with(context).load(imgurl+list.get(position).getImg()).into(holder1.shop_img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class OneViewHolder extends RecyclerView.ViewHolder{

        TextView name,price;
        ImageViewRoundOval shop_img;

        public OneViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            shop_img=itemView.findViewById(R.id.shop_img);
        }
    }

}
