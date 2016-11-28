package com.ljb.summary.frame.butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ljb.summary.R;
import com.ljb.summary.adapter.ButterKnifeListViewAdapter;
import com.ljb.summary.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ButterKnifeActivity extends Activity implements AdapterView.OnItemClickListener{

    @InjectView(R.id.butterknife_tv)
    TextView butterknifeTv;
    @InjectView(R.id.butterknife_iv)
    ImageView butterknifeIv;
    @InjectView(R.id.frame_title_text)
    TextView frameTitleText;
    @InjectView(R.id.butterknife_btn)
    Button butterknifeBtn;
    @InjectView(R.id.butterknife_btn1)
    Button butterknifeBtn1;
    @InjectView(R.id.butterknife_lv)
    ListView butterknifeLv;

    private List<String> chars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.inject(this);
        frameTitleText.setText("ButterKnife");
        butterknifeLv.setOnItemClickListener(this);
    }


    @OnClick({R.id.butterknife_btn, R.id.butterknife_btn1})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.butterknife_btn:
                butterknifeTv.setText("TextView初始化成功了");
                butterknifeIv.setImageResource(R.drawable.ic_launcher);
                break;
            case R.id.butterknife_btn1:
                upListView();
                break;
        }
    }

    private void upListView(){
        for (int i = 0; i < 10; i++) {
            chars.add(i+"");
        }

        butterknifeLv.setAdapter(new ButterKnifeListViewAdapter(this,chars));

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Utils.showToast(this, "id:" + chars.get(position) + "被点击了");
    }
}
