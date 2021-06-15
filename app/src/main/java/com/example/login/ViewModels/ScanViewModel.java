package com.example.login.ViewModels;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.login.api.ApiClient;
import com.example.login.models.AchatBonReponse;
import com.example.login.models.AchatCall;
import com.example.login.models.AchatResponse;
import com.example.login.models.Bon;
import com.example.login.models.GetRep;
import com.example.login.models.Id;
import com.example.login.models.Id2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScanViewModel extends AndroidViewModel {
    String montant;
    MutableLiveData<Boolean> success;
    MutableLiveData<String> rep;
    ApiClient client;
    String id;
    MutableLiveData<ArrayList<Bon>> data;
    String id_client;
    String token;

    public MutableLiveData<ArrayList<Bon>> getData() {
        if (data == null){
            data = new MutableLiveData<>();
        }
        return data;
    }

    public void setData(MutableLiveData<ArrayList<Bon>> data) {
        this.data = data;
    }

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
    public void getbons(String tk,String id){

        getClient().getApi().getbons("Bearer "+tk,id).enqueue(new Callback<GetRep>() {
            @Override
            public void onResponse(Call<GetRep> call, Response<GetRep> response) {
                if (response !=null && response.isSuccessful() && response.body()!=null){
                    getData();
                    Toast.makeText(getApplication(),"yeeeeeeees",Toast.LENGTH_LONG).show();
                    data.setValue(response.body().getData());
                }
                else {
                    Toast.makeText(getApplication(),"nooooooo",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GetRep> call, Throwable t) {
                Toast.makeText(getApplication(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
