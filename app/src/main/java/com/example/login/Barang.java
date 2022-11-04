package com.example.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.Adapter.Adapter_Barang;
import com.example.login.Model.m_barang;

import java.util.ArrayList;

public class Barang extends AppCompatActivity {
    RecyclerView lvBarang;
    ArrayList<m_barang> data;
    Adapter_Barang adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        lvBarang = findViewById(R.id.lvBarang);

        dataBarang();

    }

    public void dataBarang(){
        data = new ArrayList<>();
        data.add(new m_barang("Monitor", R.drawable.ic_bike));
        data.add(new m_barang("Keyboard",R.drawable.ic_profil));
        adp = new Adapter_Barang(this, data);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lvBarang.setLayoutManager(llm);
        lvBarang.setAdapter(adp);
    }

}