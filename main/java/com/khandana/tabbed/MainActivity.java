package com.khandana.tabbed;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.khandana.tabbed.Settings.BaseActivity;
import com.khandana.tabbed.Settings.Utility;

public class MainActivity extends BaseActivity {
    LinearLayout lin1,lin2,lin3,lin4;
    Animation up, fromb, alpha;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lin1 = (LinearLayout) findViewById(R.id.lin1);
        lin2 = (LinearLayout) findViewById(R.id.lin2);
        lin3 = (LinearLayout) findViewById(R.id.lin3);
        lin4 = (LinearLayout) findViewById(R.id.lin4);
        up = AnimationUtils.loadAnimation(this, R.anim.anim_slide_left);
        fromb = AnimationUtils.loadAnimation(this, R.anim.anim_slide_right);
        alpha = AnimationUtils.loadAnimation(this, R.anim.alpha);

        lin1.startAnimation(up);
        lin2.startAnimation(fromb);
        lin3.startAnimation(up);
        lin4.startAnimation(fromb);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bar, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menu) {
        if (menu.getItemId()==R.id.biru){
            Utility.setTheme(getApplicationContext(), 1);
            recreateActivity();
        } else if (menu.getItemId()==R.id.red){
            Utility.setTheme(getApplicationContext(), 2);
            recreateActivity();
        } else if (menu.getItemId()==R.id.orange) {
            Utility.setTheme(getApplicationContext(), 3);
            recreateActivity();
        } else if (menu.getItemId()==R.id.ungu) {
            Utility.setTheme(getApplicationContext(), 4);
            recreateActivity();
        }else if (menu.getItemId()==R.id.hijau) {
            Utility.setTheme(getApplicationContext(), 5);
            recreateActivity();
        } else if (menu.getItemId()==R.id.pink) {
            Utility.setTheme(getApplicationContext(), 6);
            recreateActivity();
        } return true;
    }

    public void recreateActivity() {
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }


    public void arti(View view) {
        Intent intent = new Intent(this, MainActivityExpandListView.class);
        startActivity(intent);
    }

    public void Nadhom(View view) {
        Intent nadhom = new Intent(this, Nadhom.class);
        startActivity(nadhom);
    }

    public void video(View view) {
        Intent video = new Intent(this, Video.class);
        startActivity(video);
    }

    public void profil(View view) {
        Intent profil = new Intent(this, About.class);
        startActivity(profil);
    }

    public void tentang(MenuItem item) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(getDrawable(R.drawable.icon));
        builder.setTitle("\n\nAqidatul Awam");
        builder.setMessage("\n\nVersi : 1.0\nSumber Rujukan : Kitab Terjemah Aqidatul Awam Toko Buku Imam Surabaya" +
                "\nAudio : Ustadz Abdur Rouf");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));

    }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setIcon(getDrawable(R.drawable.icon));
        builder.setMessage(" Keluar Dari Aplikasi?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                finish();
                System.exit(0);
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.LTGRAY));
    }
}
