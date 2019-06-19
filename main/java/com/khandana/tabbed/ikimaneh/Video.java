package com.khandana.tabbed;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.VideoView;

import com.khandana.tabbed.Settings.BaseActivity;
import com.khandana.tabbed.VideoOnline.Delapan;
import com.khandana.tabbed.VideoOnline.Dua;
import com.khandana.tabbed.VideoOnline.Empat;
import com.khandana.tabbed.VideoOnline.Enam;
import com.khandana.tabbed.VideoOnline.Lima;
import com.khandana.tabbed.VideoOnline.Satu;
import com.khandana.tabbed.VideoOnline.Tiga;
import com.khandana.tabbed.VideoOnline.Tujuh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Video extends BaseActivity {

    VideoView videoView;

    String[] listviewTitle = new String[]{
            "Aqidatul Awam.mwv","Aqidatul Awam Lirik dan Terjemahan","Kitab 'Aqidatul 'Awam (Khataman Akhirussanah)","Lirik Nadhom Kitab Aqidatul Awam Majelis Nurul Musthofa",
            "Upin Ipin : Nadzom Aqidatul Awwam","Majelis Nurul Musthofa - Aqidatul Awam","Aqidatul Awam | Lirik Sholawat","Aqidatul Awam Nadhom & Terjemahannya"
    };

    int[] lisviewImage = new int[]{
            R.drawable.vidsatu,R.drawable.viddua,R.drawable.vidtiga,R.drawable.vidempat,
            R.drawable.vidlima,R.drawable.videnam,R.drawable.vidtujuh,R.drawable.viddelapan
    };

    String[] listviewShortDescription = new String[]{
            "online","online","online","online",
            "online","online","online","online"
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        final ImageButton play_pause = (ImageButton) findViewById(R.id.pause_play);


        videoView = (VideoView) findViewById(R.id.videoView);


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);

        final String videoUri = "android.resource://" + getPackageName() + "/" + R.raw.pa;

        videoView.setVideoURI(Uri.parse(videoUri));
        videoView.start();


        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Toast.makeText(Video.this, "Video Error", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()){
                    videoView.pause();
                    play_pause.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    videoView.start();
                    play_pause.setImageResource(android.R.drawable.ic_media_pause);
                }
            }
        });

        ListView listklik = (ListView) findViewById(R.id.listvid);
        listklik.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent video = new Intent(view.getContext(), Satu.class);
                    startActivityForResult(video, 0);
                }
                if (position == 1) {
                    Intent video = new Intent(view.getContext(), Dua.class);
                    startActivityForResult(video, 0);
                }if (position == 2) {
                    Intent video = new Intent(view.getContext(), Tiga.class);
                    startActivityForResult(video, 0);
                }if (position == 3) {
                    Intent video = new Intent(view.getContext(), Empat.class);
                    startActivityForResult(video, 0);
                }if (position == 4) {
                    Intent video = new Intent(view.getContext(), Lima.class);
                    startActivityForResult(video, 0);
                }if (position == 5) {
                    Intent video = new Intent(view.getContext(), Enam.class);
                    startActivityForResult(video, 0);
                }if (position == 6) {
                    Intent video = new Intent(view.getContext(),Tujuh.class);
                    startActivityForResult(video, 0);
                }if (position == 7) {
                    Intent video = new Intent(view.getContext(), Delapan.class);
                    startActivityForResult(video, 0);
                }
            }
        });

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++){
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_description", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(lisviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image","listview_title","listview_description"};
        int[] to = {R.id.image, R.id.title, R.id.descript};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.activity_list_video, from, to);
        ListView androidListView = (ListView) findViewById(R.id.listvid);
        androidListView.setAdapter(simpleAdapter);
    }


    public void lands(View view) {
        Intent lands = new Intent(this, Full.class);
        startActivity(lands);
    }

}
