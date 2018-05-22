package com.example.administrator.noto_sanscjk.wrench.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.customize.MyListView;
import com.example.administrator.noto_sanscjk.customize.RecycleViewDivider;
import com.example.administrator.noto_sanscjk.wrench.adapter.DengdaiAdapter;
import com.example.administrator.noto_sanscjk.wrench.adapter.ShangjiaAdapter;
import com.example.administrator.noto_sanscjk.wrench.bean.Dengdai;
import com.example.administrator.noto_sanscjk.wrench.bean.Shangjia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class DengdaiActivity extends BaseActivity {

    private RecyclerView dengdai_recyclerview;
    private MyListView dengdai_listview;
    private List<Dengdai> list = new ArrayList<Dengdai>();
    private List<Shangjia> shajialist = new ArrayList<Shangjia>();

    @Override
    protected int intiLayout() {
        return R.layout.activity_dengdai;
    }

    @Override
    public void initView() {
        dengdai_recyclerview = findViewById(R.id.dengdai_recyclerview);
        dengdai_listview = findViewById(R.id.dengdai_listview);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        dengdai_recyclerview.setLayoutManager(linearLayoutManager);

        dengdai_recyclerview.addItemDecoration(new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL));

        for (int i = 0; i < 3; i++) {

            Dengdai dengdai = new Dengdai();

            dengdai.setShiping("1000");
            dengdai.setTuwen("100");
            dengdai.setYuyin("10");
            dengdai.setType(i);

            list.add(dengdai);
        }

        for (int i = 0; i < 3; i++) {

            Shangjia shangjia = new Shangjia();
            shangjia.setJuli("距离" + i + "米");

            shajialist.add(shangjia);

        }

        DengdaiAdapter adapter = new DengdaiAdapter(this, list);

        dengdai_recyclerview.setAdapter(adapter);

        ShangjiaAdapter shangadapter = new ShangjiaAdapter(this, shajialist);

/*
* 解决了和ScrollView的滑动冲突
* */
        dengdai_listview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });

        dengdai_listview.setAdapter(shangadapter);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
