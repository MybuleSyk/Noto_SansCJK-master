package com.example.administrator.noto_sanscjk.trading.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseFragment;
import com.example.administrator.noto_sanscjk.customize.IntentUtil;
import com.example.administrator.noto_sanscjk.trading.activity.FaBuActivity;
import com.example.administrator.noto_sanscjk.trading.activity.XZxiangqingActivity;
import com.example.administrator.noto_sanscjk.trading.activity.XinXiActivity;
import com.example.administrator.noto_sanscjk.trading.adapter.SXianzhiAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/4/25.
 */

public class TradingFragment extends BaseFragment {

    private ArrayList<String> list= new ArrayList();
    private ImageView fabu_img;
    private ImageView xinxi_img;

    @Override
    protected void initview() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {
        View inflate = View.inflate(getActivity(), R.layout.fragment_trading, null);
        ListView listview = inflate.findViewById(R.id.my_listviw);
        fabu_img = inflate.findViewById(R.id.fabu_img);
        xinxi_img = inflate.findViewById(R.id.xinxi_img);

        for (int i = 0; i < 5; i++) {
            list.add("sss"+i);
        }
        SXianzhiAdapter xianzhiAdaputer= new SXianzhiAdapter(getActivity(),list);

        listview.setAdapter(xianzhiAdaputer);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                IntentUtil.intentToNull(getActivity(), XZxiangqingActivity.class);

            }
        });

        fabu_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentUtil.intentToNull(getActivity(), FaBuActivity.class);

            }
        });
        xinxi_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentUtil.intentToNull(getActivity(), XinXiActivity.class);

            }
        });


        return inflate;
    }

    @Override
    protected void restartdata() {

    }
}
