package com.example.diamond.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.diamond.bookmanager.adapater.KindBookAdapter;
import com.example.diamond.bookmanager.adapater.Useradapter;
import com.example.diamond.bookmanager.model.KindBook;
import com.example.diamond.bookmanager.model.User;

import java.util.ArrayList;
import java.util.List;

public class KindActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private List<KindBook> kindBookList;
private KindBookAdapter kindBookAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kind);
        recyclerView= findViewById(R.id.recycler);
kindBookList= new ArrayList<>();
        for(int i=0; i<40;i++){
            kindBookList.add(new KindBook("","Book1"+i,"",""));

        }

        kindBookAdapter= new KindBookAdapter(kindBookList);
        recyclerView.setAdapter(kindBookAdapter);
        RecyclerView.LayoutManager manager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

    }

    public void backhome(View view) {
        Intent intent = new Intent(KindActivity.this,HomeActivity.class);
        startActivity(intent);
    }


}
