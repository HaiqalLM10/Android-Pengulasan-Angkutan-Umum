package com.example.haiqa.pengulasanfb;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class PlacePickerActivity extends AppCompatActivity {

    int PLACE_PICKER_REQUEST = 1;
    TextView tvPlace;
    TextView tvName;
    TextView tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Alamat Map");
        setContentView(R.layout.activity_place_picker);
        tvPlace = (TextView)findViewById(R.id.tvPlace);
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
    }

    public void goPlacePicker (View view){
        //this is place to call the place picker function

        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try{

            startActivityForResult(builder.build(PlacePickerActivity.this),PLACE_PICKER_REQUEST);

        }catch (GooglePlayServicesRepairableException e){
            e.printStackTrace();
        }catch (GooglePlayServicesNotAvailableException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        if(requestCode == PLACE_PICKER_REQUEST){
            if(resultCode == RESULT_OK){

                Place place = PlacePicker.getPlace(PlacePickerActivity.this, data);
                tvName.setText(place.getName());
                tvPlace.setText(place.getAddress());
                tvPhone.setText(place.getPhoneNumber());
            }
        }
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, PlacePickerActivity.class);
    }
}
