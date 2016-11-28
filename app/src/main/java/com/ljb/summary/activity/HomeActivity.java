package com.ljb.summary.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ljb.summary.R;
import com.ljb.summary.adapter.FragmentAdapter;
import com.ljb.summary.base.BaseFragment;
import com.ljb.summary.fragment.AppFragment;
import com.ljb.summary.fragment.FrameFragment;
import com.ljb.summary.fragment.SensorFragment;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends FragmentActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private ViewPager viewpager;
    private List<BaseFragment> fragments;
    private TextView titleText;
    private RadioGroup menuRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        titleText = (TextView) findViewById(R.id.title_text);
        findViewById(R.id.title_button).setOnClickListener(this);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        menuRoot = (RadioGroup) findViewById(R.id.menu_root);

        initViewPager();

    }

    /**
     * 作者：ljb
     * 时间：2016/11/15 15:18
     * 邮箱：563773219@qq.com
     * 描述：初始化主页面
     */
    private void initViewPager() {
        fragments = new ArrayList<>();
        fragments.add(new FrameFragment());
        fragments.add(new SensorFragment());
        fragments.add(new AppFragment());

        viewpager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragments));
        viewpager.setOffscreenPageLimit(fragments.size());
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(this);

        titleText.setText(getString(R.string.home_menu_frame));
        menuRoot.check(R.id.menu_frame);
        menuRoot.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_button:
                //TODO implement
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                titleText.setText(getString(R.string.home_menu_frame));
                menuRoot.check(R.id.menu_frame);
                break;
            case 1:
                titleText.setText(getString(R.string.home_menu_sersor));
                menuRoot.check(R.id.menu_sensor);
                break;
            case 2:
                titleText.setText(getString(R.string.home_menu_app));
                menuRoot.check(R.id.menu_app);
                break;
            default:
                menuRoot.check(R.id.menu_frame);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId){
            case R.id.menu_frame:
                viewpager.setCurrentItem(0,false);
                break;
            case R.id.menu_sensor:
                viewpager.setCurrentItem(1,false);
                break;
            case R.id.menu_app:
                viewpager.setCurrentItem(2,false);
                break;
            default:
                viewpager.setCurrentItem(0,false);
                break;
        }
    }
}
