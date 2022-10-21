package com.example.login.helper;

import android.widget.ImageButton;

import com.google.android.material.imageview.ShapeableImageView;

public class Helper {
    static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Helper.username = username;
    }
}
