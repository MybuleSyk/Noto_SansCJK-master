package com.example.administrator.noto_sanscjk.home.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.customize.ImageViewRoundOval;
import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.home.bean.Recyc;

import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */

public class HomeRcycyAdapter extends RecyclerView.Adapter<HomeRcycyAdapter.ViewHolder>{

    private Context context;
    private List<Recyc> list;

    public HomeRcycyAdapter(Context context, List<Recyc> list) {
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

        holder.shop_img.setType(ImageViewRoundOval.TYPE_ROUND);
        holder.shop_img.setRoundRadius(10);//矩形凹行大小

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageViewRoundOval shop_img;

        public ViewHolder(View itemView) {
            super(itemView);

             name = itemView.findViewById(R.id.name);
             shop_img=itemView.findViewById(R.id.shop_img);
        }
    }

}
