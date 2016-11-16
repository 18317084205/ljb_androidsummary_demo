package com.ljb.summary.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者：ljb
 * 时间：2016/11/15 on 12:55
 * 邮箱：563773219@qq.com
 * 描述：缓存工具类
 */
public class CacheUtils {

    private static final String CACHENAME = "ljb";


    /**
     * @param context 上下文
     * @param key 键名
     * @return true、false
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(CACHENAME,Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key,false);
    }


    /**
     * @param context 上下文
     * @param key 键名
     * @param value true、false
     */
    public static void putBoolean(Context context, String key, boolean value){
        SharedPreferences sharedPreferences = context.getSharedPreferences(CACHENAME,Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(key,value).commit();
    }


}
