package com.example.administrator.noto_sanscjk.customize;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2018/5/3.
 *
 * 这是一个用来跳转的工具类
 */

public class IntentUtil {

    /**
     * 不带参数跳转
     *
     * @param context
     * @param activity
     */
    public static void intentToNull(Context context, Class<?> activity) {
        if (context == null) {
//            ToastUtil.show(context);
            return;
        }
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }

    /**
     * 带参数跳转
     *
     * @param context
     * @param activity
     * @param mBundle
     */
    public static void intentToNull(Context context, Class<?> activity, Bundle mBundle) {
        Intent intent = new Intent(context, activity);
        intent.putExtras(mBundle);
        context.startActivity(intent);
    }

}
