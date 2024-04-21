package edu.northeastern.alarmyquest.games;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Random;

import edu.northeastern.alarmyquest.MainData;
import edu.northeastern.alarmyquest.R;

public class InstantActivity extends AppCompatActivity {
    private TextView t1,t2,t3,t4,t5,t6,t7,t8;
    private static long time1 ;
    private String str_daan;
    public static int delay_time=800;
    private long ck;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instant);

        init();
    }
    private void init() {
        button = findViewById(R.id.button);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        et_clear();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setEnabled(false);
                time1 = System.currentTimeMillis();
                Random r = new Random();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    t1.setText(""+r.nextInt(10));
                                    t2.setText(""+r.nextInt(10));
                                    t3.setText(""+r.nextInt(10));
                                    t4.setText(""+r.nextInt(10));
                                    t5.setText(""+r.nextInt(10));
                                    t6.setText(""+r.nextInt(10));
                                    t7.setText(""+r.nextInt(10));
                                    t8.setText(""+r.nextInt(10));
                                }
                            });
                            Thread.sleep(delay_time);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    et_save();
                                    et_clear();
                                }
                            });
                            Thread.sleep(1000);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    final AlertDialog mDialog = new AlertDialog.Builder(InstantActivity.this)
                                            .setPositiveButton("ok",null)
                                            .setNegativeButton("no",null)
                                            .create();
                                    mDialog.setTitle("Submit");
                                    final View contentView = getLayoutInflater().inflate(R.layout.dialog_edit,null);
                                    mDialog.setView(contentView);
                                    final TextInputLayout textInputLayout = contentView.findViewById(R.id.textInputLayout);
                                    textInputLayout.setHint("Please enter the sequence of numbers you see");
                                    final TextInputEditText edit1 = contentView.findViewById(R.id.editText);
                                    edit1.setInputType(InputType.TYPE_CLASS_TEXT);
                                    edit1.setSingleLine(false);
                                    edit1.addTextChangedListener(new TextWatcher() {
                                        @Override
                                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                                            textInputLayout.setErrorEnabled(false);
                                        }

                                        @Override
                                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                                        }

                                        @Override
                                        public void afterTextChanged(Editable s) {
                                        }
                                    });
                                    mDialog.setOnShowListener(new DialogInterface.OnShowListener() {
                                        @Override
                                        public void onShow(DialogInterface dialog) {
                                            Button positiveButton = mDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                                            Button negativeButton = mDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                                            edit1.setInputType(InputType.TYPE_CLASS_NUMBER);
                                            positiveButton.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    if (TextUtils.isEmpty(edit1.getText().toString())){
                                                        textInputLayout.setError("Please enter the sequence of numbers you see");
                                                        textInputLayout.setErrorEnabled(true);
                                                    }else {
                                                        if (str_daan.equals(edit1.getText().toString())){
                                                            ck = System.currentTimeMillis()-time1;
                                                            Toast.makeText(InstantActivity.this, "Correct answer\ntook："+ck, Toast.LENGTH_SHORT).show();

                                                            stopService(MainData.musicIntent);
                                                            finish();

                                                        }else {
                                                            Toast.makeText(InstantActivity.this, "Answer incorrect", Toast.LENGTH_SHORT).show();
                                                            mDialog.dismiss();
                                                        }
                                                    }
                                                    button.setEnabled(true);
                                                }
                                            });
                                            negativeButton.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    button.setEnabled(true);
                                                    mDialog.dismiss();
                                                }
                                            });
                                        }
                                    });
                                    mDialog.show();
                                    WindowManager.LayoutParams layoutParams = mDialog.getWindow().getAttributes();
                                    layoutParams.width = InstantActivity.this.getResources().getDisplayMetrics().widthPixels/5*4;
                                    mDialog.getWindow().setAttributes(layoutParams);
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    private void et_clear(){
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
    }
    private void et_save(){
        str_daan = t1.getText().toString().trim()+t2.getText().toString().trim()+t3.getText().toString().trim()+
                t4.getText().toString().trim()+t5.getText().toString().trim()+t6.getText().toString().trim()+
                t7.getText().toString().trim()+t8.getText().toString().trim();
    }

}