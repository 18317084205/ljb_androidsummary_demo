package com.ljb.summary.utils;

import android.content.Context;

import com.ljb.summary.bean.TypeInfo;
import com.ljb.summary.callback.Response;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作者：ljb
 * 时间：2016/11/28 15:45
 * 邮箱：563773219@qq.com
 * 描述：
 */
public class ThreadUtil {

    private static ThreadUtil threadUtil;
    private ExecutorService executors = Executors.newCachedThreadPool();

    public ThreadUtil() {
    }

    public static ThreadUtil getInstance() {
        if (threadUtil == null) {
            threadUtil = new ThreadUtil();
        }
        return threadUtil;
    }

    public void getPageTypes(final Context context, final String pageName, final Response.Listener<List<TypeInfo>> listener) {
        executors.execute(new Runnable() {
            @Override
            public void run() {
                listener.onResponse(Utils.getPageTypes(context, pageName));
            }
        });
    }
}
