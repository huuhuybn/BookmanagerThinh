package com.example.diamond.bookmanager;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.diamond.bookmanager.reclerview.RecylerViewUser;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_user) {
            AlertDialog.Builder builder= new AlertDialog.Builder(this);
            builder.setTitle("Add User");

            LayoutInflater inflater= (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View view= inflater.inflate(R.layout.user_dialog, null);
builder.setView(view);
          final   EditText edt_name_user= view.findViewById(R.id.edt_name_user);
          final EditText edt_password_user= view.findViewById(R.id.edt_password_user);
          final EditText edt_password_again= view.findViewById(R.id.edt_password_again);
          final EditText edt_phone= view.findViewById(R.id.edt_phone);
          final  EditText edt_full_name= view.findViewById(R.id.edt_full_name);
           builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {

               }
           });
           builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {

               }
           });
            builder.show();

        }else if (id==R.id.action_listuser){
            Intent intent = new Intent(HomeActivity.this, RecylerViewUser.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_kindbook) {
            Intent intent= new Intent(HomeActivity.this, KindActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_book) {
            Intent intent= new Intent(HomeActivity.this, BookActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_bill) {
            Intent intent= new Intent(HomeActivity.this, BillActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_introduce) {
            Intent intent= new Intent(HomeActivity.this, IntroduceActivity.class);
            startActivity(intent);
        } else if(id== R.id.nav_changepass){
            Intent intent= new Intent(HomeActivity.this, ChangepassworkActivity.class);
            startActivity(intent);
        } else if(id== R.id.nav_logout){
            Intent intent= new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        };



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
