package com.example.haiqa.pengulasanfb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FirebaseDBReadActivity extends AppCompatActivity {

    /**
     * Mendefinisikan variable yang akan dipakai
     */
    private DatabaseReference database;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Kumpulan> daftarKumpulan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Lihat Ulasan");
        /**
         * Mengeset layout
         */
        setContentView(R.layout.activity_db_read);

        /**
         * Inisialisasi RecyclerView & komponennya
         */
        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        /**
         * Inisialisasi dan mengambil Firebase Database Reference
         */
        database = FirebaseDatabase.getInstance().getReference();

        String result = CustomShared.getAdsID(FirebaseDBReadActivity.this,"inform").toString();
        if(result.equalsIgnoreCase("B1214FD")){
            database.child("kumpulan").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    /**
                     * Saat ada data baru, masukkan datanya ke ArrayList
                     */
                    daftarKumpulan = new ArrayList<>();
                    for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                        /**
                         * Mapping data pada DataSnapshot ke dalam object Barang
                         * Dan juga menyimpan primary key pada object Barang
                         * untuk keperluan Edit dan Delete data
                         */
                        Kumpulan kumpulan = noteDataSnapshot.getValue(Kumpulan.class);
                        kumpulan.setKey(noteDataSnapshot.getKey());

                        /**
                         * Menambahkan object Barang yang sudah dimapping
                         * ke dalam ArrayList
                         */
                        daftarKumpulan.add(kumpulan);
                    }

                    /**
                     * Inisialisasi adapter dan data barang dalam bentuk ArrayList
                     * dan mengeset Adapter ke dalam RecyclerView
                     */
                    adapter = new AdapterKumpulanRecyclerView(daftarKumpulan, FirebaseDBReadActivity.this);
                    rvView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    /**
                     * Kode ini akan dipanggil ketika ada error dan
                     * pengambilan data gagal dan memprint error nya
                     * ke LogCat
                     */
                    System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
                }
            });
        }else if(result.equalsIgnoreCase("B2138PG")){
            database.child("kumpulan2").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    /**
                     * Saat ada data baru, masukkan datanya ke ArrayList
                     */
                    daftarKumpulan = new ArrayList<>();
                    for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                        /**
                         * Mapping data pada DataSnapshot ke dalam object Barang
                         * Dan juga menyimpan primary key pada object Barang
                         * untuk keperluan Edit dan Delete data
                         */
                        Kumpulan kumpulan = noteDataSnapshot.getValue(Kumpulan.class);
                        kumpulan.setKey(noteDataSnapshot.getKey());

                        /**
                         * Menambahkan object Barang yang sudah dimapping
                         * ke dalam ArrayList
                         */
                        daftarKumpulan.add(kumpulan);
                    }

                    /**
                     * Inisialisasi adapter dan data barang dalam bentuk ArrayList
                     * dan mengeset Adapter ke dalam RecyclerView
                     */
                    adapter = new AdapterKumpulanRecyclerView(daftarKumpulan, FirebaseDBReadActivity.this);
                    rvView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    /**
                     * Kode ini akan dipanggil ketika ada error dan
                     * pengambilan data gagal dan memprint error nya
                     * ke LogCat
                     */
                    System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
                }
            });
        }else if(result.equalsIgnoreCase("B3621QO")){
            database.child("kumpulan3").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    /**
                     * Saat ada data baru, masukkan datanya ke ArrayList
                     */
                    daftarKumpulan = new ArrayList<>();
                    for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                        /**
                         * Mapping data pada DataSnapshot ke dalam object Barang
                         * Dan juga menyimpan primary key pada object Barang
                         * untuk keperluan Edit dan Delete data
                         */
                        Kumpulan kumpulan = noteDataSnapshot.getValue(Kumpulan.class);
                        kumpulan.setKey(noteDataSnapshot.getKey());

                        /**
                         * Menambahkan object Barang yang sudah dimapping
                         * ke dalam ArrayList
                         */
                        daftarKumpulan.add(kumpulan);
                    }

                    /**
                     * Inisialisasi adapter dan data barang dalam bentuk ArrayList
                     * dan mengeset Adapter ke dalam RecyclerView
                     */
                    adapter = new AdapterKumpulanRecyclerView(daftarKumpulan, FirebaseDBReadActivity.this);
                    rvView.setAdapter(adapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    /**
                     * Kode ini akan dipanggil ketika ada error dan
                     * pengambilan data gagal dan memprint error nya
                     * ke LogCat
                     */
                    System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
                }
            });
        }

        /**
         * Mengambil data barang dari Firebase Realtime DB
         */

    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FirebaseDBReadActivity.class);
    }
}
