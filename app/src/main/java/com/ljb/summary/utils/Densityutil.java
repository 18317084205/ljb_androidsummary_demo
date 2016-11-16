package com.ljb.summary.utils;

import android.content.Context;

/**
 * 作者：ljb
 * 时间：2016/11/15 17:57
 * 邮箱：563773219@qq.com
 * 描述：屏幕适配单位转换
 */
public class Densityutil {

    /**
     * 描述：根据手机分辨率把dip转换成px像素
     */
    public static int dip2px(Context context ,float dp){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * 描述：根据手机分辨率把px像素转换成dip
     */
    public static int px2dip(Context context ,float px){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }
}
