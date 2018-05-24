package com.example.administrator.noto_sanscjk.trading.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.administrator.noto_sanscjk.R;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.trading.fragment.GouMaiFragment;
import com.example.administrator.noto_sanscjk.trading.fragment.WoFabuFragment;

/**
 * Created by Administrator on 2018/5/5.
 */

public class XinXiActivity extends BaseActivity {


    private FrameLayout frameLayout;
    private GouMaiFragment gouMaiFragment;
    private FragmentTransaction transaction;
    private WoFabuFragment woFabuFragment;
    private RadioGroup group;

    @Override
    protected int intiLayout() {
        return R.layout.activity_xinxi;
    }

    @Override
    public void initView() {

        frameLayout = findViewById(R.id.framelayout);
        group = findViewById(R.id.group);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        gouMaiFragment = new GouMaiFragment();
        fragmentTransaction.add(R.id.framelayout, gouMaiFragment);

        fragmentTransaction.show(gouMaiFragment);

        fragmentTransaction.commit();

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                FragmentManager manager = getSupportFragmentManager();
                transaction = manager.beginTransaction();
                hideAll(transaction);

                switch (checkedId) {

                    case R.id.goumai_but:

                        if (gouMaiFragment == null) {

                            gouMaiFragment = new GouMaiFragment();

                            transaction.add(R.id.framelayout, gouMaiFragment);
                        } else {

                            transaction.show(gouMaiFragment);
                        }

                        break;
                    case R.id.fabu_but:

                        if (woFabuFragment == null) {

                            woFabuFragment = new WoFabuFragment();

                            transaction.add(R.id.framelayout, woFabuFragment);
                        } else {

                            transaction.show(woFabuFragment);
                        }

                        break;
                }

                transaction.commit();
            }
        });

    }

    private void hideAll(FragmentTransaction transaction) {

        if (woFabuFragment != null) {

            transaction.hide(woFabuFragment);
        }
        if (gouMaiFragment != null) {

            transaction.hide(gouMaiFragment);
        }
    }
}
