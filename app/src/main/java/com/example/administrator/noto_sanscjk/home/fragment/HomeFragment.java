package com.example.administrator.noto_sanscjk.home.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseFragment;
import com.example.administrator.noto_sanscjk.customize.IntentUtil;
import com.example.administrator.noto_sanscjk.customize.ObservableScrollView;
import com.example.administrator.noto_sanscjk.customize.OkhttpUtils;
import com.example.administrator.noto_sanscjk.home.activity.ShoplistActivity;
import com.example.administrator.noto_sanscjk.home.activity.WXchaxunActivity;
import com.example.administrator.noto_sanscjk.home.adapter.HomeFiveAdapter;
import com.example.administrator.noto_sanscjk.home.adapter.HomeFourAdapter;
import com.example.administrator.noto_sanscjk.home.adapter.HomeOneAdapter;
import com.example.administrator.noto_sanscjk.home.adapter.HomeSixAdapter;
import com.example.administrator.noto_sanscjk.home.adapter.HomeThreeAdapter;
import com.example.administrator.noto_sanscjk.home.adapter.HomeTowAdapter;
import com.example.administrator.noto_sanscjk.home.bean.Index;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    private RecyclerView mobilephoneview;
    private RecyclerView theplugredview;
    private RecyclerView circuitview;
    private RecyclerView dateview;
    private RecyclerView printerview;
    private RecyclerView maintainredview;
    private ImageView more;
    private Button xiadan_but;
    private Button chaxun;
    private LinearLayout line;
    private ObservableScrollView scrollView;
    private int imageHeight = 300; //设置渐变高度，一般为导航图片高度，自己控制
    private OnButtonClick onButtonClick;//2、定义接口成员变量
    private List<Index.DataBean.ListFiveBean> listFiveBeanList=new ArrayList<>();
    private List<Index.DataBean.ListOneBean> listOneBeanList=new ArrayList<>();
    private List<Index.DataBean.ListTwoBean> listTwoBeanList=new ArrayList<>();
    private List<Index.DataBean.ListThreeBean> listThreeBeanList=new ArrayList<>();
    private List<Index.DataBean.ListFourBean> listFourBeanList=new ArrayList<>();
    private List<Index.DataBean.ListSixBean> listSixBeanList=new ArrayList<>();

    private TextView duo_1;
    private TextView duo_2;
    private TextView duo_3;
    private TextView duo_4;
    private TextView duo_5;
    private TextView duo_6;

    @Override
    protected void initview() {


        listFiveBeanList.clear();
        listOneBeanList.clear();
        listTwoBeanList.clear();
        listThreeBeanList.clear();
        listFourBeanList.clear();
        listSixBeanList.clear();
    }

    @Override
    protected void initdata() {

        String url = "http://api.xfg666.com/index.php/index/index";

        OkhttpUtils instance = OkhttpUtils.getInstance();

        instance.getNetData(url, new OkhttpUtils.CallBacks() {
            @Override
            public void getString(String ss) {

                Gson gson = new Gson();

                Index index = gson.fromJson(ss, Index.class);

                List<Index.DataBean.ListFiveBean> list_five = index.getData().getList_five();

                List<Index.DataBean.ListOneBean> list_one = index.getData().getList_one();

                List<Index.DataBean.ListTwoBean> list_two = index.getData().getList_two();

                List<Index.DataBean.ListThreeBean> list_three = index.getData().getList_three();

                List<Index.DataBean.ListFourBean> list_four = index.getData().getList_four();

                List<Index.DataBean.ListSixBean> list_six=index.getData().getList_six();

                listOneBeanList.addAll(list_one);

                listTwoBeanList.addAll(list_two);

                listFiveBeanList.addAll(list_five);

                listThreeBeanList.addAll(list_three);

                listFourBeanList.addAll(list_four);

                listSixBeanList.addAll(list_six);


                Log.e("TAG",listFiveBeanList.get(0).getName());


            }
        });
    }

    // TODO: 2018/4/26 点击事件只能在这个方法里面写

    @Override
    protected View initlayout() {

        final View inflate = View.inflate(getActivity(), R.layout.fragment_home, null);

        mobilephoneview = inflate.findViewById(R.id.recyclview);
        theplugredview = inflate.findViewById(R.id.recyclview1);
        circuitview = inflate.findViewById(R.id.recyclview2);
        dateview = inflate.findViewById(R.id.recyclview3);
        printerview = inflate.findViewById(R.id.recyclview4);
        maintainredview = inflate.findViewById(R.id.recyclview5);
        xiadan_but = inflate.findViewById(R.id.xiadan_but);

        duo_1 = inflate.findViewById(R.id.duo_1);
        duo_2 = inflate.findViewById(R.id.duo_2);
        duo_3 = inflate.findViewById(R.id.duo_3);
        duo_4 = inflate.findViewById(R.id.duo_4);
        duo_5 = inflate.findViewById(R.id.duo_5);
        duo_6 = inflate.findViewById(R.id.duo_6);

        duo_1.setOnClickListener(this);
        duo_2.setOnClickListener(this);
        duo_3.setOnClickListener(this);
        duo_4.setOnClickListener(this);
        duo_5.setOnClickListener(this);
        duo_6.setOnClickListener(this);

        more = inflate.findViewById(R.id.moreright);
        chaxun = inflate.findViewById(R.id.chaxun);
        line = inflate.findViewById(R.id.line);
        scrollView = inflate.findViewById(R.id.scrollView);
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
        HomeOneAdapter adapter = new HomeOneAdapter(getActivity(),listOneBeanList);
        mobilephoneview.setLayoutManager(linearLayoutManager);
        mobilephoneview.setAdapter(adapter);



        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        HomeTowAdapter adapter1=new HomeTowAdapter(getActivity(),listTwoBeanList);
        theplugredview.setLayoutManager(linearLayoutManager1);
        theplugredview.setAdapter(adapter1);



        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        HomeThreeAdapter adapter2=new HomeThreeAdapter(getActivity(),listThreeBeanList);
        circuitview.setLayoutManager(linearLayoutManager2);
        circuitview.setAdapter(adapter2);



        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getActivity());
        linearLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        HomeFourAdapter adapter3=new HomeFourAdapter(getActivity(),listFourBeanList);
        dateview.setLayoutManager(linearLayoutManager3);
        dateview.setAdapter(adapter3);



        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getActivity());
        linearLayoutManager4.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        HomeFiveAdapter adapter4=new HomeFiveAdapter(getActivity(),listFiveBeanList);
        printerview.setLayoutManager(linearLayoutManager4);
        printerview.setAdapter(adapter4);



        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(getActivity());
        linearLayoutManager5.setOrientation(LinearLayoutManager.HORIZONTAL);//横向滚动的RecycleView
        HomeSixAdapter adapter5=new HomeSixAdapter(getActivity(),listSixBeanList);
        maintainredview.setLayoutManager(linearLayoutManager5);
        maintainredview.setAdapter(adapter5);


        xiadan_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//4、如果接口成员变量不为空null，则调用接口变量的方法。
                if (onButtonClick != null) {
                    onButtonClick.onClick(xiadan_but);
                }

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

    //定义接口变量的get方法
    public OnButtonClick getOnButtonClick() {
        return onButtonClick;
    }

    //定义接口变量的set方法
    public void setOnButtonClick(OnButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.duo_1:

                Intent intent=new Intent(getActivity(), ShoplistActivity.class);

                intent.putExtra("catid","1");

                intent.putExtra("title","手机维修");

                startActivity(intent);

                break;
            case R.id.duo_2:

                Intent intent1=new Intent(getActivity(), ShoplistActivity.class);

                intent1.putExtra("catid","2");

                intent1.putExtra("title","家电维修");

                startActivity(intent1);

                break;
            case R.id.duo_3:

                Intent intent2=new Intent(getActivity(), ShoplistActivity.class);

                intent2.putExtra("catid","3");

                intent2.putExtra("title","管道电路");

                startActivity(intent2);

                break;
            case R.id.duo_4:

                Intent intent3=new Intent(getActivity(), ShoplistActivity.class);

                intent3.putExtra("catid","4");

                intent3.putExtra("title","数据恢复");

                startActivity(intent3);

                break;
            case R.id.duo_5:


                Intent intent4=new Intent(getActivity(), ShoplistActivity.class);

                intent4.putExtra("catid","5");

                intent4.putExtra("title","办公设备");

                startActivity(intent4);


                break;
            case R.id.duo_6:



                Intent intent5=new Intent(getActivity(), ShoplistActivity.class);

                intent5.putExtra("catid","6");

                intent5.putExtra("title","闲置买卖");

                startActivity(intent5);


                break;



        }


    }

    //1、定义接口
    public interface OnButtonClick {
        public void onClick(View view);
    }

}
