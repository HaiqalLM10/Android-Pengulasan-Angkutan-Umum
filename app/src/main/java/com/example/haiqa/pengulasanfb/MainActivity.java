package com.example.haiqa.pengulasanfb;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    ImageButton tombol1, tombol2;
    private ImageButton imgbtnscan;
    String barcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Home");
        setContentView(R.layout.activity_main);
        imgbtnscan = (ImageButton) findViewById(R.id.imgbtnscan);
        final Activity activity = this;
        imgbtnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Place a Barcode Inside the Viewfinder Rectangle to Scan It");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
        //buat multiple activities
        tombol1 = (ImageButton) findViewById(R.id.imgbtnbantuan);
        tombol2 = (ImageButton) findViewById(R.id.imgbtninfo);

        //Method untuk tombol bantuan
        tombol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menambah perintah dari kejadian tombol 1 klik
                Intent intent = new Intent(MainActivity.this, BantuanAplikasi.class);
                startActivity(intent);
            }
        });

        tombol2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoAplikasi.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "You Cancelled the Scanning", Toast.LENGTH_LONG).show();

            } else {
                barcode = result.getContents().toString();
                if(barcode.equalsIgnoreCase("B1214FD")){
                    barcode = result.getContents().toString();
                    CustomShared.setAdsID(MainActivity.this,"adsId",barcode);
                    Toast.makeText(this, barcode, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, InformasiSatuActivity.class);
                    startActivity(intent);

                } else if(barcode.equalsIgnoreCase("B2138PG")){
                    barcode = result.getContents().toString();
                    CustomShared.setAdsID(MainActivity.this,"adsId",barcode);
                    Toast.makeText(this, barcode, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, InformasiDuaActivity.class);
                    startActivity(intent);

                } else if (barcode.equalsIgnoreCase("B3621QO")){
                    barcode = result.getContents().toString();
                    CustomShared.setAdsID(MainActivity.this,"adsId",barcode);
                    Toast.makeText(this, barcode, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, InformasiTigaActivity.class);
                    startActivity(intent);
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

