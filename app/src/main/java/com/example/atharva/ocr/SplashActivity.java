package com.example.atharva.ocr;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity{
    private static int SPLASH_TIMR_OUT = 200;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final TextView textView = findViewById(R.id.textView2);
                final Animation animation1 = AnimationUtils.loadAnimation(SplashActivity.this,R.anim.slide_up);
                textView.startAnimation(animation1);


                animation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        textView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent intent = new Intent(SplashActivity.this,StartActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_up,R.anim.slide_out_up);
                        SplashActivity.this.finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        },SPLASH_TIMR_OUT);
    }
}
