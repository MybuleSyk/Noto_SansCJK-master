package com.example.administrator.noto_sanscjk.person.adapter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.person.bean.Address;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2018/4/26.
 */

public class AddressAdapter extends BaseAdapter {

    private Activity context;
    private List<Address.DataBean.ListBean> list;
    private ViewHolder holder;
    private String token;
    private String userid;
    private int tempPosition = -1;  //记录已经点击的CheckBox的位置

    public AddressAdapter(Activity context, List<Address.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if (convertView == null) {

            holder = new ViewHolder();

            convertView = View.inflate(context, R.layout.item_addreslist, null);

            holder.consignee = convertView.findViewById(R.id.consignee);

            holder.mobile = convertView.findViewById(R.id.mobile);

            holder.adressname = convertView.findViewById(R.id.adressname);

            holder.delete = convertView.findViewById(R.id.delete);

            holder.sub_address = convertView.findViewById(R.id.sub_address);

            holder.select = convertView.findViewById(R.id.select);

            convertView.setTag(holder);

        } else {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.consignee.setText(list.get(position).getConsignee());

        holder.mobile.setText(list.get(position).getMobile());

        holder.adressname.setText(list.get(position).getAddress());


        final String is_select = list.get(position).getIs_select();

        if (is_select.equals("1")) {

            holder.select.setBackgroundResource(R.drawable.frame_t);

        } else {

            holder.select.setBackgroundResource(R.drawable.frame_f);

        }


        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("TAG", position + "===");

                holder.select.setBackgroundResource(R.drawable.frame_t);

                httpselect(list.get(position).getAddress_id());

                notifyDataSetChanged();

            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                httpDelet(list.get(position).getAddress_id());

                list.remove(position);

                notifyDataSetChanged();

            }
        });

        // TODO: 2018/5/16 编辑地址

//        holder.sub_address.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent=new Intent(context, AddAddressActivity.class);
//
//                intent.putExtra("addressid",list.get(position).getAddress_id());
//                intent.putExtra("contact",list.get(position).getConsignee());
//                intent.putExtra("mobile",list.get(position).getMobile());
//                intent.putExtra("address",list.get(position).getAddress());
//                intent.putExtra("province",list.get(position).getProvince());
//                intent.putExtra("city",list.get(position).getCity());
//                intent.putExtra("distreet",list.get(position).getDistreet());
//                context.startActivity(intent);
//
//            }
//        });

        return convertView;
    }

    static class ViewHolder {

        TextView consignee, mobile, adressname;

        LinearLayout delete, sub_address;

        Button select;

    }

    public void httpDelet(String addressid) {

        SharedPreferences loginshare = context.getSharedPreferences("login", MODE_PRIVATE);

        token = loginshare.getString("token", "");

        userid = loginshare.getString("id", "");


        String url = "http://api.xfg666.com/index.php/user/address_del";

        OkHttpClient client = new OkHttpClient.Builder()
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

        FormBody from = new FormBody.Builder()
                .add("userid", userid)
                .add("address_id", addressid)
                .build();
        Request request = new Request.Builder().url(url)
                .post(from)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String string = response.body().string();

                Log.e("TAG", string);
            }
        });
    }

    public void httpselect(String address_id) {


        SharedPreferences loginshare = context.getSharedPreferences("login", MODE_PRIVATE);

        token = loginshare.getString("token", "");

        userid = loginshare.getString("id", "");

        String url = "http://api.xfg666.com/index.php/user/address_select";

        OkHttpClient client = new OkHttpClient.Builder()
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

        FormBody from = new FormBody.Builder()
                .add("userid", userid)
                .add("address_id", address_id)
                .build();
        Request request = new Request.Builder().url(url)
                .post(from)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.e("TAG", "设为默认地址失败！");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                String string = response.body().string();

                Log.e("TAG", "设为默认地址成功！" + string);

            }
        });
    }

    //返回当前CheckBox选中的位置,便于获取值.
    public int getSelectPosition() {
        return tempPosition;
    }

}
