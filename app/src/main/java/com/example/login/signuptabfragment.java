package com.example.login;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.login.ViewModels.SignupViewModel;
import com.example.login.databinding.SignupBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signuptabfragment extends Fragment {
    SignupBinding binding;
    SignupViewModel viewModel;
    EditText username,pass,corectpass,email,phonenumber;
    Button signup;
    TextView alert,alert1;
    float v=0;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root =(ViewGroup) inflater.inflate(R.layout.signup,container,false);
        viewModel =  new ViewModelProvider(this).get(SignupViewModel.class);


        username = (EditText) root.findViewById(R.id.Email);
        pass = (EditText) root.findViewById(R.id.Pass);
        corectpass = (EditText) root.findViewById(R.id.CorrectPass);
        alert = (TextView) root.findViewById(R.id.alert);
        signup = (Button) root.findViewById(R.id.button);
        email = (EditText) root.findViewById(R.id.email);
        phonenumber = (EditText) root.findViewById(R.id.phonenumber);
        alert1 = (TextView) root.findViewById(R.id.alert1);

        username.setTranslationX(800);
        pass.setTranslationX(800);
        corectpass.setTranslationX(800);
        signup.setTranslationX(800);
        email.setTranslationX(800);
        phonenumber.setTranslationX(800);

        username.setAlpha(v);
        pass.setAlpha(v);
        corectpass.setAlpha(v);
        signup.setAlpha(v);
        String regx = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regx);

        username.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        corectpass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        signup.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Matcher matcher = pattern.matcher(charSequence);
                if (!matcher.matches()){
                    alert1.setText("this isnor an email");
                    signup.setActivated(false);
                }else {
                    alert1.setText("");

                    signup.setActivated(true);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        viewModel.getSuccess().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    Toast.makeText(getContext(),"your signup is complete please go to login page and signin",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(),"there was a problem please try again",Toast.LENGTH_LONG).show();
                }
            }
        });
        corectpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }


            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String s = charSequence.toString();
                if (!s.equals(pass.getText().toString())){
                    alert.setTextColor(Color.RED);
                    alert.setText("your password are not maching please verify");
                    signup.setActivated(false);
                }else{
                    alert.setText("");
                    signup.setActivated(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.setUsername(username.getText().toString());
                viewModel.setPassword(pass.getText().toString());
                viewModel.setEmail(email.getText().toString());
                viewModel.setPhonenumber(phonenumber.getText().toString());
                viewModel.signup();

            }
        });



        return root;
    }
//    Boolean validatepassword(){
//        if ()
//    }
}
