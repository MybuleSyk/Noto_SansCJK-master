package com.example.administrator.noto_sanscjk.wrench.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.hotspots.adapter.HotDianAdapter;
import com.example.administrator.noto_sanscjk.wrench.bean.Img;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/9.
 */

public class RecycImgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<Img> list=new ArrayList<Img>();
    private OnItemClickListener onItemClickListener;
    private OnItemChahaoClickListener onItemChahaoClickListener;

    public RecycImgAdapter(Context context, List<Img> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.item_recycimg, null);

        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        // TODO: 2018/5/9 string转int

        ViewHolder holder1= (ViewHolder) holder;

        Glide.with(context).load(list.get(position).getImgRoad()).into(holder1.tak_img);

        holder1.tak_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onItemClickListener.onItemClick(v,position);

            }
        });

        holder1.chahao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onItemChahaoClickListener.onItemClick(v,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView tak_img,chahao;

        public ViewHolder(View itemView) {
            super(itemView);

            tak_img = itemView.findViewById(R.id.tak_img);
            chahao = itemView.findViewById(R.id.chahao);

        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnChahaoItemClickListener(OnItemChahaoClickListener onItemClickListener) {
        this.onItemChahaoClickListener = onItemClickListener;
    }

    public interface OnItemChahaoClickListener{
        void onItemClick(View view, int position);
    }

}
