package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class scanclient extends AppCompatActivity {
    Button scanbtn;
    Button skip,payer;
    public static EditText scantext;
    TextView somme;
    EditText prix ,quantiteproduit,idproduit;




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanclient);
        initTextViews();

        scantext=(EditText) findViewById(R.id.scantext);
        scanbtn=(Button)findViewById(R.id.scanbtn);
        skip=(Button)findViewById(R.id.skip);
        payer=(Button)findViewById(R.id.payer);



        scanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), scanView.class));

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