package com.example.administrator.noto_sanscjk.home.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.home.bean.Shopxx;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by LiYRong on 2018/5/15.
 */

public class ShopXXActivity extends BaseActivity{

    private TextView shopxx_titile;
    private TextView shopxx_address;
    private TextView shop_desc;
    private TextView shopxx_tip;
    private ImageView shopxx_img;
    private String id;
    private Shopxx.DataBean dataBean=new Shopxx.DataBean();
    private String token;
    private String userid;


    @Override
    protected int intiLayout() {
        return R.layout.activity_shopxx;
    }

    @Override
    public void initView() {

        shopxx_titile = findViewById(R.id.shopxx_titile);
        shopxx_address = findViewById(R.id.address);
        shop_desc = findViewById(R.id.shop_desc);
        shopxx_tip = findViewById(R.id.tip);
        shopxx_img = findViewById(R.id.shopxximg);

        SharedPreferences loginshare = getSharedPreferences("login", MODE_PRIVATE);

        token = loginshare.getString("token", "");
        userid = loginshare.getString("id", "");

        Intent intent = getIntent();

        id = intent.getStringExtra("id");

        Log.e("TAG","token"+"==="+token+"id"+"===="+id);

        String url="http://api.xfg666.com/index.php/shop/shop";

        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("usertoken", token)
                                .build();

                        return chain.proceed(request);
                    }
                }).build();

        FormBody from=new FormBody.Builder()
                .add("id",id)
                .build();
        Request request=new Request.Builder().url(url)
                .post(from)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String string = response.body().string();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Log.e("TAG",string+"=====");

                        Gson gson=new Gson();

                        Shopxx shopxx = gson.fromJson(string, Shopxx.class);

                        dataBean=shopxx.getData();
                        shopxx_titile.setText(dataBean.getShopcompay());

                        shopxx_tip.setText(dataBean.getTip());

                        shopxx_address.setText(dataBean.getAddress());

                        shop_desc.setText(dataBean.getShop_desc());

                        String imgurl="http://api.xfg666.com";

                        Glide.with(ShopXXActivity.this).load(imgurl+dataBean.getShopimg()).into(shopxx_img);

                    }
                });

            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
