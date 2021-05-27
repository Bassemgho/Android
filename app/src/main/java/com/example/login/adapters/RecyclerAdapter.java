package com.example.login.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.login.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecHolder> {
    List<String> entreprises;
    List<String> soldes;
    Context context;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<String> entreprises,List<String> soldes){
        this.entreprises = entreprises;
        this.soldes = soldes;notifyDataSetChanged();
    }

    public List<String> getSoldes() {
        return soldes;
    }

    public void setSoldes(List<String> soldes) {
        this.soldes = soldes;
//        notifyDataSetChanged();
    }

    public List<String> getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(List<String> entreprises) {
        this.entreprises = entreprises;
//        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        RecHolder holder = new RecHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecHolder holder, int position) {
    holder.entnom.setText(entreprises.get(position));
    holder.solde.setText(soldes.get(position));
    holder.parent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(context,"going to activity" + entreprises.get(position),Toast.LENGTH_LONG).show();

        }
    });

    }

    @Override
    public int getItemCount() {
        return entreprises.size();
    }

    public class RecHolder extends RecyclerView.ViewHolder {
        TextView entnom,solde;
        RelativeLayout parent;
        public RecHolder(@NonNull View itemView) {
            super(itemView);
            entnom = (TextView) itemView.findViewById(R.id.entreprise);
            solde = (TextView) itemView.findViewById(R.id.solde);
            parent = (RelativeLayout) itemView.findViewById(R.id.parentlay);
        }
    }
}
