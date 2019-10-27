package com.example.haiqa.pengulasanfb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformasiSatuActivity extends AppCompatActivity {

    private Button btCreateDB;
    private Button btViewDB;
    private Button btLokasi;

    String code ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Informasi");
        setContentView(R.layout.activity_informasi_satu);

        btCreateDB = (Button) findViewById(R.id.bt_createulasan);
        btViewDB = (Button) findViewById(R.id.bt_viewulasan);
        btLokasi = (Button) findViewById(R.id.bt_place);
        code = CustomShared.getAdsID(this,"adsId").toString();
        TextView mTextView = (TextView) findViewById(R.id.plat_nomor);
        mTextView.setText(""+code);
        btCreateDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomShared.setAdsID(InformasiSatuActivity.this,"inform",code);
                startActivity(FirebaseDBCreateActivity.getActIntent(InformasiSatuActivity.this));
            }
        });

        btViewDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomShared.setAdsID(InformasiSatuActivity.this,"inform",code);
                startActivity(FirebaseDBReadActivity.getActIntent(InformasiSatuActivity.this));
            }
        });

        btLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(PlacePickerActivity.getActIntent(InformasiSatuActivity.this));
            }
        });
    }
}

