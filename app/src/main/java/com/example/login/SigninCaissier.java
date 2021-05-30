package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.login.ViewModels.MainActivityViewModelC;
import com.example.login.activities.HomeActivity;
import com.example.login.databinding.FragmentShopBinding;
import com.example.login.databinding.FragmentSigninCaissierBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SigninCaissier#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SigninCaissier extends Fragment {

    public MainActivityViewModelC viewModel ;
    EditText email,pass;
    Button button;
    FragmentSigninCaissierBinding binding;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SigninCaissier() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SigninCaissier.
     */
    // TODO: Rename and change types and number of parameters
    public static SigninCaissier newInstance(String param1, String param2) {
        SigninCaissier fragment = new SigninCaissier();
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
        View root= inflater.inflate(R.layout.fragment_signin_caissier, container, false);
        // Inflate the layout for this fragment
        binding = FragmentSigninCaissierBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModelC.class);
        viewModel.getRep();
        viewModel.getSuccess().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    Toast.makeText(getContext(),"you got rep"+viewModel.getRep().getValue(),Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(), scanclient.class);
                    intent.putExtra("token",viewModel.getRep().getValue());
                    startActivity(intent);
                    return;


                }

                Toast.makeText(getContext(),"noooo",Toast.LENGTH_SHORT).show();


            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.Email.getText().toString();
                String password = binding.Pass.getText().toString();
                viewModel.setPassword(password);
                viewModel.setUsername(username);
                try {

                    viewModel.login();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

        return view;
    }
}