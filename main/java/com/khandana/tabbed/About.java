package com.khandana.tabbed;

import android.app.ExpandableListActivity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.khandana.tabbed.Settings.BaseActivity;
import com.khandana.tabbed.Settings.Utility;

public class About extends BaseActivity {
    ImageView ll;
    Animation roll;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        roll = AnimationUtils.loadAnimation(this, R.anim.roll);

        ll = (ImageView) findViewById(R.id.imageView);

        ll.startAnimation(roll);

    }



}
