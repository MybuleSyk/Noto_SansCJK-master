package com.example.administrator.noto_sanscjk.wrench;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.noto_sanscjk.MainActivity;
import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseFragment;
import com.example.administrator.noto_sanscjk.wrench.activity.ShipingActivity;
import com.example.administrator.noto_sanscjk.wrench.activity.TuwenAcitity;
import com.example.administrator.noto_sanscjk.wrench.activity.YuyinActivity;

/**
 * Created by Administrator on 2018/4/25.
 */

public class WrenchFragment extends BaseFragment {


    private ImageView fork;
    private ImageView tuwen;
    private ImageView yuyin;
    private ImageView shiping;

    @Override
    protected void initview() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {
        View inflate = View.inflate(getActivity(), R.layout.fragment_wrench, null);

        fork = inflate.findViewById(R.id.fork);

        fork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), MainActivity.class);

                startActivity(intent);

                getActivity().finish();

            }
        });

        tuwen = inflate.findViewById(R.id.tuwen_img);
        yuyin = inflate.findViewById(R.id.yuyin_img);
        shiping = inflate.findViewById(R.id.shiping_img);

        tuwen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), TuwenAcitity.class);

                startActivity(intent);

            }
        });


        yuyin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), YuyinActivity.class);

                startActivity(intent);

            }
        });

        shiping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), ShipingActivity.class);

                startActivity(intent);

            }
        });


        return inflate;
    }

    @Override
    protected void restartdata() {

    }
}
