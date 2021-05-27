package com.example.login.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.ViewModels.ShopViewModel;
import com.example.login.adapters.ShopAdapter;
import com.example.login.databinding.FragmentShopBinding;
import com.example.login.models.Shop;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopFragment extends Fragment {
    FragmentShopBinding binding;
    ShopAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ShopViewModel viewModel;


    public ShopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopFragment newInstance(String param1, String param2) {
        ShopFragment fragment = new ShopFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_shop, container, false);
        binding = FragmentShopBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        adapter = new ShopAdapter(getContext());



        viewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        String tk = getActivity().getSharedPreferences("com.example.login", Context.MODE_PRIVATE).getString("token","");
        viewModel.fetshdata("Bearer "+tk);
        viewModel.getSuccess().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    Toast.makeText(getContext(),"wooooorks",Toast.LENGTH_LONG).show();

                }
            }

        });
        viewModel.getShops().observe(getViewLifecycleOwner(), new Observer<ArrayList<Shop>>() {
            @Override
            public void onChanged(ArrayList<Shop> shops) {
                if (!shops.isEmpty()){
                    adapter.setShops(shops);
                }else {
                    Toast.makeText(getContext(),"array is embrto",Toast.LENGTH_LONG).show();
                }
            }
        });
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        return view ;
    }
}