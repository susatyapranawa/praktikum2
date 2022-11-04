package com.example.login.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.Detail_barang;
import com.example.login.Model.m_barang;
import com.example.login.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter_Barang extends RecyclerView.Adapter<Adapter_Barang.BarangViewHolder> {
    private final Context mCtx;
    private final ArrayList<m_barang> listBarang;

    public Adapter_Barang(Context mCtx, ArrayList<m_barang> listHasil) {
        this.mCtx = mCtx;
        this.listBarang = listHasil;
    }

    @NonNull
    @Override
    public BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.list_barang, null);
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangViewHolder holder, int position) {
        m_barang mb = listBarang.get(position);
        holder.tvNama.setText(mb.getNama_barang());
        holder.tvHarga2.setText(mb.getHarga2());
        holder.imgBarang.setImageResource(mb.getImg());

        holder.imgBarang.setOnClickListener(view -> {
            view.getContext().startActivity(new Intent(mCtx, Detail_barang.class));
        });
//
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    static class BarangViewHolder extends RecyclerView.ViewHolder {

        TextView tvHarga2;
        TextView tvNama;
        ImageView imgBarang;

        public BarangViewHolder(View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvHarga2 = itemView.findViewById(R.id.tvHarga2);
            imgBarang = itemView.findViewById(R.id.imgBrg);
        }
    }
}
