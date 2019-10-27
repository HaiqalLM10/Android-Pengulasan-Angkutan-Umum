package com.example.haiqa.pengulasanfb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirebaseDBReadSingleActivity extends AppCompatActivity {

    private Button btSubmit;
    private EditText etNama;
    private EditText etUmur;
    private EditText etUlasan;
    private TextView tvRat;

    String review;

    private android.widget.RatingBar mRatingBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Detail Ulasan");
        setContentView(R.layout.activity_db_create);
        etNama = (EditText) findViewById(R.id.et_namapenumpang);
        etUmur = (EditText) findViewById(R.id.et_umurpenumpang);
        etUlasan = (EditText) findViewById(R.id.et_ulasanpenumpang);
        btSubmit = (Button) findViewById(R.id.bt_submit);
        mRatingBar = (android.widget.RatingBar) findViewById(R.id.ratingBar);
        tvRat = (TextView) findViewById(R.id.tv_rating);

        etNama.setEnabled(false);
        etUmur.setEnabled(false);
        etUlasan.setEnabled(false);
        btSubmit.setVisibility(View.GONE);
        mRatingBar.setEnabled(false);
        tvRat.setVisibility(View.GONE);

        Kumpulan kumpulan = (Kumpulan) getIntent().getSerializableExtra("data");
        if(kumpulan!=null){
            etNama.setText(kumpulan.getNama());
            etUmur.setText(kumpulan.getUmur());
            etUlasan.setText(kumpulan.getUlasan());
            review = kumpulan.getRating();
            float rating = Float.parseFloat(review);
            mRatingBar.setRating(rating);

        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FirebaseDBReadSingleActivity.class);
    }
}
