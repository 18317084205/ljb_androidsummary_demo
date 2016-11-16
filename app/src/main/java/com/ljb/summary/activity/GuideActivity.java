package com.ljb.summary.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.ljb.summary.R;
import com.ljb.summary.adapter.ViewPagerAdapter;
import com.ljb.summary.utils.CacheUtils;
import com.ljb.summary.utils.Densityutil;

import java.util.ArrayList;
import java.util.List;


public class GuideActivity extends Activity implements View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, ViewPager.OnPageChangeListener {

    private ViewPager viewpager;
    private RelativeLayout relativelayout;
    private LinearLayout linearlayout;
    private int images[] = {R.drawable.guide_image_1,R.drawable.guide_image_3,R.drawable.guide_image_2};
    private List<View> imageViews = new ArrayList<>();
    private View point_blue;
    private RelativeLayout.LayoutParams pointParams;
    private int leftMax;
    private int widthdip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        findViewById(R.id.button).setOnClickListener(this);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        relativelayout = (RelativeLayout) findViewById(R.id.relativelayout);
        linearlayout = (LinearLayout) findViewById(R.id.linearlayout);

        initData();
    }

    /**
     * 作者：ljb
     * 时间：2016/11/15 15:18
     * 邮箱：563773219@qq.com
     * 描述：准备数据
     */
    private void initData() {
        widthdip = Densityutil.dip2px(this,10);
        for (int i = 0; i < images.length; i++) {
            View imageView = new ImageView(this);
            imageView.setBackgroundResource(images[i]);
            imageViews.add(imageView);
            //加载下边的正常状态的圆点
            initNormalPoint(i);
        }
        //加载下边的选中状态的圆点
        initBluepoint();
        viewpager.setAdapter(new ViewPagerAdapter(imageViews));
        viewpager.addOnPageChangeListener(this);
    }

    /**
     * 作者：ljb
     * 时间：2016/11/15 17:06
     * 邮箱：563773219@qq.com
     * 描述：加载下边的选中状态的圆点
     */
    private void initBluepoint() {
        point_blue = new ImageView(this);
        point_blue.setBackgroundResource(R.drawable.point_blue);
        pointParams = new RelativeLayout.LayoutParams(widthdip,widthdip);
        point_blue.setLayoutParams(pointParams);
        relativelayout.addView(point_blue);
        point_blue.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /**
     * 作者：ljb
     * 时间：2016/11/15 17:03
     * 邮箱：563773219@qq.com
     * 描述：加载下边的正常状态的圆点
     */
    private void initNormalPoint(int i) {

        View point = new ImageView(this);
        point.setBackgroundResource(R.drawable.point_normal);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(widthdip,widthdip);
        if (i != 0) {
            params.leftMargin = widthdip ;
        }
        point.setLayoutParams(params);
        linearlayout.addView(point);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                //TODO implement
                startNextActivity();
                break;
        }
    }

    /**
     * 作者：ljb
     * 时间：2016/11/15 17:43
     * 邮箱：563773219@qq.com
     * 描述：保存状态并跳转到下个页面
     */
    private void startNextActivity() {

        CacheUtils.putBoolean(this,SplashActivity.FIRST_START,true);
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onGlobalLayout() {
        point_blue.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        leftMax = linearlayout.getChildAt(1).getLeft() - linearlayout.getChildAt(0).getLeft();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        int leftMagin = (int) (position * leftMax + (positionOffset * leftMax));
        pointParams = (RelativeLayout.LayoutParams) point_blue.getLayoutParams();
        pointParams.leftMargin = leftMagin;
        point_blue.setLayoutParams(pointParams);

    }

    @Override
    public void onPageSelected(int position) {
        if (position == imageViews.size() - 1) {
            findViewById(R.id.button).setVisibility(View.VISIBLE);
        }else {
            findViewById(R.id.button).setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
