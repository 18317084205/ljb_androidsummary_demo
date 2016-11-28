package com.ljb.summary.frame.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ljb.summary.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusActivity extends Activity implements View.OnClickListener {

    private TextView eventbus_callmsg_tv;
    private boolean isregister = false;
    private int i = 0;
    private int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        initView();
    }

    private void initView() {
        findViewById(R.id.eventbus_register_btn).setOnClickListener(this);
        findViewById(R.id.eventbus_unregister_btn).setOnClickListener(this);
        findViewById(R.id.eventbus_sendmsg_btn).setOnClickListener(this);
        findViewById(R.id.eventbus_sendsticky_btn).setOnClickListener(this);
        findViewById(R.id.eventbus_callmsg_btn).setOnClickListener(this);
        findViewById(R.id.eventbus_rem_btn).setOnClickListener(this);
        ((TextView) findViewById(R.id.frame_title_text)).setText("EventBus");
        eventbus_callmsg_tv = (TextView) findViewById(R.id.eventbus_callmsg_tv);
        eventbus_callmsg_tv.setText("接收消息：");
    }

    //接收消息
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void callback(String msg) {
        eventbus_callmsg_tv.setText(msg);
    }

    //接收粘性事件消息
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void callbackSticky(EventBusMessage message) {
        eventbus_callmsg_tv.setText(message.msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.eventbus_register_btn:
                registerEventBus();
                break;
            case R.id.eventbus_unregister_btn:
                unRegisterEventBus();
                break;
            case R.id.eventbus_sendmsg_btn:
                i++;
                //发布消息
                EventBus.getDefault().post("EventBus发送的消息" + i);
                break;
            case R.id.eventbus_sendsticky_btn:
                j++;
                //发布粘性事件消息
                EventBus.getDefault().postSticky(new EventBusMessage("EventBus发送的粘性事件" + j));
                break;
            case R.id.eventbus_callmsg_btn:
                registerEventBus();
                break;
            case R.id.eventbus_rem_btn:
                //移除所有粘性事件消息
                EventBus.getDefault().removeAllStickyEvents();
                break;
            default:
                break;
        }

    }

    //注册
    private void registerEventBus() {
        if (!isregister) {
            EventBus.getDefault().register(this);
            isregister = true;
        }
    }

    //解注册
    private void unRegisterEventBus() {
        EventBus.getDefault().unregister(this);
        isregister = false;
        i = 0;
        j = 0;
        eventbus_callmsg_tv.setText("接收消息：");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterEventBus();
    }
}
