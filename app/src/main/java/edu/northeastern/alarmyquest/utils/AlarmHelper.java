package edu.northeastern.alarmyquest.utils;

import static android.app.AlarmManager.RTC_WAKEUP;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import edu.northeastern.alarmyquest.receiver.AlarmReceiver;

public class AlarmHelper {

    public static boolean setWeeklyAlarm(Context context, String time, int[] daysToRing) {
        // 解析时间字符串
        int hour, minute;
        try {
            String[] timeParts = time.split(":");
            hour = Integer.parseInt(timeParts[0]);
            minute = Integer.parseInt(timeParts[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false; // 时间格式错误
        }

        // 获取 AlarmManager 实例
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        // 遍历每周的每一天，取消之前设置的闹钟并设置新闹钟
        for (int i = 0; i < daysToRing.length; i++) {
            // 取消之前的闹钟
            Intent cancelIntent = new Intent(context, AlarmReceiver.class);
            PendingIntent cancelPendingIntent = PendingIntent.getBroadcast(context, i, cancelIntent, PendingIntent.FLAG_CANCEL_CURRENT | PendingIntent.FLAG_IMMUTABLE);
            alarmManager.cancel(cancelPendingIntent);
            if (daysToRing[i] == 1) { // 如果这一天需要设置闹钟

                // 设置新闹钟
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK, i + 1); // 设置为星期几
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);

                // 创建 Intent
                // 创建 Intent
                Intent intent = new Intent(context, AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, i, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

                // 设置每周重复闹钟
                // 设置每周重复闹钟
                alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

            }
        }

        return true; // 设置成功
    }

}
