package com.example.administrator.noto_sanscjk.login;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                                    Log.e("TAG",string);
// TODO: 2018/5/4 这里的bean类不对 重新的接口
//                                    Gson gson=new Gson();
//                                    Login login = gson.fromJson(string, Login.class);
//
//                                    loginbean=login;
////                                    Log.e("TAG",loginbean.getCode()+"");
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
                String username = name.getText().toString().trim();
                if (!username.equals("")&&!getCode.equals("")) {
                    int code = loginbean.getCode();
                    Log.e("TAG",code+"");
                    int edcode = Integer.parseInt(getCode);
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

                                        Log.e("TAG",string+"==============");

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
