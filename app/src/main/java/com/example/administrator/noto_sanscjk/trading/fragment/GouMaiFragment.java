package com.example.administrator.noto_sanscjk.trading.fragment;

import android.view.View;
import android.widget.ListView;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseFragment;
import com.example.administrator.noto_sanscjk.trading.adapter.GoumaiAdapter;
import com.example.administrator.noto_sanscjk.trading.bean.Goumai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/5.
 */

public class GouMaiFragment extends BaseFragment {

    private ListView goumailist;
    private List<Goumai> goumais=new ArrayList<Goumai>();

    @Override
    protected void initview() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {

        View inflate = View.inflate(getActivity(), R.layout.fragment_goumai, null);

        goumailist = inflate.findViewById(R.id.gouamilist);

        for (int i = 0; i < 2; i++) {
            Goumai goumai=new Goumai();

            goumai.setName("阿西吧"+i);

            goumais.add(goumai);

        }

        GoumaiAdapter adapter=new GoumaiAdapter(getActivity(),goumais);

        goumailist.setAdapter(adapter);

        return inflate;
    }

    @Override
    protected void restartdata() {

    }
}
