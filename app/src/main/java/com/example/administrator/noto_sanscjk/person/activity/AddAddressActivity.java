package com.example.administrator.noto_sanscjk.person.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.person.bean.AddAddress;
import com.example.administrator.noto_sanscjk.person.bean.JsonBean;
import com.example.administrator.noto_sanscjk.person.bean.JsonFileReader;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by LiYRong on 2018/5/16.
 */

public class AddAddressActivity extends BaseActivity {


    private EditText contact;
    private EditText mobile;
    private TextView city;
    private EditText address;
    private String token;
    private String userid;
    private TextView save_but;
    private LinearLayout province;
    private ArrayList<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();
    private String userprovince;
    private String usercity;
    private String userdistreet;
    private String addressid;


    @Override
    protected int intiLayout() {
        return R.layout.activity_addadress;
    }

    @Override
    public void initView() {

        contact=findViewById(R.id.contact);
        mobile=findViewById(R.id.mobile);
        save_but=findViewById(R.id.save_but);
        province=findViewById(R.id.province);
        city=findViewById(R.id.city);
        address=findViewById(R.id.address);
        SharedPreferences loginshare = getSharedPreferences("login", MODE_PRIVATE);

        token = loginshare.getString("token", "");

        userid = loginshare.getString("id", "");

        initJsonData();

        // TODO: 2018/5/16 编辑地址的数据
        Intent intent = getIntent();

        addressid = intent.getStringExtra("addressid");

        Log.e("TAG", addressid +"=====");

        if (addressid != null) {
            String usercontact = intent.getStringExtra("contact");
            String usermobile = intent.getStringExtra("mobile");
            String useraddress = intent.getStringExtra("address");
            String subprovince = intent.getStringExtra("province");
            String subcity = intent.getStringExtra("city");
            String subdistreet = intent.getStringExtra("distreet");
            contact.setText(usercontact);
            mobile.setText(usermobile);
            city.setText(useraddress);

        }

    }

    // TODO: 2018/5/16 编辑地址的网络请求

    private void intnetsub() {


        String usercontact = contact.getText().toString().trim();
        String usermobile = mobile.getText().toString().trim();
        String useraddress = address.getText().toString().trim();

        String url="http://api.xfg666.com/index.php/user/address_edit_sub";

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
                .add("address_id",addressid)
                .add("mobile",usermobile)
                .add("province",userprovince)
                .add("city",usercity)
                .add("distreet",userdistreet)
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

                        Log.e("TAG",string+"=====");

//                        AddAddress addAddress = gson.fromJson(string, AddAddress.class);
//
//                        if (addAddress.getError_code() == 200) {
//
//                            Toast.makeText(AddAddressActivity.this, "地址修改成功！", Toast.LENGTH_SHORT).show();
//
//                            Intent intent=new Intent(AddAddressActivity.this,AddressActivity.class);
//
//                            startActivity(intent);
//
//                            finish();
//                        }

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

        save_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    InitWork();


            }
        });

        province.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPickerView();
            }

        });

    }

    private void showPickerView() {
        OptionsPickerView pvOptions=new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置

                userprovince = options1Items.get(options1).getPickerViewText();
                usercity = options2Items.get(options1).get(options2);
                userdistreet = options3Items.get(options1).get(options2).get(options3);
                String text = options1Items.get(options1).getPickerViewText() +
                        options2Items.get(options1).get(options2) +
                        options3Items.get(options1).get(options2).get(options3);
                city.setText(text);
            }
        }).setTitleText("")
                .setDividerColor(Color.GRAY)
                .setTextColorCenter(Color.GRAY)
                .setContentTextSize(22)
                .setOutSideCancelable(false)
                .build();
          /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private void initJsonData() {   //解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        //  获取json数据
        String JsonData = JsonFileReader.getJson(this, "province_data.json");
        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<String> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<String>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < jsonBean.get(i).getCityList().size(); c++) {//遍历该省份的所有城市
                String CityName = jsonBean.get(i).getCityList().get(c).getName();
                CityList.add(CityName);//添加城市

                ArrayList<String> City_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getCityList().get(c).getArea() == null
                        || jsonBean.get(i).getCityList().get(c).getArea().size() == 0) {
                    City_AreaList.add("");
                } else {

                    for (int d = 0; d < jsonBean.get(i).getCityList().get(c).getArea().size(); d++) {//该城市对应地区所有数据
                        String AreaName = jsonBean.get(i).getCityList().get(c).getArea().get(d);

                        City_AreaList.add(AreaName);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(CityList);

            /**
             * 添加地区数据
             */
            options3Items.add(Province_AreaList);
        }
    }

    public ArrayList<JsonBean> parseData(String result) {//Gson 解析
        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }

    public void InitWork(){


        String usercontact = contact.getText().toString().trim();
        String usermobile = mobile.getText().toString().trim();
        String useraddress = address.getText().toString().trim();

        String url="http://api.xfg666.com/index.php/user/address_add_sub";

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
                .add("contact",usercontact)
                .add("mobile",usermobile)
                .add("address",useraddress)
                .add("province",userprovince)
                .add("city",usercity)
                .add("distreet",userdistreet)
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

                        AddAddress addAddress = gson.fromJson(string, AddAddress.class);

                        if (addAddress.getError_code() == 200) {

                            Toast.makeText(AddAddressActivity.this, "地址添加成功！", Toast.LENGTH_SHORT).show();

                            Intent intent=new Intent(AddAddressActivity.this,AddressActivity.class);

                            startActivity(intent);

                            finish();
                        }
                    }
                });
            }
        });
    }

}
