package edu.northeastern.alarmyquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import edu.northeastern.alarmyquest.games.InstantActivity;
import edu.northeastern.alarmyquest.games.MemoryActivity;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        findViewById(R.id.btn_im).setOnClickListener(v -> {
            Intent startIntent = new Intent(this, InstantActivity.class);
            startActivity(startIntent);
        });
        findViewById(R.id.btn_mg).setOnClickListener(v -> {
            Intent startIntent = new Intent(this, MemoryActivity.class);
            startActivity(startIntent);
        });
    }
}