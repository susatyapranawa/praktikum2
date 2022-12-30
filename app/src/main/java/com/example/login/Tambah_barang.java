package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.login.Adapter.Adapter_Barang;
import com.example.login.Model.m_barang;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Tambah_barang extends AppCompatActivity {

    EditText txtNamaBrg;
    EditText txtHargaBrg;
    EditText txtJumlahStok;
    Button btnInputBarang;
    Spinner spinner1;
    ArrayList<String> satuan;
    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_barang);

        txtNamaBrg = findViewById(R.id.txtNamaBrg);
        txtHargaBrg = findViewById(R.id.txtHargaBrg);
        txtJumlahStok = findViewById(R.id.txtJumlahStok);
        btnInputBarang = findViewById(R.id.btnInputBarang);
        spinner1 = findViewById(R.id.spinner1);
        db = FirebaseFirestore.getInstance();

        fetchSpinner();

        btnInputBarang.setOnClickListener(view -> {
            ProgressDialog p = new ProgressDialog(this);
            p.setTitle("Loading");
            p.setMessage("Sedang tambah data..");
            p.show();

            Map<String, Object> brg = new HashMap<>();
            brg.put("gambar", "tes.jpg");
            brg.put("harga", Integer.parseInt(txtHargaBrg.getText().toString()));
            brg.put("nama_barang",txtNamaBrg.getText().toString());
            brg.put("satuan",spinner1.getSelectedItem());
            brg.put("stok", Integer.parseInt(txtJumlahStok.getText().toString()));

            db.collection("barang")
                    .add(brg)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(getApplicationContext(), "Sukses Tambah Data", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Barang.class));
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Gagal Tambah Data", Toast.LENGTH_SHORT).show();
                        }
                    });
                    p.hide();
        });

    }

    private void fetchSpinner(){
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