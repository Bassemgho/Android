package com.example.login.ViewModels;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.login.api.ApiClient;
import com.example.login.models.Cartes;
import com.example.login.models.Entreprise;
import com.example.login.models.HomeResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends AndroidViewModel {
    ApiClient client;

    List<Entreprise> list1 = new ArrayList<com.example.login.models.Entreprise>();
    List<String> list2 = new ArrayList<>();
    MutableLiveData<String> token = new MutableLiveData<>();
    MutableLiveData<HomeResponse> homeresponse = new MutableLiveData<>();
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }
    public ApiClient getClient() {
        if (client==null){
            client = new ApiClient();
        }
        return client;
    }

    public MutableLiveData<String> getToken() {
        if (token==null){
            this.token = new MutableLiveData<>();
        }
        return token;
    }

    public void setToken(MutableLiveData<String> token) {
        this.token = token;
    }

    public MutableLiveData<HomeResponse> getHomeresponse() {
        return homeresponse;
    }

    public void setHomeresponse(MutableLiveData<HomeResponse> homeresponse) {
        this.homeresponse = homeresponse;
    }

    public List<Entreprise> getList1() {
        return list1;
    }

    public void setList1(List<Entreprise> list1) {
        this.list1 = list1;
    }

    public List<String> getList2() {
        return list2;
    }

    public void setList2(List<String> list2) {
        this.list2 = list2;
    }

    public void fetshData(){
        getClient().getApi().fetshdata("Bearer "+token.getValue()).enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response!=null && response.isSuccessful() &&response.body()!=null){
                Log.d("startin responsse","zzzzzzzzzzzz");
                Toast.makeText(getApplication(),"reached ciewmodel",Toast.LENGTH_SHORT).show();
                for (Cartes item:response.body().getUser().get(0).getCartes()
                ) {
                    list1.add(item.getEntreprise());
                    list2.add(item.getSolde());
                }
                homeresponse.setValue(response.body());



            }
            }

            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                Toast.makeText(getApplication(),"didnt wirk"+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
