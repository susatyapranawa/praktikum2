package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.helper.Helper;


public class Dashboard extends AppCompatActivity {

    TextView tvUsername;
    RelativeLayout ln11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tvUsername = findViewById(R.id.tvUsername);
        ln11 = findViewById(R.id.ln11);

        tvUsername.setText(Helper.getUsername());

        ln11.setOnClickListener(view -> {
           startActivity(new Intent(this, Barang.class));
        });

    }
}