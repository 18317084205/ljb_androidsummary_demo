package com.ljb.summary.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.ljb.summary.R;
import com.ljb.summary.adapter.FragmentAdapter;
import com.ljb.summary.base.BaseFragment;
import com.ljb.summary.fragment.AppFragment;
import com.ljb.summary.fragment.FrameFragment;
import com.ljb.summary.fragment.SensorFragment;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends FragmentActivity {

    private ViewPager viewpager;
    private List<BaseFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = (ViewPager) findViewById(R.id.viewpager);

        fragments = new ArrayList<>();
        fragments.add(new FrameFragment());
        fragments.add(new SensorFragment());
        fragments.add(new AppFragment());

        viewpager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragments));
        viewpager.setOffscreenPageLimit(fragments.size());
        viewpager.setCurrentItem(0);
    }
}
