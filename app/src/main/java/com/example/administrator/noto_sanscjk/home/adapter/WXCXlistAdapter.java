package com.example.administrator.noto_sanscjk.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.home.bean.WXCX;

import java.util.List;

/**
 * Created by LiYRong on 2018/5/12.
 */

public class WXCXlistAdapter extends BaseAdapter {

    private Context context;
    private List<WXCX> list;
    private WCViewHolder wcViewHolder;

    final int WANCHENG = 0;
    final int MEIWAN = 1;
    private MWViewHolder mwViewHolder;


    public WXCXlistAdapter(Context context, List<WXCX> list) {
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {


        int type = list.get(position).getType();

        if (convertView == null) {

            switch (type){

                case WANCHENG:

                    convertView=View.inflate(context, R.layout.item_wxcxt,null);

                    wcViewHolder=new WCViewHolder();

                    wcViewHolder.wancheng_text=convertView.findViewById(R.id.wancheng_text);

                    convertView.setTag(wcViewHolder);

                    break;

                case MEIWAN:

                    convertView=View.inflate(context, R.layout.item_wxcxf,null);

                    mwViewHolder = new MWViewHolder();

                    mwViewHolder.zhaungtai_text=convertView.findViewById(R.id.zhuangtai_text);

                    convertView.setTag(mwViewHolder);

                    break;

            }


        }else {

            switch (type){

                case WANCHENG:

                    wcViewHolder = (WCViewHolder) convertView.getTag();

                    break;

                case MEIWAN:
                    mwViewHolder = (MWViewHolder) convertView.getTag();

                    break;


            }

        }


        switch (type){

            case WANCHENG:

                wcViewHolder.wancheng_text.setText("维修完成");

                break;

            case MEIWAN:

                mwViewHolder.zhaungtai_text.setText("维修中...");

                break;

        }


        return convertView;
    }

    static class WCViewHolder{

        private TextView wancheng_text;


    }
    static class MWViewHolder{

        private TextView zhaungtai_text;


    }

    @Override
    public int getItemViewType(int position) {
        int p=position;
        //这里我们修改的是对应头item和底部item
        if (p == 0)
            return WANCHENG;
        else
            return MEIWAN;
    }

    /**
     * 该方法返回多少个不同的布局
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }


}
