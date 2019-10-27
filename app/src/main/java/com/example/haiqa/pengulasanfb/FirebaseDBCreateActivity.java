package com.example.haiqa.pengulasanfb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FirebaseDBCreateActivity extends AppCompatActivity {

    // variable yang merefers ke Firebase Realtime Database
    private DatabaseReference database;

    // variable fields EditText dan Button
    private Button btSubmit;
    private EditText etNama;
    private EditText etUmur;
    private EditText etUlasan;

    private android.widget.RatingBar mRatingBar;

    String review;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Create Ulasan");
        setContentView(R.layout.activity_db_create);

        mRatingBar = (android.widget.RatingBar) findViewById(R.id.ratingBar);

        mRatingBar.setOnRatingBarChangeListener(new android.widget.RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(android.widget.RatingBar ratingBar, float v, boolean b) {
                review  = String.valueOf(v);
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        review = "1";
                        break;
                    case 2:
                        review = "2";
                        break;
                    case 3:
                        review = "3";
                        break;
                    case 4:
                        review = "4";
                        break;
                    case 5:
                        review = "5";
                        break;
                    default:
                        review = "";
                }
            }
        });


        // inisialisasi fields EditText dan Button
        etNama = (EditText) findViewById(R.id.et_namapenumpang);
        etUmur = (EditText) findViewById(R.id.et_umurpenumpang);
        etUlasan = (EditText) findViewById(R.id.et_ulasanpenumpang);
        btSubmit = (Button) findViewById(R.id.bt_submit);

        // mengambil referensi ke Firebase Database
        database = FirebaseDatabase.getInstance().getReference();

        final Kumpulan kumpulan = (Kumpulan) getIntent().getSerializableExtra("data");

        if (kumpulan != null) {
            etNama.setText(kumpulan.getNama());
            etUmur.setText(kumpulan.getUmur());
            etUlasan.setText(kumpulan.getUlasan());

            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    kumpulan.setNama(etNama.getText().toString());
                    kumpulan.setUmur(etUmur.getText().toString());
                    kumpulan.setUlasan(etUlasan.getText().toString());
                    //kumpulan.setKey(review);

                    updateKumpulan(kumpulan);
                }
            });
        } else {
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!isEmpty(etNama.getText().toString()) && !isEmpty(etUmur.getText().toString()) && !isEmpty(etUlasan.getText().toString())) {
                        String result = CustomShared.getAdsID(FirebaseDBCreateActivity.this,"inform").toString();
                        if(result.equalsIgnoreCase("B1214FD")){
                            submitKumpulan(new Kumpulan(etNama.getText().toString(), etUmur.getText().toString(), etUlasan.getText().toString(), review.toString()));
                            Intent m = new Intent(FirebaseDBCreateActivity.this,InformasiSatuActivity.class);
                            startActivity(m);
                        }else if(result.equalsIgnoreCase("B2138PG")){
                            submitKumpulan2(new Kumpulan(etNama.getText().toString(), etUmur.getText().toString(), etUlasan.getText().toString(), review.toString()));
                            Intent m = new Intent(FirebaseDBCreateActivity.this,InformasiDuaActivity.class);
                            startActivity(m);
                        }else if(result.equalsIgnoreCase("B3621QO")){
                            submitKumpulan3(new Kumpulan(etNama.getText().toString(), etUmur.getText().toString(), etUlasan.getText().toString(), review.toString()));
                            Intent m = new Intent(FirebaseDBCreateActivity.this,InformasiTigaActivity.class);
                            startActivity(m);
                        }else{
                            Toast.makeText(getApplicationContext(),"ada yang salah ini barcodenya",Toast.LENGTH_LONG).show();
                        }

                    }else {
                        Snackbar.make(findViewById(R.id.bt_submit), "Data ulasan tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                        InputMethodManager imm = (InputMethodManager)
                                getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(
                                etNama.getWindowToken(), 0);
                    }
                }
            });
        }
    }

    private boolean isEmpty(String s){
        // Cek apakah ada fields yang kosong, sebelum disubmit
        return TextUtils.isEmpty(s);
    }

    private void updateKumpulan(Kumpulan kumpulan) {

    }

    private void submitKumpulan(Kumpulan kumpulan) {
        database.child("kumpulan").push().setValue(kumpulan).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNama.setText("");
                etUmur.setText("");
                etUlasan.setText("");
                Snackbar.make(findViewById(R.id.bt_submit), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void submitKumpulan2(Kumpulan kumpulan) {
        database.child("kumpulan2").push().setValue(kumpulan).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNama.setText("");
                etUmur.setText("");
                etUlasan.setText("");
                Snackbar.make(findViewById(R.id.bt_submit), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void submitKumpulan3(Kumpulan kumpulan) {
        database.child("kumpulan3").push().setValue(kumpulan).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                etNama.setText("");
                etUmur.setText("");
                etUlasan.setText("");
                Snackbar.make(findViewById(R.id.bt_submit), "Data berhasil ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, FirebaseDBCreateActivity.class);
    }
}

