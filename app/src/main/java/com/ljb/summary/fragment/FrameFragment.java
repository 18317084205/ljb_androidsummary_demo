package com.ljb.summary.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ljb.summary.R;
import com.ljb.summary.adapter.FrameListViewAdapter;
import com.ljb.summary.base.BaseFragment;
import com.ljb.summary.bean.TypeInfo;
import com.ljb.summary.callback.Response;
import com.ljb.summary.frame.Picasso.PicassoActivity;
import com.ljb.summary.frame.Volley.VolleyActivity;
import com.ljb.summary.frame.butterknife.ButterKnifeActivity;
import com.ljb.summary.frame.eventbus.EventBusActivity;
import com.ljb.summary.utils.ThreadUtil;

import java.util.List;

/**
 * 作者：ljb
 * 时间：2016/11/16 19:53
 * 邮箱：563773219@qq.com
 * 描述：首页、android框架demo页面
 */
public class FrameFragment extends BaseFragment implements AdapterView.OnItemClickListener, Response.Listener<List<TypeInfo>> {

    public FrameFragment() {
        super();
    }

    private static final String TAG = FrameFragment.class.getSimpleName();
    private static final String TAGa = "第一个页面";
    private ListView listView;
    private List<TypeInfo> itemTitles;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_frame;
    }

    @Override
    protected void initViewsAndEvents(View view) {
        listView = (ListView) view.findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onFirstUserVisible() {
//        listView.setAdapter(new FrameListViewAdapter(getActivity(),itemTitles));
        ThreadUtil.getInstance().getPageTypes(getActivity(), "frames", this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (itemTitles == null) {
            return;
        }
        String itemTitle = itemTitles.get(position).getType();
        Log.d(TAG, "itemTitle: " + itemTitle);
        Intent intent = null;
        if (itemTitle.equals("butterknife")) {
            intent = new Intent(getActivity(), ButterKnifeActivity.class);
        }

        if (itemTitle.equals("eventbus")) {
            intent = new Intent(getActivity(), EventBusActivity.class);
        }

        if (itemTitle.equals("volley")) {
            intent = new Intent(getActivity(), VolleyActivity.class);
        }

        if (itemTitle.equals("picasso")) {
            intent = new Intent(getActivity(), PicassoActivity.class);
        }

        if (null != intent) {
            startActivity(intent);
        }

    }

    @Override
    public void onResponse(List<TypeInfo> result) {
        itemTitles = result;
        listView.setAdapter(new FrameListViewAdapter(getActivity(), result));
    }
}
