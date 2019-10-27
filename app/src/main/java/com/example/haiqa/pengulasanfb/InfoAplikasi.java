package com.example.haiqa.pengulasanfb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InfoAplikasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Info Aplikasi");
        setContentView(R.layout.activity_info_aplikasi);
    }
}
