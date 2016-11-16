package com.ljb.summary.fragment;

import android.util.Log;
import android.view.View;

import com.ljb.summary.R;
import com.ljb.summary.base.BaseFragment;

/**
 * 作者：ljb
 * 时间：2016/11/16 19:53
 * 邮箱：563773219@qq.com
 * 描述：首页、android框架demo页面
 */
public class SensorFragment extends BaseFragment {

    public SensorFragment() {
        super();
    }

    private static final String TAG = SensorFragment.class.getSimpleName();
    private static final String TAGa = "第二个页面";

    @Override
    protected int getContentViewLayoutID() {
        Log.d(TAG, "getContentViewLayoutID: " + TAGa);
        return R.layout.fragment_sensor;
    }

    @Override
    protected void initViewsAndEvents(View view) {
        Log.d(TAG, "initViewsAndEvents: " + TAGa);
    }

    @Override
    protected void onFirstUserVisible() {
        Log.d(TAG, "onFirstUserVisible: " + TAGa);
    }

    @Override
    protected void onUserVisible() {
        Log.d(TAG, "onUserVisible: " + TAGa);
    }

    @Override
    protected void onUserInvisible() {
        Log.d(TAG, "onUserInvisible: " + TAGa);
    }

    @Override
    protected void onDetoryView() {
        Log.d(TAG, "onDetoryView: " + TAGa);
    }
}
