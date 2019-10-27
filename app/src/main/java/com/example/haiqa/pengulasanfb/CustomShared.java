package com.example.haiqa.pengulasanfb;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Team 2 on 5/29/2018.
 */

public class CustomShared {
    public static void setAdsID(Activity activity, String key, String value){
        SharedPreferences settings = activity.getApplicationContext().getSharedPreferences("Adobe", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getAdsID(Activity activity, String key){
        SharedPreferences settings2 = activity.getApplicationContext().getSharedPreferences("Adobe", 0);
        String AdsId = settings2.getString(key, "");
        return AdsId;
    }
}
