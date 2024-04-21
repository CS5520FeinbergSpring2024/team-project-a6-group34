package edu.northeastern.alarmyquest;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.northeastern.alarmyquest.adapter.CustomSpinnerAdapter;
import edu.northeastern.alarmyquest.utils.AlarmHelper;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private List<String> mediaPlayerList;
    private CustomSpinnerAdapter adapter;
    private TextView tvTime;
    private TextView textView3;
    private ImageView ivShock;
    private TextView tvWeek1, tvWeek2, tvWeek3, tvWeek4, tvWeek5, tvWeek6, tvWeek7;
    private int[] textviewStates = new int[7]; // 保存 TextView 状态的列表
    private boolean isShock = true;
    private LottieAnimationView lav;
    private int currentAnimationIndex;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_TIME = "time";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainData.mediaPlayer = MediaPlayer.create(this, R.raw.bittersweet);


        initTime();

        initLottie();


        initButton();

        initSpinner();


    }

    private void initTime() {
        tvTime = (TextView) findViewById(R.id.tv_time);
        // 恢复保存的内容
        restoreTime();
        // 设置 TextView 的点击事件，点击后弹出时间选择器
        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
    }

    // 显示时间选择器
    private void showTimePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // 处理用户选择的时间
                        String selectedTime = String.format("%02d:%02d", hourOfDay, minute);
                        tvTime.setText(selectedTime);
                        // 保存内容
                        saveTime();
                        String time = tvTime.getText().toString().trim();
                        AlarmHelper.setWeeklyAlarm(MainActivity.this, time,textviewStates);
                    }
                }, hour, minute, true); // true 表示使用 24 小时制

        timePickerDialog.show();
    }

    private void initLottie() {
        lav = (LottieAnimationView) findViewById(R.id.lav);
        List<String> animationFiles = new ArrayList<>();
        animationFiles.add("cat.json");
        animationFiles.add("weather.json");
        animationFiles.add("panda.json");

        currentAnimationIndex = 0;

        lav.setOnClickListener(v -> {
            // 获取下一个动画文件名
            String newFileName = animationFiles.get(currentAnimationIndex);

            // 切换动画文件名
            lav.setAnimation(newFileName);

            // 重新播放动画
            lav.playAnimation();

            // 更新当前动画索引
            currentAnimationIndex = (currentAnimationIndex + 1) % animationFiles.size();
        });
    }

    private void initButton() {
        ivShock = (ImageView) findViewById(R.id.iv_shock);
        tvWeek1 = (TextView) findViewById(R.id.tv_week1);
        tvWeek2 = (TextView) findViewById(R.id.tv_week2);
        tvWeek3 = (TextView) findViewById(R.id.tv_week3);
        tvWeek4 = (TextView) findViewById(R.id.tv_week4);
        tvWeek5 = (TextView) findViewById(R.id.tv_week5);
        tvWeek6 = (TextView) findViewById(R.id.tv_week6);
        tvWeek7 = (TextView) findViewById(R.id.tv_week7);
        // 设置初始状态
        for (int i = 0; i < textviewStates.length; i++) {
            textviewStates[i] = 0; // 初始状态为 0
        }

        // 设置点击监听器
        tvWeek1.setOnClickListener(view -> toggleTextColor(tvWeek1, 0));
        tvWeek2.setOnClickListener(view -> toggleTextColor(tvWeek2, 1));
        tvWeek3.setOnClickListener(view -> toggleTextColor(tvWeek3, 2));
        tvWeek4.setOnClickListener(view -> toggleTextColor(tvWeek4, 3));
        tvWeek5.setOnClickListener(view -> toggleTextColor(tvWeek5, 4));
        tvWeek6.setOnClickListener(view -> toggleTextColor(tvWeek6, 5));
        tvWeek7.setOnClickListener(view -> toggleTextColor(tvWeek7, 6));

        ivShock.setOnClickListener(v -> {
            if (isShock){
                isShock = false;
                ivShock.setImageResource(R.drawable.shock2);
            }else {
                isShock = true;
                ivShock.setImageResource(R.drawable.shock);
            }
        });
    }

    private void toggleTextColor(TextView textView, int index) {
        String time = tvTime.getText().toString().trim();

        if (textviewStates[index] == 0) {
            // 当前状态为未选中，切换为选中状态
            int color = ContextCompat.getColor(this, R.color.MainColor);
            textView.setTextColor(color);
            textviewStates[index] = 1;
        } else {
            // 当前状态为选中，切换为未选中状态
            int color = ContextCompat.getColor(this, R.color.week_color);
            textView.setTextColor(color);
            textviewStates[index] = 0;
        }
        AlarmHelper.setWeeklyAlarm(MainActivity.this, time,textviewStates);


    }
    private void initSpinner() {
        // 设置状态栏颜色为黑色
        setStatusBarColor(getResources().getColor(android.R.color.black));
        spinner = findViewById(R.id.spinner);

        // 准备 MediaPlayer 对象列表
        mediaPlayerList = new ArrayList<>();
        mediaPlayerList.add("bittersweet");
        mediaPlayerList.add("down_stream");
        mediaPlayerList.add("dreamer");
        mediaPlayerList.add("fireflies_and_stardust");
        mediaPlayerList.add("new_dawn");
        mediaPlayerList.add("river_fire");
        mediaPlayerList.add("silver_flame");
        mediaPlayerList.add("soaring");

        // 创建适配器实例
        adapter = new CustomSpinnerAdapter(this, R.layout.spinner_item_select, mediaPlayerList);

        // 设置适配器给 Spinner
        spinner.setAdapter(adapter);
        // 监听 Spinner 选项的选择事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter.stop();
                String rawResourceName = mediaPlayerList.get(position);
                int resId = getResources().getIdentifier(rawResourceName, "raw", getPackageName());
                MainData.mediaPlayer = MediaPlayer.create(MainActivity.this, resId);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    private void saveTime() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_TIME, tvTime.getText().toString());
        editor.apply();
    }

    private void restoreTime() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String savedTime = preferences.getString(KEY_TIME, "7:00");
        tvTime.setText(savedTime);
    }
}