package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.helper.Helper;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    Button btnLogin;
    TextView tvDaftar;
    String username = "12345";
    String password = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvDaftar = findViewById(R.id.tvDaftar);

        btnLogin.setOnClickListener(view -> {
           String user =  txtUsername.getText().toString();
           String pass =  txtPassword.getText().toString();

           if((user.equals(username)) && (pass.equals(password))) {
               Toast.makeText(this,"Sukses Login", Toast.LENGTH_SHORT).show();
               Helper.setUsername(user);
               startActivity(new Intent(this, Dashboard.class));
           }else {
               Toast.makeText(this,"Gagal Login", Toast.LENGTH_SHORT).show();
           }
            });
    }
}