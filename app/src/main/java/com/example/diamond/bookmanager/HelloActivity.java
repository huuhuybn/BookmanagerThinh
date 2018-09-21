package com.example.diamond.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        // CHuyển màn hình sau 2 giây
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(HelloActivity.this,LoginActivity.class);
                startActivity(intent);
                //tắt màn hình chào
                finish();
            }
        }, 2000);
    }
}
