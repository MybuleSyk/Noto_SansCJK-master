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
 * Created by Administrator on 2018/4/26.
 */

public class HomeFiveAdapter extends RecyclerView.Adapter<HomeFiveAdapter.ViewHolder>{

    private Context context;
    private List<Index.DataBean.ListFiveBean> list;

    public HomeFiveAdapter(Context context, List<Index.DataBean.ListFiveBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.item_homerecyc, null);

        ViewHolder holder=new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(list.get(position).getName());
        holder.price.setText(list.get(position).getPrice());

        holder.shop_img.setType(ImageViewRoundOval.TYPE_ROUND);
        holder.shop_img.setRoundRadius(10);//矩形凹行大小

        String imgurl="http://api.xfg666.com";

        Glide.with(context).load(imgurl+list.get(position).getImg()).into(holder.shop_img);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,price;
        ImageViewRoundOval shop_img;

        public ViewHolder(View itemView) {
            super(itemView);

             name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
             shop_img=itemView.findViewById(R.id.shop_img);
        }
    }

}
