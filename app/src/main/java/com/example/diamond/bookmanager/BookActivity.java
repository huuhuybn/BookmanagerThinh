package com.example.diamond.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
    }

    public void backhome(View view) {
        Intent intent= new Intent(BookActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}
