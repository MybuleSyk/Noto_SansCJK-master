package com.example.administrator.noto_sanscjk.trading.activity;

import android.print.PageRange;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.customize.MyListView;
import com.example.administrator.noto_sanscjk.trading.adapter.LiuyanAdapter;
import com.example.administrator.noto_sanscjk.trading.bean.Liuyan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */


public class XZxiangqingActivity extends BaseActivity{

    private MyListView liuyanlist;
    private List<Liuyan> list=new ArrayList<Liuyan>();

    @Override
    protected int intiLayout() {
        return R.layout.activity_xzxq;
    }

    @Override
    public void initView() {

        liuyanlist=findViewById(R.id.liuyan_list);
        liuyanlist.setOnTouchListener(new View.OnTouchListener() {
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

        for (int i = 0; i < 3; i++) {


            Liuyan liuyan=new Liuyan();

            liuyan.setName("按时的"+i);

            list.add(liuyan);
        }

        LiuyanAdapter adapter=new LiuyanAdapter(this,list);

        liuyanlist.setAdapter(adapter);


    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
