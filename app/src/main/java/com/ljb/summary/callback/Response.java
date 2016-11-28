package com.ljb.summary.callback;

/**
 * 作者：ljb
 * 时间：2016/11/28 16:24
 * 邮箱：563773219@qq.com
 * 描述：
 */
public class Response {

    public interface Listener<T> {
        void onResponse(T result);
    }
}
