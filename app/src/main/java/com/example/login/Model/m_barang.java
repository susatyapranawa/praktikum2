package com.example.login.Model;

public class m_barang {
    String id_barang;
    String nama_barang;
    String harga2;
    String satuan;
    String stok;
    int img;

    public m_barang(String id_barang, String nama_barang, String harga2, String satuan, String stok) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.harga2 = harga2;
        this.satuan = satuan;
        this.stok = stok;
    }

    public m_barang(String id_barang, String nama_barang, String harga2, String satuan, String stok, int img) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.harga2 = harga2;
        this.satuan = satuan;
        this.stok = stok;
        this.img = img;
    }

    public String getId_barang() { return id_barang; }

    public void setId_barang(String id_barang) { this.id_barang = id_barang; }

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

    public String getSatuan() { return satuan; }

    public void setSatuan(String satuan) { this.satuan = satuan; }

    public String getStok() { return stok; }

    public void setStok(String stok) { this.stok = stok; }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
