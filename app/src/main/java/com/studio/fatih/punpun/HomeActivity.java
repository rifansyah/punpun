package com.studio.fatih.punpun;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
//    BackgroundSound mBackgroundSound = new BackgroundSound();
    boolean song = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView gambar_1 = findViewById(R.id.gambar1);
        ImageView gambar_2 = findViewById(R.id.gambar2);
        ImageView gambar_3 = findViewById(R.id.gambar3);
        ImageView gambar_4 = findViewById(R.id.gambar4);
        FrameLayout layout_putri = findViewById(R.id.layout_putri);
        TextView text_putri = findViewById(R.id.text_putri);
        TextView text_umur = findViewById(R.id.text_umur);

        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        gambar_1.startAnimation(myAnim);
        gambar_2.startAnimation(myAnim);
        gambar_3.startAnimation(myAnim);
        gambar_4.startAnimation(myAnim);

        myAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        layout_putri.startAnimation(myAnim);

        myAnim = AnimationUtils.loadAnimation(this, R.anim.fade);
        text_putri.startAnimation(myAnim);
        text_umur.startAnimation(myAnim);

//        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.sempurna);
//
//        mediaPlayer.start();

        LinearLayout layout_buat_kamu = findViewById(R.id.layout_buat_kamu);
        layout_buat_kamu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BuatKamuActivity.class);
                startActivity(intent);

            }
        });

        LinearLayout layout_dulu_dulu = findViewById(R.id.layout_dulu_dulu);
        layout_dulu_dulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DuluDuluActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layout_cerita_cerita = findViewById(R.id.layout_cerita);
        layout_cerita_cerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CeritaCeritaActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout layout_terima_kasih = findViewById(R.id.layout_terima_kasih);
        layout_terima_kasih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TerimaKasihActivity.class);
                startActivity(intent);
            }
        });

        Intent svc=new Intent(this, BackgroundSoundService.class);
        svc.putExtra("From", 1);
        startService(svc);

        TextView ganti = findViewById(R.id.text_ganti);
        ganti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(),BackgroundSoundService.class));
                if(song) {
                    Intent svc=new Intent(getApplicationContext(), BackgroundSoundService.class);
                    svc.putExtra("From", 0);
                    startService(svc);
                } else {
                    Intent svc=new Intent(getApplicationContext(), BackgroundSoundService.class);
                    svc.putExtra("From", 1);
                    startService(svc);
                }
                song = !song;
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        stopService(new Intent(this,BackgroundSoundService.class));
        this.finish();
    }

//    public void onResume() {
//        super.onResume();
//        if(mBackgroundSound.getStatus() != AsyncTask.Status.RUNNING) {
//            mBackgroundSound.execute();
//        }
//
//    }
//
//    public void onPause() {
//        super.onPause();
//        mBackgroundSound.cancel(true);
//    }
//
//    public class BackgroundSound extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            MediaPlayer player = MediaPlayer.create(HomeActivity.this, R.raw.sempurna);
//            player.setLooping(true); // Set looping
//            player.setVolume(1.0f, 1.0f);
//            player.start();
//
//            return null;
//        }
//
//    }


}
