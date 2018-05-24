package com.example.administrator.noto_sanscjk.wrench.activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.wrench.adapter.MainAdapter;
import com.example.administrator.noto_sanscjk.wrench.adapter.MoreAdapter;
import com.example.administrator.noto_sanscjk.wrench.bean.Bean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/4.
 */

public class XuanzeXHActivity extends BaseActivity{

    private List<Bean.AddressEntity> mainList;
    private MoreAdapter moreAdapter;
    private ListView morelist;
    private ListView mainlist;
    private MainAdapter mainAdapter;

    @Override
    protected int intiLayout() {
        return R.layout.activity_wxxh;
    }

    @Override
    public void initView() {

        mainlist = findViewById(R.id.classify_mainlist);
        morelist = findViewById(R.id.classify_morelist);

        initModle();
        mainAdapter = new MainAdapter(this, mainList);
        mainAdapter.setSelectItem(0);
        mainlist.setAdapter(mainAdapter);
        mainlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                List<String> lists = mainList.get(position).getArea();
                initAdapter(lists);
                mainAdapter.setSelectItem(position);
                mainAdapter.notifyDataSetChanged();
            }
        });
        mainlist.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // 一定要设置这个属性，否则ListView不会刷新
        initAdapter(mainList.get(0).getArea());

    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {

        morelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String s = (String) moreAdapter.getItem(position);
//                Toast.makeText(getApplicationContext(), s, 1).show();
                Toast.makeText(XuanzeXHActivity.this, s, Toast.LENGTH_SHORT).show();
                moreAdapter.setSelectItem(position);
                moreAdapter.notifyDataSetChanged();
//变为手动输入这个就没有用了
//                Intent intent=new Intent(XuanzeXHActivity.this,LoginActivity.class);
//
//                startActivity(intent);
            }
        });


    }

    private void initAdapter(List<String> lists) {
        moreAdapter = new MoreAdapter(this, lists);
        morelist.setAdapter(moreAdapter);
        moreAdapter.notifyDataSetChanged();
    }
    private void initModle() {
        mainList = new ArrayList<Bean.AddressEntity>();
        Gson gson = new Gson();
        String json = "{\"result\":\"Y\", \"address\":[{\"name\":\"手机\",\"custId\":\""
                + R.mipmap.ic_launcher
                + "\", \"area\":[\"三星\",\"华为\",\"OPPO\",\"小米\",\"苹果\"]},{\"name\":\"空调\", \"custId\":\""
                + R.mipmap.ic_launcher
                + "\",\"area\":[\"海尔\",\"美的\",\"格力\",\"哈哈哈\",\"静安区\",\"其他\"]}]}";
        java.lang.reflect.Type type = new TypeToken<Bean>() {
        }.getType();
        Bean b = gson.fromJson(json, type);
        mainList.addAll(b.getAddress());
    }


}
