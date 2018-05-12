package com.example.administrator.noto_sanscjk.home.activity;

import android.util.Log;
import android.widget.ListView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.home.adapter.WXCXlistAdapter;
import com.example.administrator.noto_sanscjk.home.bean.WXCX;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiYRong on 2018/5/12.
 */

public class WXchaxunActivity extends BaseActivity {

    private ListView wxcx_listview;
    private List<WXCX> wxcxList=new ArrayList<WXCX>();
    private WXCXlistAdapter adapter;

    @Override
    protected int intiLayout() {
        return R.layout.activity_wxcx;
    }

    @Override
    public void initView() {

        wxcx_listview = findViewById(R.id.wxcx_listview);

        for (int i = 0; i < 2; i++) {

            WXCX wxcx=new WXCX();

            wxcx.setType(i);

            wxcxList.add(wxcx);
        }

        Log.e("TAG",wxcxList.size()+"=============");

        adapter=new WXCXlistAdapter(this,wxcxList);

        wxcx_listview.setAdapter(adapter);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
