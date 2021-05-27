package com.example.login.ViewModels;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.login.api.ApiClient;
import com.example.login.models.Shop;
import com.example.login.models.ShopResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopViewModel extends AndroidViewModel {
    MutableLiveData<ArrayList<Shop>> shops;
    MutableLiveData<Boolean> success;
    String token;
    ApiClient client;

    public ShopViewModel(@NonNull Application application) {
        super(application);
    }
    public MutableLiveData<Boolean> getSuccess() {
        if (success==null){
            this.success = new MutableLiveData<>();
        }
        return success;
    }

    public String getToken() {

        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ApiClient getClient() {
        if (client==null){
            client = new ApiClient();
        }
        return client;
    }

    public MutableLiveData<ArrayList<Shop>> getShops() {
        if (shops==null){
            shops = new MutableLiveData<>();
        }
        return shops;
    }

    public void setShops(MutableLiveData<ArrayList<Shop>> shops) {
        this.shops = shops;
    }
    public void fetshdata(String tk){
        getClient().getApi().fetshshops(tk).enqueue(new Callback<ShopResponse>() {
            @Override
            public void onResponse(Call<ShopResponse> call, Response<ShopResponse> response) {
                if (response!=null && response.isSuccessful() &&response.body()!=null){
                    getShops().setValue(response.body().getData());
                    Toast.makeText(getApplication(),"response",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getApplication(),"else",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<ShopResponse> call, Throwable t) {
                Toast.makeText(getApplication(),"faillure",Toast.LENGTH_LONG).show();
            }
        });

    }
}
