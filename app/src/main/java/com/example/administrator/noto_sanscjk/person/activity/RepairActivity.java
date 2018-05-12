package com.example.administrator.noto_sanscjk.person.activity;

import android.view.View;
import android.widget.ListView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.person.adapter.RepairAdapter;
import com.example.administrator.noto_sanscjk.person.bean.Reapair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */

public class RepairActivity extends BaseActivity{

    private ListView repairlist;
    private List<Reapair> list=new ArrayList<Reapair>();

    @Override
    protected int intiLayout() {
        return R.layout.activity_repair;
    }

    @Override
    public void initView() {

        repairlist = findViewById(R.id.repairlist);

        for (int i = 0; i < 3; i++) {

            Reapair reapair=new Reapair();
            reapair.setName("手机屏幕损坏"+i);
            list.add(reapair);

        }

        RepairAdapter adapter=new RepairAdapter(this,list);

        repairlist.setAdapter(adapter);
        
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
