package com.example.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.Adapter.Adapter_Barang;
import com.example.login.Model.m_barang;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class Barang extends AppCompatActivity {
    RecyclerView lvBarang;
    ArrayList<m_barang> data;
    Adapter_Barang adp;
    FirebaseFirestore db;
    FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        lvBarang = findViewById(R.id.lvBarang);
        btnAdd = findViewById(R.id.btnAdd);
        db = FirebaseFirestore.getInstance();

        dataBarang();

        btnAdd.setOnClickListener(view -> {
            startActivity(new Intent(this, Tambah_barang.class));
        });

    }

    public void dataBarang(){
        data = new ArrayList<>();

        ProgressDialog p = new ProgressDialog(this);
        p.setTitle("Loading...");
        p.setMessage("Mohon tunggu sebentar..");
        p.show();
        db.collection("barang")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                //Log.d(TAG, document.getId() + " => " + document.getData());
                                document.getData().get("gambar").toString();
                                data.add(new m_barang(
                                        document.getId(),
                                        Objects.requireNonNull(document.getData().get("nama_barang")).toString(),
                                        Objects.requireNonNull(document.getData().get("harga")).toString(),
                                        Objects.requireNonNull(document.getData().get("satuan")).toString(),
                                        Objects.requireNonNull(document.getData().get("stok")).toString(),
                                        R.drawable.ic_bike
                                ));
                            }
                            adp = new Adapter_Barang(Barang.this, data);
                            LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
                            llm.setOrientation(LinearLayoutManager.VERTICAL);
                            lvBarang.setLayoutManager(llm);
                            lvBarang.setAdapter(adp);
                         }
                            else {
                                Toast.makeText(getApplicationContext(), "Gagal Load!", Toast.LENGTH_SHORT).show();
                            }
                            p.hide();
                        }
                });

        //data.add(new m_barang("1","nama_barang","harga","pcs",R.drawable.ic_bike));
        //data.add(new m_barang("Motor 1","Rp 800.000", "pcs", R.drawable.ic_bike2));
        //adp = new Adapter_Barang(this, data);
        //LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
       //llm.setOrientation(LinearLayoutManager.VERTICAL);
       //lvBarang.setLayoutManager(llm);
        //lvBarang.setAdapter(adp);

    }

}