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

public class WoFabuFragment extends BaseFragment {

    private ListView fabulist;
    private List<Goumai> goumais=new ArrayList<Goumai>();

    @Override
    protected void initview() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {
        View inflate = View.inflate(getActivity(), R.layout.fragment_wofabu, null);

        fabulist = inflate.findViewById(R.id.fabulist);

        for (int i = 0; i < 2; i++) {
            Goumai goumai=new Goumai();

            goumai.setName("事实上"+i);

            goumais.add(goumai);

        }

        GoumaiAdapter adapter=new GoumaiAdapter(getActivity(),goumais);

        fabulist.setAdapter(adapter);



        return inflate;
    }

    @Override
    protected void restartdata() {

    }
}
