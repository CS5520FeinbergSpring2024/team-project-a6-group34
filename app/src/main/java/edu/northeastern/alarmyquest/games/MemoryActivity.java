package edu.northeastern.alarmyquest.games;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.northeastern.alarmyquest.MainData;
import edu.northeastern.alarmyquest.R;

public class MemoryActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,
            a16,a17,a18,a19,a20,a21,a22,a23,a24,a25,a26,a27,a28,
            a29,a30,a31,a32,a33,a34,a35,a36,a37,a38,a39,a40,a41,
            a42,a43,a44,a45,a46,a47,a48,a49,kaishi,guanqia;
    private List<String> suzi= new ArrayList<String>();
    private List<TextView> tv_shuzi= new ArrayList<>();
    private Long time1;
    private int guanqia_num = 3;
    private int user_click = 1;
    private boolean key = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        init();


    }
    //注意力测试的声明
    private void init() {

        kaishi = findViewById(R.id.kaishi);
        guanqia = findViewById(R.id.guanqia);
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);
        a9 = findViewById(R.id.a9);
        a10 = findViewById(R.id.a10);
        a11 = findViewById(R.id.a11);
        a12 = findViewById(R.id.a12);
        a13 = findViewById(R.id.a13);
        a14 = findViewById(R.id.a14);
        a15 = findViewById(R.id.a15);
        a16 = findViewById(R.id.a16);
        a17 = findViewById(R.id.a17);
        a18 = findViewById(R.id.a18);
        a19 = findViewById(R.id.a19);
        a20 = findViewById(R.id.a20);
        a21 = findViewById(R.id.a21);
        a22 = findViewById(R.id.a22);
        a23 = findViewById(R.id.a23);
        a24 = findViewById(R.id.a24);
        a25 = findViewById(R.id.a25);
        a26 = findViewById(R.id.a26);
        a27 = findViewById(R.id.a27);
        a28 = findViewById(R.id.a28);
        a29 = findViewById(R.id.a29);
        a30 = findViewById(R.id.a30);
        a31 = findViewById(R.id.a31);
        a32 = findViewById(R.id.a32);
        a33 = findViewById(R.id.a33);
        a34 = findViewById(R.id.a34);
        a35 = findViewById(R.id.a35);
        a36 = findViewById(R.id.a36);
        a37 = findViewById(R.id.a37);
        a38 = findViewById(R.id.a38);
        a39 = findViewById(R.id.a39);
        a40 = findViewById(R.id.a40);
        a41 = findViewById(R.id.a41);
        a42 = findViewById(R.id.a42);
        a43 = findViewById(R.id.a43);
        a44 = findViewById(R.id.a44);
        a45 = findViewById(R.id.a45);
        a46 = findViewById(R.id.a46);
        a47 = findViewById(R.id.a47);
        a48 = findViewById(R.id.a48);
        a49 = findViewById(R.id.a49);
        kaishi.setOnClickListener(this);
        a1.setOnClickListener(this);
        a2.setOnClickListener(this);
        a3.setOnClickListener(this);
        a4.setOnClickListener(this);
        a5.setOnClickListener(this);
        a6.setOnClickListener(this);
        a7.setOnClickListener(this);
        a8.setOnClickListener(this);
        a9.setOnClickListener(this);
        a10.setOnClickListener(this);
        a11.setOnClickListener(this);
        a12.setOnClickListener(this);
        a13.setOnClickListener(this);
        a14.setOnClickListener(this);
        a15.setOnClickListener(this);
        a16.setOnClickListener(this);
        a17.setOnClickListener(this);
        a18.setOnClickListener(this);
        a19.setOnClickListener(this);
        a20.setOnClickListener(this);
        a21.setOnClickListener(this);
        a22.setOnClickListener(this);
        a23.setOnClickListener(this);
        a24.setOnClickListener(this);
        a25.setOnClickListener(this);
        a26.setOnClickListener(this);
        a27.setOnClickListener(this);
        a28.setOnClickListener(this);
        a29.setOnClickListener(this);
        a30.setOnClickListener(this);
        a31.setOnClickListener(this);
        a32.setOnClickListener(this);
        a33.setOnClickListener(this);
        a34.setOnClickListener(this);
        a35.setOnClickListener(this);
        a36.setOnClickListener(this);
        a37.setOnClickListener(this);
        a38.setOnClickListener(this);
        a39.setOnClickListener(this);
        a40.setOnClickListener(this);
        a41.setOnClickListener(this);
        a42.setOnClickListener(this);
        a43.setOnClickListener(this);
        a44.setOnClickListener(this);
        a45.setOnClickListener(this);
        a46.setOnClickListener(this);
        a47.setOnClickListener(this);
        a48.setOnClickListener(this);
        a49.setOnClickListener(this);
        tv_shuzi.add(a1);
        tv_shuzi.add(a2);
        tv_shuzi.add(a3);
        tv_shuzi.add(a4);
        tv_shuzi.add(a5);
        tv_shuzi.add(a6);
        tv_shuzi.add(a7);
        tv_shuzi.add(a8);
        tv_shuzi.add(a9);
        tv_shuzi.add(a10);
        tv_shuzi.add(a11);
        tv_shuzi.add(a12);
        tv_shuzi.add(a13);
        tv_shuzi.add(a14);
        tv_shuzi.add(a15);
        tv_shuzi.add(a16);
        tv_shuzi.add(a17);
        tv_shuzi.add(a18);
        tv_shuzi.add(a19);
        tv_shuzi.add(a20);
        tv_shuzi.add(a21);
        tv_shuzi.add(a22);
        tv_shuzi.add(a23);
        tv_shuzi.add(a24);
        tv_shuzi.add(a25);
        tv_shuzi.add(a26);
        tv_shuzi.add(a27);
        tv_shuzi.add(a28);
        tv_shuzi.add(a29);
        tv_shuzi.add(a30);
        tv_shuzi.add(a31);
        tv_shuzi.add(a32);
        tv_shuzi.add(a33);
        tv_shuzi.add(a34);
        tv_shuzi.add(a35);
        tv_shuzi.add(a36);
        tv_shuzi.add(a37);
        tv_shuzi.add(a38);
        tv_shuzi.add(a39);
        tv_shuzi.add(a40);
        tv_shuzi.add(a41);
        tv_shuzi.add(a42);
        tv_shuzi.add(a43);
        tv_shuzi.add(a44);
        tv_shuzi.add(a45);
        tv_shuzi.add(a46);
        tv_shuzi.add(a47);
        tv_shuzi.add(a48);
        tv_shuzi.add(a49);

    }

    private void anniu(View view){
        if (view instanceof TextView) {
            TextView a = (TextView) view;
            if (key){
                String str = suzi.get(tv_shuzi.indexOf(a));
                if (str.isEmpty()){
                    return;
                }
                if (str.equals(String.valueOf(user_click))){
                    user_click ++;
                    a.setText(""+(user_click-1));
                }else {
                    a.setText(str);
                    a.setTextColor(this.getResources().getColor(R.color.red));
                    //TODO 判断用户有没有超过5关
                    int g = guanqia_num-2;
                    kaishi.setText("Start");
                    guanqia_num = 3;
                    user_click = 1;
                    if (g<5){
                        Toast.makeText(MemoryActivity.this, "The game ends, failure is canceled if the score is too low.", Toast.LENGTH_SHORT).show();
                    }else {
                        // 关闭音乐
                        stopService(MainData.musicIntent);
                        finish();
                    }

                }
                if (user_click > guanqia_num){
                    Toast.makeText(MemoryActivity.this, "Pass to the next level", Toast.LENGTH_SHORT).show();
                    key = false;
                    user_click = 1;
                    guanqia_num ++;
                    guanqia.setText("Level : "+(guanqia_num-2));
                    kaishi.setText("Start");
                    for (int i = 0; i < 49; i++) {
                        tv_shuzi.get(i).setBackgroundResource(R.drawable.zhuyili);
                        tv_shuzi.get(i).setText("");
                    }
                    if ((guanqia_num-2)>=5)
                        stopService(MainData.musicIntent);
                }
            }
        }
    }
    @Override
    public void onClick(View view) {
//        switch (view.getId()){
//            case R.id.a1:
//                anniu(a1);
//                break;
//            case R.id.a2:
//                anniu(a2);
//                break;
//            case R.id.a3:
//                anniu(a3);
//                break;
//            case R.id.a4:
//                anniu(a4);
//                break;
//            case R.id.a5:
//                anniu(a5);
//                break;
//            case R.id.a6:
//                anniu(a6);
//                break;
//            case R.id.a7:
//                anniu(a7);
//                break;
//            case R.id.a8:
//                anniu(a8);
//                break;
//            case R.id.a9:
//                anniu(a9);
//                break;
//            case R.id.a10:
//                anniu(a10);
//                break;
//            case R.id.a11:
//                anniu(a11);
//                break;
//            case R.id.a12:
//                anniu(a12);
//                break;
//            case R.id.a13:
//                anniu(a13);
//                break;
//            case R.id.a14:
//                anniu(a14);
//                break;
//            case R.id.a15:
//                anniu(a15);
//                break;
//            case R.id.a16:
//                anniu(a16);
//                break;
//            case R.id.a17:
//                anniu(a17);
//                break;
//            case R.id.a18:
//                anniu(a18);
//                break;
//            case R.id.a19:
//                anniu(a19);
//                break;
//            case R.id.a20:
//                anniu(a20);
//                break;
//            case R.id.a21:
//                anniu(a21);
//                break;
//            case R.id.a22:
//                anniu(a22);
//                break;
//            case R.id.a23:
//                anniu(a23);
//                break;
//            case R.id.a24:
//                anniu(a24);
//                break;
//            case R.id.a25:
//                anniu(a25);
//                break;
//            case R.id.a26:
//                anniu(a26);
//                break;
//            case R.id.a27:
//                anniu(a27);
//                break;
//            case R.id.a28:
//                anniu(a28);
//                break;
//            case R.id.a29:
//                anniu(a29);
//                break;
//            case R.id.a30:
//                anniu(a30);
//                break;
//            case R.id.a31:
//                anniu(a31);
//                break;
//            case R.id.a32:
//                anniu(a32);
//                break;
//            case R.id.a33:
//                anniu(a33);
//                break;
//            case R.id.a34:
//                anniu(a34);
//                break;
//            case R.id.a35:
//                anniu(a35);
//                break;
//            case R.id.a36:
//                anniu(a36);
//                break;
//            case R.id.a37:
//                anniu(a37);
//                break;
//            case R.id.a38:
//                anniu(a38);
//                break;
//            case R.id.a39:
//                anniu(a39);
//                break;
//            case R.id.a40:
//                anniu(a40);
//                break;
//            case R.id.a41:
//                anniu(a41);
//                break;
//            case R.id.a42:
//                anniu(a42);
//                break;
//            case R.id.a43:
//                anniu(a43);
//                break;
//            case R.id.a44:
//                anniu(a44);
//                break;
//            case R.id.a45:
//                anniu(a45);
//                break;
//            case R.id.a46:
//                anniu(a46);
//                break;
//            case R.id.a47:
//                anniu(a47);
//                break;
//            case R.id.a48:
//                anniu(a48);
//                break;
//            case R.id.a49:
//                anniu(a49);
//                break;
//            case R.id.kaishi:
//                if (kaishi.getText().toString().equals("Start")){
//                    guanqia.setText("第"+(guanqia_num-2)+"关");
//                    key = false;
//                    kaishi.setText("Memory Completed");
//                    suzi.clear();
//                    if (guanqia_num==3){
//                        time1 = System.currentTimeMillis();
//                    }
//                    //注意力训练的列表
//                    for (int i=1;i<=guanqia_num;i++){
//                        suzi.add(String.valueOf(i));
//                    }
//                    while (suzi.size()<49){
//                        suzi.add("");
//                    }
//                    Collections.shuffle(suzi);
//                    //显示内容
//                    for (int i = 0; i < 49; i++) {
//                        tv_shuzi.get(i).setText(suzi.get(i));
//                        tv_shuzi.get(i).setTextColor(this.getResources().getColor(R.color.black));
//                        if (!suzi.get(i).isEmpty()){
//                            tv_shuzi.get(i).setBackgroundResource(R.drawable.jyl);
//                        }else {
//                            tv_shuzi.get(i).setBackgroundResource(R.drawable.zhuyili);
//                        }
//                    }
//                }else if (kaishi.getText().toString().equals("Memory Completed")){
//                    key = true;
//                    //清空显示
//                    for (int i = 0; i < 49; i++) {
//                        tv_shuzi.get(i).setText("");
//                    }
//                }
//                break;
//        }
        if (view.getId() == R.id.kaishi) {
            if (kaishi.getText().toString().equals("Start")) {
                guanqia.setText("Level :" + (guanqia_num - 2));
                key = false;
                kaishi.setText("Memory Completed");
                suzi.clear();
                if (guanqia_num == 3) {
                    time1 = System.currentTimeMillis();
                }
                // 注意力训练的列表
                for (int i = 1; i <= guanqia_num; i++) {
                    suzi.add(String.valueOf(i));
                }
                while (suzi.size() < 49) {
                    suzi.add("");
                }
                Collections.shuffle(suzi);
                // 显示内容
                for (int i = 0; i < 49; i++) {
                    tv_shuzi.get(i).setText(suzi.get(i));
                    tv_shuzi.get(i).setTextColor(this.getResources().getColor(R.color.black));
                    tv_shuzi.get(i).setBackgroundResource(!suzi.get(i).isEmpty() ? R.drawable.jyl : R.drawable.zhuyili);
                }
            } else if (kaishi.getText().toString().equals("Memory Completed")) {
                key = true;
                // 清空显示
                for (int i = 0; i < 49; i++) {
                    tv_shuzi.get(i).setText("");
                }
            }
        } else {
            anniu(view);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        kaishi.setText("Start");
        guanqia_num = 3;
        user_click = 1;
    }
}