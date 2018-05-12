package com.example.administrator.noto_sanscjk.person;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseFragment;
import com.example.administrator.noto_sanscjk.person.activity.AddressActivity;
import com.example.administrator.noto_sanscjk.person.activity.ChongzhiActivity;
import com.example.administrator.noto_sanscjk.person.activity.PersonalActivity;
import com.example.administrator.noto_sanscjk.person.activity.RepairActivity;
import com.example.administrator.noto_sanscjk.person.activity.XianzhiActivity;
import com.example.administrator.noto_sanscjk.person.activity.YijianActivity;
import com.example.administrator.noto_sanscjk.person.activity.YouhuiActivity;

/**
 * Created by Administrator on 2018/4/25.
 */

public class PersonFragment extends BaseFragment {


    private LinearLayout personal;
    private LinearLayout address;
    private LinearLayout repairlist;
    private LinearLayout Xianzhilist;
    private LinearLayout youhuilist;
    private LinearLayout chongzhilist;
    private LinearLayout yijianlist;

    @Override
    protected void initview() {

    }

    @Override
    protected void initdata() {

    }

    @Override
    protected View initlayout() {
        View inflate = View.inflate(getActivity(), R.layout.fragment_person, null);

        personal = inflate.findViewById(R.id.personal);
        address = inflate.findViewById(R.id.address);
        repairlist = inflate.findViewById(R.id.repairlist);
        Xianzhilist = inflate.findViewById(R.id.Xianzhilist);
        youhuilist = inflate.findViewById(R.id.youhuilist);
        chongzhilist = inflate.findViewById(R.id.chongzhilist);
        yijianlist = inflate.findViewById(R.id.yijianlist);

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), PersonalActivity.class);

                startActivity(intent);
            }
        });
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), AddressActivity.class);

                startActivity(intent);

            }
        });

        repairlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getActivity(), RepairActivity.class);

                startActivity(intent);

            }
        });

        Xianzhilist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), XianzhiActivity.class);

                startActivity(intent);

            }
        });

        youhuilist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), YouhuiActivity.class);

                startActivity(intent);

            }
        });

        chongzhilist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), ChongzhiActivity.class);

                startActivity(intent);

            }
        });
        yijianlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(), YijianActivity.class);

                startActivity(intent);

            }
        });



        return inflate;
    }

    @Override
    protected void restartdata() {

    }
}
