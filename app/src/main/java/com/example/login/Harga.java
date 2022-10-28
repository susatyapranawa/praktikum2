package com.example.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.login.Adapter.Adapter_Barang;
import com.example.login.Model.m_barang;

import java.util.ArrayList;

public class Harga extends AppCompatActivity {
    RecyclerView lvHarga;
    ArrayList<m_barang> data;
    Adapter_Barang adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harga);

        lvHarga = findViewById(R.id.lvHarga);

        dataHarga();
    }

    public void dataHarga(){
        data = new ArrayList<>();
        data.add(new m_barang("Rp 2.000.000", R.drawable.ic_bike));
        data.add(new m_barang("Rp 500.000", R.drawable.ic_profil));
        adp = new Adapter_Barang(this, data);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lvHarga.setLayoutManager(llm);
        lvHarga.setAdapter(adp);
    }
}