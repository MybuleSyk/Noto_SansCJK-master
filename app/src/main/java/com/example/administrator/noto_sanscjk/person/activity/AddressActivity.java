package com.example.administrator.noto_sanscjk.person.activity;

import android.widget.ListView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.person.adapter.AddressAdapter;
import com.example.administrator.noto_sanscjk.person.bean.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */

public class AddressActivity extends BaseActivity{

    private ListView addresslist;
    private List<Address> list=new ArrayList<Address>();
    private AddressAdapter adapter;

    @Override
    protected int intiLayout() {
        return R.layout.activity_address;
    }

    @Override
    public void initView() {
        addresslist = findViewById(R.id.addresslist);
    }

    @Override
    public void initData() {

        for (int i = 0; i < 6; i++) {

            Address address=new Address();

            address.setName("北辰东街与永安路交口北500米"+i);

            list.add(address);


        }

        adapter = new AddressAdapter(this,list);

        addresslist.setAdapter(adapter);


    }

    @Override
    public void initListener() {

    }
}
