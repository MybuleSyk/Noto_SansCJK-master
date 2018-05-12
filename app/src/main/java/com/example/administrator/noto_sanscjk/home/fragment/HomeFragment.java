package com.example.administrator.noto_sanscjk.home.fragment;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseFragment;
import com.example.administrator.noto_sanscjk.customize.IntentUtil;
import com.example.administrator.noto_sanscjk.customize.ObservableScrollView;
import com.example.administrator.noto_sanscjk.home.activity.WXchaxunActivity;
import com.example.administrator.noto_sanscjk.home.adapter.HomeRcycyAdapter;
import com.example.administrator.noto_sanscjk.home.bean.Recyc;
import com.example.administrator.noto_sanscjk.wrench.WrenchFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */

public class HomeFragment extends BaseFragment{


    private RecyclerView mobilephoneview;
    private RecyclerView theplugredview;
    private RecyclerView circuitview;
    private RecyclerView dateview;
    private RecyclerView printerview;
    private RecyclerView maintainredview;
    private ImageView more;
    private Button xiadan_but;
    private List<Recyc> list=new ArrayList<Recyc>();
    private Button chaxun;
    private LinearLayout line;
    private ObservableScrollView scrollView;
    private int imageHeight=300; //设置渐变高度，一般为导航图片高度，自己控制

    @Override
    protected void initview() {

    }

    @Override
    protected void initdata() {

        for (int i = 0; i <4; i++) {
            Recyc recy=new Recyc();

            recy.setName("张三"+"="+i);

            list.add(recy);

        }

    }

    // TODO: 2018/4/26 点击事件只能在这个方法里面写

    @Override
    protected View initlayout() {

        View inflate = View.inflate(getActivity(), R.layout.fragment_home, null);

        mobilephoneview = inflate.findViewById(R.id.recyclview);
        theplugredview = inflate.findViewById(R.id.recyclview1);
        circuitview = inflate.findViewById(R.id.recyclview2);
        dateview = inflate.findViewById(R.id.recyclview3);
        printerview = inflate.findViewById(R.id.recyclview4);
        maintainredview = inflate.findViewById(R.id.recyclview5);
        xiadan_but = inflate.findViewById(R.id.xiadan_but);

        more = inflate.findViewById(R.id.moreright);

         chaxun= inflate.findViewById(R.id.chaxun);

        line=inflate. findViewById(R.id.line);
        scrollView=inflate. findViewById(R.id.scrollView);
        //搜索框在布局最上面
        line.bringToFront();
        //滑动监听
        scrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
                if (y <= 0) {
                    line.setBackgroundColor(Color.argb((int) 0, 227, 29, 26));//AGB由相关工具获得，或者美工提供
                } else if (y > 0 && y <= imageHeight) {
                    float scale = (float) y / imageHeight;
                    float alpha = (255 * scale);
                    // 只是layout背景透明
                    line.setBackgroundColor(getResources().getColor(R.color.white));
                } else {
                    line.setBackgroundColor(getResources().getColor(R.color.white));
                }
            }
        });

        // TODO: 2018/4/26 这里是圆角的图片

//        ZQImageViewRoundOval img = inflate.findViewById(R.id.img);
//
//        img.setType(ZQImageViewRoundOval.TYPE_ROUND);
//        img.setRoundRadius(10);//矩形凹行大小

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        HomeRcycyAdapter adapter=new HomeRcycyAdapter(getActivity(),list);
        mobilephoneview.setLayoutManager(linearLayoutManager);
        mobilephoneview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        theplugredview.setLayoutManager(linearLayoutManager1);
        theplugredview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        circuitview.setLayoutManager(linearLayoutManager2);
        circuitview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getActivity());
        linearLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        dateview.setLayoutManager(linearLayoutManager3);
        dateview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getActivity());
        linearLayoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        printerview.setLayoutManager(linearLayoutManager4);
        printerview.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(getActivity());
        linearLayoutManager5.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        maintainredview.setLayoutManager(linearLayoutManager5);
        maintainredview.setAdapter(adapter);


        xiadan_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: 2018/5/3 这里fragment跳转到fragment
                IntentUtil.intentToNull(getActivity(), WrenchFragment.class);

            }
        });

        chaxun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IntentUtil.intentToNull(getActivity(), WXchaxunActivity.class);


            }
        });


        return inflate;
    }

    @Override
    protected void restartdata() {

    }
}
