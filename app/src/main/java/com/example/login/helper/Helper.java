package com.example.login.helper;

import com.example.login.Model.m_barang;

import java.util.ArrayList;

public class Helper {
    static String username;
    static ArrayList<m_barang> barang;

    public static ArrayList<m_barang> getBarang() {
        return barang;
    }

    public static void setBarang(ArrayList<m_barang> barang) {
        Helper.barang = barang;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {

        Helper.username = username;
    }

}
