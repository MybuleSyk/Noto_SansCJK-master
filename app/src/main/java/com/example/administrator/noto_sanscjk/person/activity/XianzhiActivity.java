package com.example.administrator.noto_sanscjk.person.activity;

import android.view.View;
import android.widget.ListView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.person.adapter.XianzhiAdapter;
import com.example.administrator.noto_sanscjk.person.bean.Xianzhi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */

public class XianzhiActivity extends BaseActivity {

    private ListView xianzhilist;
    private List<Xianzhi> list=new ArrayList<Xianzhi>();
    private XianzhiAdapter adapter;

    @Override
    protected int intiLayout() {
        return R.layout.activity_xianzhi;
    }

    @Override
    public void initView() {

        xianzhilist = findViewById(R.id.xianzhilist);

        for (int i = 0; i < 3; i++) {

            Xianzhi xian=new Xianzhi();

            xian.setBuy("卖："+i);

            list.add(xian);
        }

        adapter = new XianzhiAdapter(this,list);

        xianzhilist.setAdapter(adapter);


    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
