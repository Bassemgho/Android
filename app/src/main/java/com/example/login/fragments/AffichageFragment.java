package com.example.login.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.ViewModels.ScanViewModel;
import com.example.login.adapters.BonAdapter;
import com.example.login.api.ApiClient;
import com.example.login.databinding.FragmentAffichageBinding;
import com.example.login.databinding.FragmentShopBinding;
import com.example.login.models.Bon;
import com.example.login.models.GetRep;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AffichageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AffichageFragment extends Fragment {
    FragmentAffichageBinding binding;
    ArrayList<Bon> bons;
    ScanViewModel viewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AffichageFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AffichageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AffichageFragment newInstance(String param1, String param2) {
        AffichageFragment fragment = new AffichageFragment();
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
        binding = FragmentAffichageBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        viewModel = new ViewModelProvider(this).get(ScanViewModel.class);
        String tk = viewModel.getToken();
        String token = getActivity().getSharedPreferences("com.example.login", Context.MODE_PRIVATE).getString("token","");
        BonAdapter adapter = new BonAdapter(getContext(),token);
//        new ApiClient().getApi().getbons(tk).enqueue(new Callback<GetRep>() {
//            @Override
//            public void onResponse(Call<GetRep> call, Response<GetRep> response) {
//                if (response!=null && response.isSuccessful() &&response.body()!=null){
//                    adapter.setBons(response.body().getData());
//
//
//                    Toast.makeText(getContext(),"response",Toast.LENGTH_LONG).show();
//
//                }
//                else {
//                    Toast.makeText(getContext(),"else",Toast.LENGTH_LONG).show();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<GetRep> call, Throwable t) {
//
//            }
//        });
//        binding.rec.setAdapter(adapter);



//        binding.rec.setLayoutManager(new LinearLayoutManager(getContext()));
        return view ;

    }
}