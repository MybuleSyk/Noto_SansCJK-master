package com.example.administrator.noto_sanscjk.hotspots;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.customize.RecycleViewDivider;
import com.example.administrator.noto_sanscjk.base.BaseFragment;
import com.example.administrator.noto_sanscjk.hotspots.adapter.HotDianAdapter;
import com.example.administrator.noto_sanscjk.hotspots.bean.HotDian;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */

public class HotspotsFragment extends BaseFragment {


    private List<HotDian> hotDianList = new ArrayList<HotDian>();

    @Override
    protected void initview() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {
        View inflate = View.inflate(getActivity(), R.layout.fragment_hotspots, null);

        RecyclerView recyclerView = inflate.findViewById(R.id.Redainview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);//横向滚动的RecycleView

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new RecycleViewDivider(getActivity(),LinearLayoutManager.HORIZONTAL));


        for (int i = 0; i < 3; i++) {
            HotDian hotDian = new HotDian();
            hotDian.setType(i);
            // TODO: 2018/5/3 如果字数太少图片会变小
            hotDian.setYituname("我是一张图片我是一张图片我是一张图片我是一张图片我是一张图片我是一张图片");
            hotDian.setSantuname("我是三张图片");
            // TODO: 2018/5/3 给的是固定的高
            hotDian.setShipingnname("我是视频");
            Log.e("TAG", i + "=================");
            hotDianList.add(hotDian);
        }

        HotDianAdapter adapter = new HotDianAdapter(getActivity(), hotDianList);

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new HotDianAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Toast.makeText(getActivity(), "你点击了我", Toast.LENGTH_SHORT).show();

            }
        });

        return inflate;
    }

    @Override
    protected void restartdata() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        hotDianList.clear();
    }

}
