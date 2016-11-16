package com.ljb.summary.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * 作者：ljb
 * 时间：2016/11/16 19:16
 * 邮箱：563773219@qq.com
 * 描述：xx
 */
public abstract class BaseFragment extends Fragment {

    private View view;

    public BaseFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        if (null == view) {
            if (getContentViewLayoutID() != 0) {
                view = inflater.inflate(getContentViewLayoutID(), null);
            }
        }
//        else {
//            /**
//             * 缓存的rootView需要判断是否已经被加过parent，
//             * 如果有parent需要从parent删除，要不然会发生这个view已经有parent的错误。
//             */
//            ViewGroup parent = (ViewGroup) view.getParent();
//            if (parent != null) {
//                parent.removeView(view);
//            }
//        }
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewsAndEvents(view);
    }

    //加载布局
    protected abstract int getContentViewLayoutID();

    //初始化UI
    protected abstract void initViewsAndEvents(View view);

    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;
    private boolean isPrepared;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPrepare();
    }

    private synchronized void initPrepare() {
        if (isPrepared) {
            onFirstUserVisible();
        } else {
            isPrepared = true;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (isFirstVisible) {
                isFirstVisible = false;
                initPrepare();
            } else {
                onUserVisible();
            }
        } else {
            if (isFirstInvisible) {
                isFirstInvisible = false;
                onFirstUserInvisible();
            } else {
                onUserInvisible();
            }
        }
    }

    //第一次可见
    protected abstract void onFirstUserVisible();

    //可见状态
    protected abstract void onUserVisible();

    //第一次不可见
    private void onFirstUserInvisible() { }

    //不可见状态
    protected abstract void onUserInvisible();

    @Override
    public void onDestroy() {
        onDetoryView();
        super.onDestroy();
    }

    //销毁
    protected abstract void onDetoryView();



    protected void startActivity(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    protected void startActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void startActivityForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivityForResult(intent, requestCode);
    }

    protected void startActivityForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    private Toast toast;
    protected void showToast(String msg) {
        if (null == toast) {
            toast = new Toast(getActivity());
            toast.setDuration(Toast.LENGTH_SHORT);
        }

        if (!TextUtils.isEmpty(msg)) {
            toast.setText(msg);
            toast.show();
        }

    }

    protected void showDialog() {

    }
}
