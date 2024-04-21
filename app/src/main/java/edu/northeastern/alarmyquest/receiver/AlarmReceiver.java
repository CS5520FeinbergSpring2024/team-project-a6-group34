package edu.northeastern.alarmyquest.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;

import edu.northeastern.alarmyquest.GameActivity;
import edu.northeastern.alarmyquest.MainData;
import edu.northeastern.alarmyquest.service.MusicService;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
// 启动播放音乐的服务
        MainData.musicIntent = new Intent(context, MusicService.class);
        context.startService(MainData.musicIntent);

        // 添加震动功能
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null) {
            vibrator.vibrate(2000); // 震动2秒钟
        }

        Intent startIntent = new Intent(context, GameActivity.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // 启动界面
        context.startActivity(startIntent);
    }
}
