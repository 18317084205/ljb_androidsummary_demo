package com.ljb.summary.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljb.summary.R;
import com.ljb.summary.utils.CacheUtils;


public class SplashActivity extends Activity  {

    public static final String FIRST_START = "firstStart";
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);
        startImageViewAnimation();
    }

   /**
    * 作者：ljb
    * 时间：2016/11/14 19:04
    * 邮箱：563773219@qq.com
    * 描述：启动Imageview动画
    */
    private void startImageViewAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -0.5f,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(1500);
        translateAnimation.setInterpolator(new BounceInterpolator());
        translateAnimation.setAnimationListener(new TranslateAnimationListener());
        imageView.setAnimation(translateAnimation);
    }

    /**
     * 作者：ljb
     * 时间：2016/11/14 19:15
     * 邮箱：563773219@qq.com
     * 描述：启动TextView动画
     */
    private void startTextViewAnimation() {
        textView.setVisibility(View.VISIBLE);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setAnimationListener(new AlphaAnimationListener());
        textView.setAnimation(alphaAnimation);
    }

    /**
     * 作者：ljb
     * 时间：2016/11/14 19:17
     * 邮箱：563773219@q
     * 描述：跳转到下一个界面
     */
    private void startNextActivity() {
        Intent intent;
        if (CacheUtils.getBoolean(this, FIRST_START)){
            intent = new Intent(this, HomeActivity.class);
        }else {
            intent = new Intent(this,GuideActivity.class);
        }
        startActivity(intent);
        finish();
    }


    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_BACK) {
        }else{
            return super.onKeyDown(keyCode, event);
        }
        return false;
    }

    /**
     * 作者：ljb
     * 时间：2016/11/14 19:06
     * 邮箱：563773219@qq.com
     * 描述：Translate动画监听
     */
    class TranslateAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            startTextViewAnimation();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /**
     * 作者：ljb
     * 时间：2016/11/14 19:07
     * 邮箱：563773219@qq.com
     * 描述：Alpha动画监听
     */
    class AlphaAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            startNextActivity();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }
}


