package com.example.login.Model;

public class m_barang {
    String nama_barang;
    String harga2;
    int img;

    public m_barang(String nama_barang,String harga2, int img) {
        this.nama_barang = nama_barang;
        this.harga2 = harga2;

        this.img = img;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getHarga2() {
        return harga2;
    }

    public void setHarga2(String harga2) {
        this.harga2 = harga2;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
