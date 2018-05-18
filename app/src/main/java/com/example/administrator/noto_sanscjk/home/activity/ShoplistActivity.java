package com.example.administrator.noto_sanscjk.home.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.home.adapter.ShoplistAdapter;
import com.example.administrator.noto_sanscjk.home.bean.ShopList;
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

import static com.example.administrator.noto_sanscjk.R.id.shanglist;

/**
 * Created by LiYRong on 2018/5/15.
 */

public class ShoplistActivity extends BaseActivity {

    private ListView shanglistview;
    private String catid;
    private List<ShopList.DataBean> shangLists=new ArrayList<ShopList.DataBean>();
    private String title;
    private TextView weixiu_text;
    private ShoplistAdapter adapter;
    private String token;

    @Override
    protected int intiLayout() {
        return R.layout.activity_shanglist;
    }

    @Override
    public void initView() {


        SharedPreferences loginshare = getSharedPreferences("login", MODE_PRIVATE);

        token = loginshare.getString("token", "");

        String id = loginshare.getString("id", "");

        weixiu_text = findViewById(R.id.weixiu_text);

        shanglistview = findViewById(shanglist);

        Intent intent = getIntent();

        catid = intent.getStringExtra("catid");

        Log.e("TAG",catid+"=======");

        title = intent.getStringExtra("title");

        weixiu_text.setText(title);

        shangLists.clear();

        adapter = new ShoplistAdapter(this,shangLists);

        shanglistview.setAdapter(adapter);

    }

    @Override
    public void initData() {

        String url="http://api.xfg666.com/index.php/shop/shop_list";

            OkHttpClient client=new OkHttpClient.Builder()
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request()
                                .newBuilder()
                                .addHeader("usertoken",token)
                                    .build();

                            return chain.proceed(request);
                        }
                    }).build();

            FormBody from=new FormBody.Builder()
                    .add("cat_id",catid)
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

                        Gson gson=new Gson();

                        ShopList shangList = gson.fromJson(string, ShopList.class);

                        shangLists.addAll(shangList.getData());

                        adapter.notifyDataSetChanged();


                    }
                });
            }
        });
    }

    @Override
    public void initListener() {


        shanglistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(ShoplistActivity.this, "点击了", Toast.LENGTH_SHORT).show();

                Intent intent1=new Intent(ShoplistActivity.this,ShopXXActivity.class);

                intent1.putExtra("id",shangLists.get(i).getId()+"");

                startActivity(intent1);

            }
        });


    }
}
