package com.example.administrator.noto_sanscjk.person.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.person.adapter.AddressAdapter;
import com.example.administrator.noto_sanscjk.person.bean.Address;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.administrator.noto_sanscjk.R.id.addresslist;

/**
 * Created by Administrator on 2018/4/26.
 */

public class AddressActivity extends BaseActivity{

    private ListView addresslistview;
    private AddressAdapter adapter;
    private String token;
    private String userid;
    private Button add_but;
    private List<Address.DataBean.ListBean> addressList=new ArrayList<>();

    @Override
    protected int intiLayout() {
        return R.layout.activity_address;
    }

    @Override
    public void initView() {
        addresslistview = findViewById(addresslist);
        add_but=findViewById(R.id.add_but);

        SharedPreferences loginshare = getSharedPreferences("login", MODE_PRIVATE);

        token = loginshare.getString("token", "");

        userid = loginshare.getString("id", "");

        Log.e("TAG",token+"======"+userid);

    }

    @Override
    public void initData() {

        initaddress();

    }
    @Override
    public void initListener() {

        add_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(AddressActivity.this,AddAddressActivity.class);

                startActivity(intent);

                finish();

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.notifyDataSetChanged();

    }

    public void initaddress(){

        addressList.clear();

        adapter = new AddressAdapter(this,addressList);

        addresslistview.setAdapter(adapter);

        String url="http://api.xfg666.com/index.php/user/address_list";

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
                .add("userid",userid)
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

                        Log.e("TAG",string+"====");

                        Gson gson=new Gson();

                        Address address = gson.fromJson(string, Address.class);

                        if (address.getError_code() == 300) {

                            Intent intent=new Intent(AddressActivity.this,AddAddressActivity.class);
                            startActivity(intent);

                            finish();

                        }else if (address.getError_code() == 200){

                            addressList.addAll(address.getData().getList());

                            adapter.notifyDataSetChanged();

                        }
                    }
                });
            }
        });
    }


}
