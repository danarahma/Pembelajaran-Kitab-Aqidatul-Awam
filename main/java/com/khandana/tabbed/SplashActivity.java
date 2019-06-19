package com.khandana.tabbed;


import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.khandana.tabbed.Settings.BaseActivity;
public class SplashActivity extends Activity {
    Animation anim;
    AnimationDrawable animationDrawable, animationDrawablee;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_1010102);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StartAnimations();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning())
            animationDrawable.start();
        if (animationDrawablee != null && !animationDrawablee.isRunning())
            animationDrawablee.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning())
            animationDrawable.stop();
        if (animationDrawablee != null && animationDrawablee.isRunning())
            animationDrawablee.stop();
    }

    private void StartAnimations() {

        Animation icon = AnimationUtils.loadAnimation(this, R.anim.anim_bounce);
        icon.reset();
        ImageView ic=(ImageView) findViewById(R.id.icon);
        ic.clearAnimation();
        ic.startAnimation(icon);

        Animation ats = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.anim_slide_up);
        ats.reset();
        ats.setStartOffset(1500);
        LinearLayout l1=(LinearLayout) findViewById(R.id.l1);
        l1.clearAnimation();
        l1.startAnimation(ats);

        Animation bwh = AnimationUtils.loadAnimation(this, R.anim.anim_slide_bottom);
        bwh.reset();
        bwh.setStartOffset(1500);
        LinearLayout l2=(LinearLayout) findViewById(R.id.l2);
        l2.clearAnimation();
        l2.startAnimation(bwh);




        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashActivity.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashActivity.this.finish();
                }

            }
        };
        splashTread.start();


    }

}

