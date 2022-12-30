package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.login.helper.Helper;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kelola_barang extends AppCompatActivity {
    EditText txtNamaBrg, txtHargaBrg, txtJumlahStok;
    Spinner spinner1;
    Button btnUbahBarang;
    Button btnHapusBarang;
    ArrayList<String> satuan;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelola_barang);

        txtNamaBrg = findViewById(R.id.txtNamaBrg);
        txtHargaBrg = findViewById(R.id.txtHargaBrg);
        txtJumlahStok = findViewById(R.id.txtJumlahStok);
        btnUbahBarang = findViewById(R.id.btnUbahBarang);
        btnHapusBarang = findViewById(R.id.btnHapusBarang);
        spinner1 = findViewById(R.id.spinner1);

        db = FirebaseFirestore.getInstance();
        setData();
        fetchSpinner();

        btnUbahBarang.setOnClickListener(view -> {
            Map<String, Object> brg = new HashMap<>();
            brg.put("harga", Integer.parseInt(txtHargaBrg.getText().toString()));
            brg.put("nama_barang", txtNamaBrg.getText().toString());
            brg.put("satuan", spinner1.getSelectedItem());
            brg.put("stok", Integer.parseInt(txtJumlahStok.getText().toString()));

            db.collection("barang")
                    .document(Helper.getBarang().get(0).getId_barang())
                    .update(brg)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Kelola_barang.this, "Sukses ubah barang", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Kelola_barang.this, Barang.class));
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Kelola_barang.this, "Gagal ubah barang", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        btnHapusBarang.setOnClickListener(view -> {
            db.collection("barang")
                    .document(Helper.getBarang().get(0).getId_barang())
                    .delete()
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Kelola_barang.this, "Sukses hapus barang", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Kelola_barang.this, Barang.class));
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Kelola_barang.this, "Gagal hapus barang", Toast.LENGTH_SHORT).show();
                        }
                    });
        });
    }


    private void setData() {
        txtNamaBrg.setText(Helper.getBarang().get(0).getNama_barang());
        txtHargaBrg.setText(Helper.getBarang().get(0).getHarga2());
        txtJumlahStok.setText(Helper.getBarang().get(0).getStok());
    }

    private void fetchSpinner() {
        satuan = new ArrayList<>();
        satuan.add("pcs");
        satuan.add("kg");
        satuan.add("tablet");
        satuan.add("liter");

        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, satuan);
        spinner1.setAdapter(adp);
    }
}