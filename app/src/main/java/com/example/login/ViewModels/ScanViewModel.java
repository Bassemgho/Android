package com.example.login.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.login.api.ApiClient;
import com.example.login.models.AchatCall;
import com.example.login.models.AchatResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScanViewModel extends AndroidViewModel {
    String montant;
    MutableLiveData<Boolean> success;
    MutableLiveData<String> rep;
    ApiClient client;

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    String id_client;
    String token;

    public ScanViewModel(@NonNull Application application) {
        super(application);
    }
    public ApiClient getClient() {
        if (client==null){
            client = new ApiClient();
        }
        return client;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public MutableLiveData<Boolean> getSuccess() {
        if (success==null){
            this.success = new MutableLiveData<>();
        }
        return success;
    }

    public void setSuccess(MutableLiveData<Boolean> success) {
        this.success = success;
    }

    public MutableLiveData<String> getRep() {
        if (rep == null){
            this.rep = new MutableLiveData<>();
        }
        return rep;
    }

    public void setRep(MutableLiveData<String> rep) {
        this.rep = rep;
    }
    public void postmontant(String tk){
        AchatCall achatCall = new AchatCall();
        achatCall.setMontant(montant);
        achatCall.setId_client(id_client);
        getClient().getApi().postmontant("Bearer "+tk,achatCall).enqueue(new Callback<AchatResponse>() {
            @Override
            public void onResponse(Call<AchatResponse> call, Response<AchatResponse> response) {
                if (response !=null && response.isSuccessful() && response.body()!=null){
                    getRep().setValue(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<AchatResponse> call, Throwable t) {

            }
        });
    }
}
