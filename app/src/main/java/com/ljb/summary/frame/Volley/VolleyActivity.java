package com.ljb.summary.frame.Volley;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ljb.summary.R;
import com.ljb.summary.utils.CryptoUtil;
import com.ljb.summary.utils.VolleyBitmapUtils;

import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends Activity implements View.OnClickListener {

    private TextView volleyGetTv;
    private TextView volleyPostTv;
    private ImageView volleyImagerequestIv;
    private ImageView volleyImageloaderIv;
    private NetworkImageView volleyNetworkimageviewIv;
    private RequestQueue requestQueue;

    private final String getUrl = "http://api.51renxing.com/App/gameList.html";
    private final String postUrl = "http://api.51renxing.com/MobileUser/login.html";
    private final String imageRequestUrl = "http://attimg.dospy.com/img/day_101125/20101125_8279160d6d780ba66b2eUUFx1PpDXXx6.jpg";
    private final String imageLoaderUrl = "http://attachments.gfan.com/forum/attachments2/day_100519/1005191825146df9d860b7b982.jpg";
    private final String netWorkUrl = "http://s.qdcdn.com/cl/11401269,800,450.jpg";


    private final String APPKEY = "704d9da3fb5c8c99ac5d1a6259224bf2";
    private final String APPID = "0";
    private final String CHANNEL = "0";
    private final String USERNAME = "15191851980";
    private final String PASSWORD = "ljb123456";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        initView();

        //创建一个请求队列
        requestQueue = Volley.newRequestQueue(this);
    }

    private void initView() {
        findViewById(R.id.volley_get_btn).setOnClickListener(this);
        findViewById(R.id.volley_post_btn).setOnClickListener(this);
        findViewById(R.id.volley_imagerequest_btn).setOnClickListener(this);
        findViewById(R.id.volley_imageloader_btn).setOnClickListener(this);
        findViewById(R.id.volley_networkimageview_btn).setOnClickListener(this);

        ((TextView) findViewById(R.id.frame_title_text)).setText("Volley");

        volleyGetTv = (TextView) findViewById(R.id.volley_get_tv);
        volleyPostTv = (TextView) findViewById(R.id.volley_post_tv);
        volleyImagerequestIv = (ImageView) findViewById(R.id.volley_imagerequest_iv);
        volleyImageloaderIv = (ImageView) findViewById(R.id.volley_imageloader_iv);
        volleyNetworkimageviewIv = (NetworkImageView) findViewById(R.id.volley_networkimageview_iv);
    }

    //创建一个get请求
    private void get() {
        StringRequest stringRequest = new StringRequest(getUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                volleyGetTv.setText("Get请求结果：\n" + s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyGetTv.setText("加载失败： " + volleyError);
            }
        });

        requestQueue.add(stringRequest);

    }

    //创建一个post请求
    private void post() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, postUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                volleyPostTv.setText("Post请求结果：\n" + s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyPostTv.setText("请求失败：\n" + volleyError);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("gameId", APPID);
                params.put("channel", CHANNEL);
                params.put("username", USERNAME);
                params.put("password", PASSWORD);
                String sign = CryptoUtil.toMd5(USERNAME + PASSWORD + APPID + CHANNEL + APPKEY);
                params.put("sign", sign);
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    //ImageRequest加载图片
    private void imageRequest() {
        ImageRequest imageRequest = new ImageRequest(imageRequestUrl, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                volleyImagerequestIv.setImageBitmap(bitmap);
            }
        }, 0, 0, ImageView.ScaleType.CENTER_INSIDE, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyImagerequestIv.setImageResource(R.drawable.ic_launcher);
            }
        });
        requestQueue.add(imageRequest);
    }

    //ImageLoader加载图片
    private void imageLoader() {
        ImageLoader imageLoader = new ImageLoader(requestQueue, new VolleyBitmapUtils());
        ImageLoader.ImageListener imageListener = imageLoader.getImageListener(volleyImageloaderIv, R.drawable.ic_launcher, R.drawable.ic_launcher);
        imageLoader.get(imageLoaderUrl, imageListener);
    }

    //NetWorkImageview加载图片
    private void netWorkImageview() {
        ImageLoader imageLoader = new ImageLoader(requestQueue, new VolleyBitmapUtils());
        volleyNetworkimageviewIv.setDefaultImageResId(R.drawable.ic_launcher);
        volleyNetworkimageviewIv.setErrorImageResId(R.drawable.ic_launcher);
        volleyNetworkimageviewIv.setImageUrl(netWorkUrl, imageLoader);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.volley_get_btn:
                get();
                break;
            case R.id.volley_post_btn:
                post();
                break;
            case R.id.volley_imagerequest_btn:
                imageRequest();
                break;
            case R.id.volley_imageloader_btn:
                imageLoader();
                break;
            case R.id.volley_networkimageview_btn:
                netWorkImageview();
                break;
            default:
                break;
        }
    }
}
