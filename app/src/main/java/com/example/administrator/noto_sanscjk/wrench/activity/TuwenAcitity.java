package com.example.administrator.noto_sanscjk.wrench.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.noto_sanscjk.MainActivity;
import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.customize.IntentUtil;
import com.example.administrator.noto_sanscjk.wrench.adapter.RecycImgAdapter;
import com.example.administrator.noto_sanscjk.wrench.bean.Img;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/5/3.
 */

public class TuwenAcitity extends BaseActivity{

    private ImageView tuwen_back;
    private ImageView xuanze_img;
    private Button tuwen_but;
    private RecyclerView recycy_img;
    private ArrayList<Img> imgs=new ArrayList<Img>();
    private RecycImgAdapter adapter;
    private ImageView wu_img;
    private String url="http://api.xfg666.com/index.php/user/user_need";

    @Override
    protected int intiLayout() {
        return R.layout.activity_tuwen;
    }
    @Override
    public void initView() {

        tuwen_back = findViewById(R.id.tuwen_back);
        xuanze_img = findViewById(R.id.xuanze_img);
        tuwen_but = findViewById(R.id.tuwen_but);
        recycy_img=findViewById(R.id.recycy_img);
        wu_img=findViewById(R.id.wu_img);

        if (imgs.size() == 0) {

            recycy_img.setVisibility(View.GONE);

            wu_img.setVisibility(View.VISIBLE);
        }

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycy_img.setLayoutManager(linearLayoutManager);

        adapter = new RecycImgAdapter(this,imgs);

        recycy_img.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecycImgAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent=new Intent(TuwenAcitity.this,TakeptoActivity.class);

                startActivityForResult(intent,100);

            }
        });

        adapter.setOnChahaoItemClickListener(new RecycImgAdapter.OnItemChahaoClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                imgs.remove(imgs.get(position));

                adapter.notifyDataSetChanged();

                if (imgs.size() == 0) {

                    recycy_img.setVisibility(View.GONE);

                    wu_img.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

        tuwen_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentUtil.intentToNull(TuwenAcitity.this, MainActivity.class);

                finish();
            }
        });
        xuanze_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentUtil.intentToNull(TuwenAcitity.this, XuanzeXHActivity.class);

                finish();
            }
        });

        tuwen_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentUtil.intentToNull(TuwenAcitity.this, DengdaiActivity.class);

                finish();
            }
        });

        wu_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wu_img.setVisibility(View.GONE);

                recycy_img.setVisibility(View.VISIBLE);

                Intent intent=new Intent(TuwenAcitity.this,TakeptoActivity.class);

                startActivityForResult(intent,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==100&&resultCode == 200) {

            Bundle extras = data.getExtras();

            ArrayList<Img> imglist = (ArrayList<Img>) extras.getSerializable("imglist");

            imgs.addAll(imglist);

            Log.e("TAG",imgs.size()+"");

            if (imgs.size()>3) {
                imgs.remove(imgs.size()-1);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "最多上传三张图片", Toast.LENGTH_SHORT).show();

            }else {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (imgs.size() == 0) {

            recycy_img.setVisibility(View.GONE);

            wu_img.setVisibility(View.VISIBLE);
        }else {
            recycy_img.setVisibility(View.VISIBLE);

            wu_img.setVisibility(View.GONE);

        }
    }
}
