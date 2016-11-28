package com.ljb.summary.frame.Picasso;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ljb.summary.R;

public class PicassoActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);

        initView();
    }

    private void initView() {
        findViewById(R.id.picasso_btn1).setOnClickListener(this);
        findViewById(R.id.picasso_btn2).setOnClickListener(this);
        findViewById(R.id.picasso_btn3).setOnClickListener(this);
        findViewById(R.id.picasso_btn4).setOnClickListener(this);

        ((TextView) findViewById(R.id.frame_title_text)).setText("Picasso");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.picasso_btn1:
                break;
            case R.id.picasso_btn2:
                break;
            case R.id.picasso_btn3:
                break;
            case R.id.picasso_btn4:
                break;
            default:
                break;
        }
    }
}
