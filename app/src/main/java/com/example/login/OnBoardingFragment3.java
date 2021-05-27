package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OnBoardingFragment3 extends Fragment {

    FloatingActionButton fab;
    FloatingActionButton sc;
    FloatingActionButton geo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root =(ViewGroup) inflater.inflate(R.layout.fragment_on_boarding3,container,false);

        fab= root.findViewById(R.id.fab);
        sc= root.findViewById(R.id.sc);
        geo=root.findViewById(R.id.geo);



        fab.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);


            }
        });

        sc.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),scanclient.class);
                startActivity(intent);


            }
        });
        geo.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),MapsActivity.class);
                startActivity(intent);


            }
        });

        return root;
    }
}