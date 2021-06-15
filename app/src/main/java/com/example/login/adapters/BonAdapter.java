package com.example.login.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.api.ApiClient;
import com.example.login.models.Bon;
import com.example.login.models.Bonparam;
import com.example.login.models.GetRep;
import com.example.login.models.Id;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BonAdapter extends RecyclerView.Adapter<BonAdapter.BonHolder> {
    ApiClient client = new ApiClient();
    Context context;
    ArrayList<Bon> bons = new ArrayList<>();
    String token;

    public BonAdapter(Context context,String token) {
        this.context = context;
        this.token = token;
    }

    public ArrayList<Bon> getBons() {
        return bons;
    }

    public void setBons(ArrayList<Bon> bons) {
        this.bons = bons;
        notifyDataSetChanged();
    }

    public String getToken() {
        return token;

    }

    public void setToken(String token) {
        this.token = token;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        BonAdapter.BonHolder holder = new BonAdapter.BonHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BonHolder holder, int position) {
        holder.solde.setText(bons.get(position).getValeur());
        holder.solde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Id id = new Id();
                id.setId(bons.get(position).getId());
                client.getApi().removebons(token,id).enqueue(new Callback<GetRep>() {
                    @Override
                    public void onResponse(Call<GetRep> call, Response<GetRep> response) {
                        if (response !=null && response.isSuccessful() && response.body()!=null){
                            setBons(response.body().getData());
                            Toast.makeText(context,"removed",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<GetRep> call, Throwable t) {

                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return bons.size();
    }

    public class BonHolder extends RecyclerView.ViewHolder {
        TextView entnom,solde;
        RelativeLayout parent;
        ImageView image;
        public BonHolder(@NonNull View itemView) {
            super(itemView);
            entnom = (TextView) itemView.findViewById(R.id.entreprise);
            solde = (TextView) itemView.findViewById(R.id.solde);
            parent = (RelativeLayout) itemView.findViewById(R.id.parentlay);
            image = (ImageView) itemView.findViewById(R.id.logo);
        }
    }
}
