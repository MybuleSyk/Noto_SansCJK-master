package com.example.administrator.noto_sanscjk.hotspots.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.hotspots.bean.HotDian;

import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */

public class HotDianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<HotDian> list;
    private OnItemClickListener onItemClickListener;

    public HotDianAdapter(Context context, List<HotDian> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        RecyclerView.ViewHolder holer = null;

        switch (viewType) {

            case HotDian.YITU:

                view = LayoutInflater.from(context).inflate(R.layout.item_yitu, null);
                holer = new YituViewHolder(view);

                break;
            case HotDian.SANTU:

                view = LayoutInflater.from(context).inflate(R.layout.item_santu, null);
                holer = new SantuViewHolder(view);

                break;
            case HotDian.SHIPING:

                view = LayoutInflater.from(context).inflate(R.layout.item_shiping, null);
                holer = new ShipingViewHolder(view);

                break;
        }

        return holer;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        switch (getItemViewType(position)) {

            case HotDian.YITU:

                final YituViewHolder holder1 = (YituViewHolder) holder;

                holder1.yituname.setText(list.get(position).getYituname());

                holder1.yituname.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        onItemClickListener.onItemClick(holder1.itemView,position);

                    }
                });
                break;
            case HotDian.SANTU:

                SantuViewHolder holder2 = (SantuViewHolder) holder;
                holder2.santuname.setText(list.get(position).getSantuname());
                break;
            case HotDian.SHIPING:

                ShipingViewHolder holder3 = (ShipingViewHolder) holder;
                holder3.shipingname.setText(list.get(position).getShipingnname());
                break;

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }

    static class YituViewHolder extends RecyclerView.ViewHolder  {

        private TextView yituname;

        public YituViewHolder(View itemView) {
            super(itemView);
            yituname = itemView.findViewById(R.id.yituname);
        }


    }

    static class SantuViewHolder extends RecyclerView.ViewHolder  {
        private TextView santuname;
        public SantuViewHolder(View itemView) {
            super(itemView);

            santuname = itemView.findViewById(R.id.santuname);
        }

    }

    static class ShipingViewHolder extends RecyclerView.ViewHolder {

        private TextView shipingname;

        public ShipingViewHolder(View itemView) {
            super(itemView);

            shipingname = itemView.findViewById(R.id.shipingname);
        }


    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
}
