package com.ljb.summary.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * 作者：ljb
 * 时间：2016/11/26 on 12:55
 * 邮箱：563773219@qq.com
 * 描述：图片缓存工具类
 */
public class VolleyBitmapUtils implements ImageLoader.ImageCache{

    private LruCache<String,Bitmap> cache;

    public VolleyBitmapUtils() {
        int maxSize = 8 * 1024 * 1024;
        cache = new LruCache<String,Bitmap>(maxSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return super.sizeOf(key, value);
            }
        };
    }

    @Override
    public Bitmap getBitmap(String s) {
        return cache.get(s);
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        cache.put(s,bitmap);
    }
}
