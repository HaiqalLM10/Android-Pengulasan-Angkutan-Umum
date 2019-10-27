package com.example.haiqa.pengulasanfb;


import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterKumpulanRecyclerView extends RecyclerView.Adapter<AdapterKumpulanRecyclerView.ViewHolder> {

    private ArrayList<Kumpulan> daftarKumpulan;
    private Context context;

    public AdapterKumpulanRecyclerView(ArrayList<Kumpulan> kumpulans, Context ctx){

        daftarKumpulan = kumpulans;
        context = ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        CardView cvMain;

        ViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tv_namakumpulan);
            cvMain = (CardView) view.findViewById(R.id.cv_main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kumpulan, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String name = daftarKumpulan.get(position).getUlasan();
        System.out.println("KUMPULAN DATA one by one "+position+daftarKumpulan.size());
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(FirebaseDBReadSingleActivity.getActIntent((Activity) context).putExtra("data", daftarKumpulan.get(position)));
            }
        });
        holder.cvMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
        holder.tvTitle.setText(name);
    }

    @Override
    public int getItemCount() {
        return daftarKumpulan.size();
    }
}
