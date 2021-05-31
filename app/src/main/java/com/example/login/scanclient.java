package com.example.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.login.ViewModels.ScanViewModel;


public class scanclient extends AppCompatActivity {
    Button scanbtn;
    Button skip,payer;
    public static EditText scantext;
    TextView somme;
    EditText prix ,quantiteproduit,idproduit;
    ScanViewModel viewModel;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanclient);
        initTextViews();

        scantext=(EditText) findViewById(R.id.scantext);
        scanbtn=(Button)findViewById(R.id.scanbtn);
        skip=(Button)findViewById(R.id.skip);
        payer=(Button)findViewById(R.id.payer);
//        String tk = getSharedPreferences("com.example.login", Context.MODE_PRIVATE).getString("token","");
        String tk = getIntent().getStringExtra("token");
        viewModel = new ViewModelProvider(this).get(ScanViewModel.class);
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