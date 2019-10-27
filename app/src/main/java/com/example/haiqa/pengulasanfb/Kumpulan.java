package com.example.haiqa.pengulasanfb;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Kumpulan implements Serializable {

    private String rating;
    private String nama;
    private String umur;
    private String ulasan;
    private String key;


    public Kumpulan(){

    }

    public String getKey(){

        return key;
    }

    public void setKey(String key){

        this.key = key;
    }

    public String getNama(){

        return nama;
    }

    public void setNama(String nama){

        this.nama = nama;
    }

    public String getUmur(){

        return umur;
    }

    public void setUmur(String umur){

        this.umur = umur;
    }

    public String getUlasan(){

        return ulasan;
    }

    public void setUlasan(String ulasan){

        this.ulasan = ulasan;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return " "+nama+"\n" +
                " "+umur+"\n" +
                " "+ulasan+"\n" +
                " "+rating;
    }

    public Kumpulan(String nm, String um, String ul, String rat){
        nama = nm;
        umur = um;
        ulasan = ul;
        rating = rat;
    }

}