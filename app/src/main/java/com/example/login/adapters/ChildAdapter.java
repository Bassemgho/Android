package com.example.login.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.api.ApiClient;
import com.example.login.models.AchatBonReponse;
import com.example.login.models.Bonparam;
import com.example.login.models.Id;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildHolder> {
    ApiClient client = new ApiClient();;
    ArrayList<Bonparam> bonparams;
    ArrayList<String> strings;
    Context context;
    String token;

    public ChildAdapter(Context context, String token) {
        this.context = context;
        this.token = token;
    }



    public ArrayList<String> getStrings() {
        return strings;
    }

    public void setStrings(ArrayList<String> strings) {
        this.strings = strings;
        notifyDataSetChanged();
    }

    public List<Bonparam> getBonparams() {
        return bonparams;
    }

    public void setBonparams(ArrayList<Bonparam> bonparams) {
        this.bonparams = bonparams;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChildHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.childitem,parent,false);
        ChildHolder holder = new ChildHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildHolder holder, int position) {
        if (bonparams!=null&&!bonparams.isEmpty()){
            holder.t2.setText(String.valueOf(bonparams.get(position).getValeurboon()));
        }
        else {
            holder.t2.setText("hello");
        }
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Id id = new Id();
                id.setId(bonparams.get(position).getId());
                client.getApi().addbon("Bearer "+token,id).enqueue(new Callback<AchatBonReponse>() {
                    @Override
                    public void onResponse(Call<AchatBonReponse> call, Response<AchatBonReponse> response) {
                        if (response!=null && response.isSuccessful() &&response.body()!=null){

                            Toast.makeText(context,"response success",Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<AchatBonReponse> call, Throwable t) {

                    }
                });
                Toast.makeText(context,"everythingworks",Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override

    public int getItemCount() {
        return bonparams.size();
    }

    public class ChildHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        Button button;
        public ChildHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            t3 = itemView.findViewById(R.id.t3);
            button = itemView.findViewById(R.id.button2);
        }
    }
}
