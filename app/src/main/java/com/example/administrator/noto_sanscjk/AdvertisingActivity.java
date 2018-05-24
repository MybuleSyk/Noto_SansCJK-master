package com.example.administrator.noto_sanscjk;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import com.example.administrator.noto_sanscjk.base.BaseActivity;
import com.example.administrator.noto_sanscjk.customize.IntentUtil;
import com.example.administrator.noto_sanscjk.login.LoginActivity;

/**
 * Created by LiYRong on 2018/5/22.
 */

public class AdvertisingActivity extends BaseActivity {

    private TextView text;
    private MyCountDownTimer mc;


    @Override
    protected int intiLayout() {
        return R.layout.activity_advertising;
    }

    @Override
    public void initView() {

        text=findViewById(R.id.text);

        mc = new MyCountDownTimer(3000, 1000);
        mc.start();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(AdvertisingActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
    private Handler handler=new Handler();
/**
 * 继承 CountDownTimer 防范
 *
 * 重写 父类的方法 onTick() 、 onFinish()
 */

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {


        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IntentUtil.intentToNull(AdvertisingActivity.this,LoginActivity.class);

                finish();

            }
        });

    }
    class MyCountDownTimer extends CountDownTimer {
        /**
         *
         * @param millisInFuture
         * 表示以毫秒为单位 倒计时的总数
         *
         * 例如 millisInFuture=1000 表示1秒
         *
         * @param countDownInterval
         * 表示 间隔 多少微秒 调用一次 onTick 方法
         *
         * 例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
         *
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        public void onFinish() {
            text.setText("跳过");
        }
        public void onTick(long millisUntilFinished) {
            text.setText("跳过" + millisUntilFinished / 1000);
        }
    }
}
