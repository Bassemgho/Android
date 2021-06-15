package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.login.ViewModels.MainActivityViewModelC;
import com.example.login.ViewModels.ScanViewModel;
import com.example.login.adapters.BonAdapter;
import com.example.login.fragments.AffichageFragment;
import com.example.login.models.Bon;

import java.util.ArrayList;


public class scanclient extends AppCompatActivity {
    Button scanbtn;
    Button butt;
    Button skip,payer;
    public static EditText scantext;
    TextView somme;
    EditText prix ,quantiteproduit,idproduit;
    ScanViewModel viewModel;
    FrameLayout container;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    RecyclerView recyclerView;
    MainActivityViewModelC viewModel2 ;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanclient);
        initTextViews();
        container = (FrameLayout) findViewById(R.id.contain);
        scantext=(EditText) findViewById(R.id.scantext);
        scanbtn=(Button)findViewById(R.id.scanbtn);
        skip=(Button)findViewById(R.id.skip);
        payer=(Button)findViewById(R.id.payer);
        recyclerView = (RecyclerView) findViewById(R.id.recy);
        viewModel2 = new  ViewModelProvider(this).get(MainActivityViewModelC.class);

//        String tk = getSharedPreferences("com.example.login", Context.MODE_PRIVATE).getString("token","");
        String tk = getIntent().getStringExtra("token");
        BonAdapter adapter = new BonAdapter(getApplicationContext(),tk);

        SharedPreferences preferences = getSharedPreferences("com.example.login", Context.MODE_PRIVATE);
        preferences.edit().putString("token",getIntent().getStringExtra("token")).apply();

        viewModel = new ViewModelProvider(this).get(ScanViewModel.class);
        viewModel.setToken(tk);
//        fragmentManager = getSupportFragmentManager();
//        transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.contain,new AffichageFragment()).commit();
        viewModel.getData().observe(this, new Observer<ArrayList<Bon>>() {
            @Override
            public void onChanged(ArrayList<Bon> bons) {
                adapter.setBons(bons);
                recyclerView.setLayoutManager(new LinearLayoutManager(scanclient.this));
                recyclerView.setAdapter(adapter);
                Toast.makeText(getApplicationContext(),"hellllo",Toast.LENGTH_LONG).show();
            }
        });

        viewModel.getSuccess().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    Toast.makeText(scanclient.this,"operation sucessfull",Toast.LENGTH_LONG).show();
                    prix.setText("");
                    quantiteproduit.setText("");
                    idproduit.setText("");
                    scantext.setText("");
                }

            }
        });
        viewModel.getRep().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(scanclient.this,s,Toast.LENGTH_LONG).show();

            }
        });




        scantext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                viewModel.getbons(tk,charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), scanView.class));

            }

        });
        payer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setMontant(somme.getText().toString());
                viewModel.setId_client(scantext.getText().toString());
                try {
                    viewModel.postmontant(tk);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(scanclient.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void initTextViews()
    {
        somme=(TextView)findViewById(R.id.somme);
        prix =(EditText) findViewById(R.id.prix);
        quantiteproduit=(EditText)findViewById(R.id.quantiteproduit);
        idproduit=(EditText)findViewById(R.id.idproduit);

    }

    public void add(View view){

        double e= Double.parseDouble(quantiteproduit.getText().toString());
        double z = Double.parseDouble(somme.getText().toString())+(Double.parseDouble(prix.getText().toString())*e);
        somme.setText(String.valueOf(z));
        prix.setText("");
        quantiteproduit.setText("");
        idproduit.setText("");


    }
    public void sousOnClick(View view){

        double e= Double.parseDouble(quantiteproduit.getText().toString());
        double z = Double.parseDouble(somme.getText().toString())-(Double.parseDouble(prix.getText().toString())*e);
        somme.setText(String.valueOf(z));
        prix.setText("");
        quantiteproduit.setText("");
        idproduit.setText("");



    }

    public void ClearOnClick(View view){
        somme.setText("0.0");
        prix.setText("");
        quantiteproduit.setText("");
        idproduit.setText("");


    }
}