package com.example.diamond.bookmanager.reclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.diamond.bookmanager.BookActivity;
import com.example.diamond.bookmanager.HomeActivity;
import com.example.diamond.bookmanager.R;
import com.example.diamond.bookmanager.adapater.Useradapter;
import com.example.diamond.bookmanager.model.User;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewUser extends AppCompatActivity {
private RecyclerView recyclerView;
private List<User> userList;
private Useradapter useradapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view_user);
        recyclerView= findViewById(R.id.recycler);
        userList= new ArrayList<>();

        for(int i=0; i<40;i++){
            userList.add(new User("Diamond"+i, "","Diamond"+i,""));

        }
        useradapter= new Useradapter(userList);
        recyclerView.setAdapter(useradapter);
        RecyclerView.LayoutManager manager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }

    public void backhome(View view) {
        Intent intent= new Intent(RecylerViewUser.this,HomeActivity.class);
        startActivity(intent);
    }
}
