package com.example.administrator.noto_sanscjk.wrench.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.hotspots.adapter.HotDianAdapter;
import com.example.administrator.noto_sanscjk.hotspots.bean.HotDian;
import com.example.administrator.noto_sanscjk.wrench.bean.Dengdai;

import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class DengdaiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;
    private List<Dengdai> list;

    public DengdaiAdapter(Context context, List<Dengdai> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holer = null;

        switch (viewType) {

            case Dengdai.TUWEN:

                view = LayoutInflater.from(context).inflate(R.layout.item_dengdaituwen, null);
                holer = new TuwenViewHolder(view);

                break;
            case Dengdai.YUYIN:

                view = LayoutInflater.from(context).inflate(R.layout.item_dengdaiyuyin, null);
                holer = new YuyinViewHolder(view);

                break;
            case Dengdai.SHIPING:

                view = LayoutInflater.from(context).inflate(R.layout.item_dengdaishiping, null);
                holer = new ShipingViewHolder(view);

                break;
        }

        return holer;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){

            case Dengdai.TUWEN:

                TuwenViewHolder holder1= (TuwenViewHolder) holder;

                holder1.tuwen_text.setText(list.get(position).getTuwen());
                break;
            case Dengdai.YUYIN:

                YuyinViewHolder holder2= (YuyinViewHolder) holder;

                holder2.yuyin_text.setText(list.get(position).getYuyin());
                break;
            case Dengdai.SHIPING:

                ShipingViewHolder holder3= (ShipingViewHolder) holder;

                holder3.shiping_text.setText(list.get(position).getShiping());
                break;

        }

    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class TuwenViewHolder extends RecyclerView.ViewHolder {

        private TextView tuwen_text;

        public TuwenViewHolder(View itemView) {
            super(itemView);

            tuwen_text=itemView.findViewById(R.id.tuwen_text);

        }
    }

    static class YuyinViewHolder extends RecyclerView.ViewHolder {
        private TextView yuyin_text;
        public YuyinViewHolder(View itemView) {
            super(itemView);
            yuyin_text=itemView.findViewById(R.id.yuyin_text);
        }
    }

    static class ShipingViewHolder extends RecyclerView.ViewHolder {
        private TextView shiping_text;
        public ShipingViewHolder(View itemView) {
            super(itemView);

            shiping_text=itemView.findViewById(R.id.shiping_text);
        }
    }
}
