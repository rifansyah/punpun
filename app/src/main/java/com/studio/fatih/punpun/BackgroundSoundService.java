package com.studio.fatih.punpun;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;

    @Override
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
//        player = MediaPlayer.create(this, R.raw.sempurna);
//        player.setLooping(true); // Set looping
//        player.setVolume(100,100);

    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        Bundle extras = intent.getExtras();

        if(extras == null) {
            Log.d("Service","null");
        } else {
            Log.d("Service","not null");
            int from = (int) extras.get("From");
            if(from == 0)
                player = MediaPlayer.create(this, R.raw.kekasih_sejati);
            else
                player = MediaPlayer.create(this, R.raw.sempurna);
        }
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
        player.start();
        return 1;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {

    }
    public void onPause() {

    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }

}