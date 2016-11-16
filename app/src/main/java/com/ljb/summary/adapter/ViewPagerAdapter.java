package com.ljb.summary.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 作者：ljb
 * 时间：2016/11/15 15:27
 * 邮箱：563773219@qq.com
 * 描述：ViewPaper适配器
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<View> views;

    public ViewPagerAdapter( List<View> views) {
        super();
        this.views = views;
    }


    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}
