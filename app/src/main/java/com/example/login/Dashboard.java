package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.login.helper.Helper;
import com.google.android.material.imageview.ShapeableImageView;

public class Dashboard extends AppCompatActivity {

    TextView tvUsername;
    ShapeableImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tvUsername = findViewById(R.id.tvUsername);
        img1 = findViewById(R.id.img1);

        tvUsername.setText(Helper.getUsername());

        img1.setOnClickListener(view -> {
            startActivity(new Intent(this, Barang.class));
        });
    }
}