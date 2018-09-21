package com.example.diamond.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntroduceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
    }

    public void backhome(View view) {
        Intent intent = new Intent(IntroduceActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}
