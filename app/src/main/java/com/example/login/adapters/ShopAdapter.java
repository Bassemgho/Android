package com.example.login.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.R;
import com.example.login.models.Shop;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.shopHolder> {
    Context context;
    String token;
    ArrayList<Shop> shops = new ArrayList<>();

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    public ShopAdapter(Context context, String tk) {
    this.context = context;
    this.token = tk;
    }



    public ArrayList<Shop> getShops() {
        return shops;
    }

    public void setShops(ArrayList<Shop> shops) {
        this.shops = shops;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public shopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parentitem,parent,false);
        shopHolder holder = new shopHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull shopHolder holder, int position) {
        Shop shop = shops.get(position);
        holder.t1.setText(shop.getEntreprise().getName());
        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.childRecycler.getContext(),LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setInitialPrefetchItemCount(shop.getBonparams().size());
        ChildAdapter adapter = new ChildAdapter(context,token);
        if (shop.getBonparams().isEmpty()){
            ArrayList<String> list  = new ArrayList<>();
            list.add("null");
            list.add("null");
            list.add("null");
            adapter.setStrings(list);
        }else {

            adapter.setBonparams(shop.getBonparams());
        }
//        adapter.setNuls();
        holder.childRecycler.setAdapter(adapter);
        holder.childRecycler.setLayoutManager(layoutManager);
        holder.childRecycler.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return shops.size();
    }

    public class shopHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3;
        RecyclerView childRecycler;
        public shopHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.Entreprisenom);
            t2 = itemView.findViewById(R.id.textView6);
            t3 = itemView.findViewById(R.id.ptss);
            childRecycler = itemView.findViewById(R.id.childRecycler);
        }
    }
}
