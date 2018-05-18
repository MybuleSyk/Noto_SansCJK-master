package com.example.administrator.noto_sanscjk.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.noto_sanscjk.MainActivity;
import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.login.bean.Login;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/4/24.
 *
 * 这是登录页面
 */

public class LoginActivity extends BaseActivity {

    private Button login;
    private EditText name;
    private EditText password;
    private Button getcode;
    private String number;
    private Login loginbean=new Login();
    private String getCode;

    @Override
    protected int intiLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

        login = findViewById(R.id.login);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        getcode = findViewById(R.id.getcode);

        SharedPreferences loginshare = getSharedPreferences("login", MODE_PRIVATE);

        String token = loginshare.getString("token", "");

        String id = loginshare.getString("id", "");


        Log.e("TAG",token+"======"+id);


        if (!token.equals("")) {

            Intent intent=new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("token",token);

            intent.putExtra("id",id);
            startActivity(intent);

            finish();

        }

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {


        getcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = name.getText().toString().trim();

                if (!number .equals("")) {
                    //http://api.xfg666.com/index.php/sms/getcode/mobile
                    OkHttpClient client=new OkHttpClient();
                    String url="http://api.xfg666.com//index.php/sms/getcode?";
                    Request.Builder builder=new Request.Builder()
                            .url(url+"mobile="+number);
                    Request build = builder.build();

                    client.newCall(build).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {

                            final String string = response.body().string();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {


                                }
                            });
                        }
                    });
                }else {

                    Toast.makeText(LoginActivity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();

                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url="http://api.xfg666.com//index.php/user/login";

                getCode = password.getText().toString().trim();
                final String username = name.getText().toString().trim();
                if (!username.equals("")&&!getCode.equals("")) {
                    final int edcode = Integer.parseInt(getCode);
//                    if (edcode== code) {
                        Toast.makeText(LoginActivity.this, "==="+getCode, Toast.LENGTH_SHORT).show();

                        OkHttpClient client=new OkHttpClient();

                       FormBody from=new FormBody.Builder()
                               .add("mobile",username)
                               .add("code",getCode)
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
                                        Log.e("TAG",string);

                                        Gson gson=new Gson();
                                        Login login = gson.fromJson(string, Login.class);

                                        loginbean=login;

                                        if (loginbean.getError_code() == 200) {

                                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                                            SharedPreferences loginshare = getSharedPreferences("login", MODE_PRIVATE);

                                            SharedPreferences.Editor edit = loginshare.edit();

                                            edit.putString("token",loginbean.getData().getUserToken());
                                            edit.putString("id",loginbean.getData().getUserid());

                                            edit.commit();

                                            Intent intent=new Intent(LoginActivity.this, MainActivity.class);


                                            Toast.makeText(LoginActivity.this,loginbean.getData().getUsertoken(), Toast.LENGTH_SHORT).show();

                                            intent.putExtra("token",loginbean.getData().getUserToken());

                                            intent.putExtra("id",loginbean.getData().getUserid());
                                            startActivity(intent);



                                              }else if (loginbean.getError_code()==100){

                                            Toast.makeText(LoginActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();

                                        }

                                    }
                                });

                            }
                        });

//                    }else {
//
//                        Toast.makeText(LoginActivity.this, "验证码输入有误", Toast.LENGTH_SHORT).show();
//                    }

                }else{

                    Toast.makeText(LoginActivity.this, "验证码或者手机号不能为空", Toast.LENGTH_SHORT).show();

                }
            }
});

    }


}
