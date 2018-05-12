package com.example.administrator.noto_sanscjk.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.zhy.autolayout.AutoLayoutActivity;



/**
 * Created by Administrator on 2018/4/24.
 */

public abstract  class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(intiLayout());

        initView();

        initData();

        initListener();


    }

    protected abstract int intiLayout();

    public abstract void initView();

    public abstract void initData();

    public abstract void initListener();
}
