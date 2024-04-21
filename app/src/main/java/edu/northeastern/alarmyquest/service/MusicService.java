package edu.northeastern.alarmyquest.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

import edu.northeastern.alarmyquest.MainData;
import edu.northeastern.alarmyquest.R;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        // 创建 MediaPlayer 对象
        mediaPlayer = MainData.mediaPlayer;
        // 设置循环播放
        mediaPlayer.setLooping(true);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 开始播放音乐
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // 释放 MediaPlayer 对象
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
