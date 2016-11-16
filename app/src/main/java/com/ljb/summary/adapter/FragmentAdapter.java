package com.ljb.summary.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ljb.summary.base.BaseFragment;

import java.util.List;

/**
 * 作者：ljb
 * 时间：2016/11/16 19:46
 * 邮箱：563773219@qq.com
 * 描述：Fragment容器
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;

    public FragmentAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);

        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments == null ? null : fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }
}
