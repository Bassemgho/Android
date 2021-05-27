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
import com.example.login.models.Bonparam;

import java.util.ArrayList;
import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildHolder> {
    ArrayList<Bonparam> bonparams;
    ArrayList<String> strings;
    Context context;

    public ChildAdapter(Context context) {
        this.context = context;
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
