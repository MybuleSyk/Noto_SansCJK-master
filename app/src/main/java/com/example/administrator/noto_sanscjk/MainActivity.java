package com.example.administrator.noto_sanscjk;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.home.fragment.HomeFragment;
import com.example.administrator.noto_sanscjk.hotspots.HotspotsFragment;
import com.example.administrator.noto_sanscjk.person.PersonFragment;
import com.example.administrator.noto_sanscjk.trading.fragment.TradingFragment;
import com.example.administrator.noto_sanscjk.wrench.WrenchFragment;


public class MainActivity extends BaseActivity{

    private RadioGroup rad_group;
    private HomeFragment homeFragment;
    private HotspotsFragment hotspotsFragment;
    private PersonFragment personFragment;
    private TradingFragment tradingFragment;
    private WrenchFragment wrenchFragment;
    private FragmentTransaction transaction;

    @Override
    protected int intiLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        rad_group = findViewById(R.id.rad_group);

        rad_group.setVisibility(View.VISIBLE);

    }

    public void initData() {

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        homeFragment=new HomeFragment();
        fragmentTransaction.add(R.id.frame_layout,homeFragment);

        fragmentTransaction.show(homeFragment);

        fragmentTransaction.commit();


    }

    public void initListener() {
        rad_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
               FragmentManager manager = getSupportFragmentManager();
                 transaction = manager.beginTransaction();
                hideAll(transaction);
                switch (checkedId){

                    case R.id.rab_home:

                        rad_group.setVisibility(View.VISIBLE);

                        if (homeFragment == null) {

                            homeFragment=new HomeFragment();

                            transaction.add(R.id.frame_layout,homeFragment);
                        }else {

                            transaction.show(homeFragment);
                        }

                        break;

                    case R.id.rab_wrench:

                        rad_group.setVisibility(View.GONE);

                        if (wrenchFragment == null) {

                            wrenchFragment=new WrenchFragment();

                            transaction.add(R.id.frame_layout,wrenchFragment);
                        }else {

                            transaction.show(wrenchFragment);
                        }

                        break;
                    case R.id.rab_trading:

                        rad_group.setVisibility(View.VISIBLE);

                        if (tradingFragment == null) {

                            tradingFragment=new TradingFragment();

                            transaction.add(R.id.frame_layout,tradingFragment);
                        }else {

                            transaction.show(tradingFragment);
                        }


                        break;
                    case R.id.rab_hotspots:

                        rad_group.setVisibility(View.VISIBLE);

                        if (hotspotsFragment == null) {

                            hotspotsFragment=new HotspotsFragment();

                            transaction.add(R.id.frame_layout,hotspotsFragment);
                        }else {

                            transaction.show(hotspotsFragment);
                        }


                        break;

                    case R.id.rab_person:

                        rad_group.setVisibility(View.VISIBLE);

                        if (personFragment == null) {

                            personFragment=new PersonFragment();

                            MainActivity.this.transaction.add(R.id.frame_layout,personFragment);
                        }else {

                            transaction.show(personFragment);
                        }

                        break;

                }

                transaction.commit();

            }
        });
    }

    private void hideAll(FragmentTransaction transaction){

        if (homeFragment != null) {

            transaction.hide(homeFragment);
        }
        if (personFragment != null) {

            transaction.hide(personFragment);
        }
        if (hotspotsFragment != null) {

            transaction.hide(hotspotsFragment);
        }
        if (tradingFragment != null) {

            transaction.hide(tradingFragment);
        }
        if (wrenchFragment != null) {

            transaction.hide(wrenchFragment);

            rad_group.setVisibility(View.VISIBLE);
        }
    }

//  防止出现fragment重叠
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        for (int i = 0; i < rad_group.getChildCount(); i++) {
            RadioButton mTab = (RadioButton) rad_group.getChildAt(i);
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentByTag((String) mTab.getTag());
            FragmentTransaction ft = fm.beginTransaction();
            if (fragment != null) {
                if (!mTab.isChecked()) {
                    ft.hide(fragment);
                }
            }
            ft.commit();
        }
    }

}
