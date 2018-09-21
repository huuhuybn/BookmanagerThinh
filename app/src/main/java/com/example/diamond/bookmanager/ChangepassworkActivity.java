package com.example.diamond.bookmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangepassworkActivity extends AppCompatActivity {
private EditText edtold;
private EditText edtnew;
private Button btnchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepasswork);
        edtold=findViewById(R.id.oldpass);
        edtnew=findViewById(R.id.newpassword);
        btnchange= findViewById(R.id.btnchange);
intView();
btnchange.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String passold= edtnew.getText().toString().trim();
        if(passold.matches("")){
            edtold.setError(getString(R.string.loi));
            return;
        }
        String pass= edtnew.getText().toString().trim();
        if(pass.matches("")){
            edtnew.setError(getString(R.string.loi));
            return;
        }else if (pass.length()<6){
            edtnew.setError(getString(R.string.loi1));
            return;
        }
        Toast.makeText(ChangepassworkActivity.this, "Thay đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(ChangepassworkActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
});
    }




    public void backhome(View view) {
        Intent intent= new Intent(ChangepassworkActivity.this, HomeActivity.class);
        startActivity(intent);
    }
public void intView(){

}
}
