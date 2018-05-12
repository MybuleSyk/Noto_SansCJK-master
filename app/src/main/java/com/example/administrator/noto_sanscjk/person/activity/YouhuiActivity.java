package com.example.administrator.noto_sanscjk.person.activity;

import android.view.View;
import android.widget.ListView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.person.adapter.YouhuiAdapter;
import com.example.administrator.noto_sanscjk.person.bean.Youhui;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/3.
 */

public class YouhuiActivity extends BaseActivity {

    private ListView listview;
    private List<Youhui> youhuiList=new ArrayList<Youhui>();

    @Override
    protected int intiLayout() {
        return R.layout.activity_youhui;
    }

    @Override
    public void initView() {

        listview = findViewById(R.id.youhuilist);

        for (int i = 0; i < 2; i++) {

            Youhui youhui=new Youhui();

            youhui.setTitle("维修屏幕送挂坠"+i);

            youhui.setBackground(i);

            youhuiList.add(youhui);
        }

        YouhuiAdapter adapter=new YouhuiAdapter(this,youhuiList);

        listview.setAdapter(adapter);


    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
