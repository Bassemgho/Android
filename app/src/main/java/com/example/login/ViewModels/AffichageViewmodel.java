package com.example.login.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.login.models.Bon;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AffichageViewmodel extends AndroidViewModel {
    MutableLiveData<ArrayList<Bon>> bon;
    public AffichageViewmodel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<ArrayList<Bon>> getBon() {
        return bon;
    }

    public void setBon(MutableLiveData<ArrayList<Bon>> bon) {
        this.bon = bon;
    }

}
