package com.example.diamond.bookmanager;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.DragAndDropPermissions;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diamond.bookmanager.database.DatabaseHelper;
import com.example.diamond.bookmanager.model.User;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private EditText editname;
    private EditText password;
    private Button btnlogin;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        databaseHelper = new DatabaseHelper(this);




       User user = new User("admin", "admin123", "diamond", "0936669520");
        databaseHelper.insertUser(user);
//         User user1= databaseHelper.getUser("admin");
//         //nếu user1 trả về null là chưa tồn tại thì insert user
//         if (user==null){
//             databaseHelper.inserUser(user);
//         }else {
//             // user đã tồn tại
//             Toast.makeText(this, "User đã tồn tại", Toast.LENGTH_SHORT).show();
//         }


        initView();
        btnlogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editname.getText().toString().trim();
                String pass = password.getText().toString().trim();
//        Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
//        startActivity(intent);
//        if (name.matches("")){
//            editname.setError(getString(R.string.loi));
//            return;
//        }
//
//        if(pass.matches("")){
//password.setError(getString(R.string.loi));
//return;
//        }else if (pass.length()<6){
//            password.setError(getString(R.string.loi1));
//            return;
//        }
//        Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
//        startActivity(intent);


                User user = databaseHelper.getUser(name);
                if (user != null) {
                    String originalPassword = user.getPassword();
                    if (originalPassword.equals(pass)) {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
//             finish();
                    } else {
                        Toast.makeText(LoginActivity.this, getString(R.string.erro_login), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, getString(R.string.erro_login), Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public void initView() {
        editname = findViewById(R.id.edtname);
        password = findViewById(R.id.edtpassword);
        btnlogin = findViewById(R.id.btnlogin);
    }
}

