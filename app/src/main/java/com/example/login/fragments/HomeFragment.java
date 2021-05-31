package com.example.login.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.login.R;
import com.example.login.ViewModels.HomeViewModel;
import com.example.login.adapters.RecyclerAdapter;
import com.example.login.databinding.FragmentBlankBinding;
import com.example.login.models.HomeResponse;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    FragmentBlankBinding binding;
    HomeViewModel viewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View root = inflater.inflate(R.layout.fragment_blank, container, false);
        binding = FragmentBlankBinding.inflate(inflater,container,false);

        View view = binding.getRoot();
        String token = getActivity().getSharedPreferences("com.example.login", Context.MODE_PRIVATE).getString("token","");
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        RecyclerAdapter adapter = new RecyclerAdapter(getContext());

        viewModel.getToken().setValue(token);
        viewModel.getToken().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (!(s==null) && !TextUtils.isEmpty(s)){
                    Toast.makeText(getContext(),"fetshing data",Toast.LENGTH_SHORT).show();
                    viewModel.fetshData();
                }

            }
        });
        viewModel.getHomeresponse().observe(getViewLifecycleOwner(), new Observer<HomeResponse>() {
            @Override
            public void onChanged(HomeResponse homeResponse) {
                if (!(homeResponse==null)){

                    adapter.setData(viewModel.getList1(),viewModel.getList2());
                    binding.myrec.setAdapter(adapter);
                    binding.myrec.setLayoutManager(new LinearLayoutManager(getContext()));

                }

            }
        });

        return view;
    }
}