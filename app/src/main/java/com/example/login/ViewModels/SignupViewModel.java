package com.example.login.ViewModels;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.login.api.ApiClient;
import com.example.login.models.LoginResponse;
import com.example.login.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupViewModel extends AndroidViewModel {
    String username,password,email,phonenumber;
    MutableLiveData<Boolean> success;
    ApiClient client;

    public MutableLiveData<Boolean> getSuccess() {
        if (success==null){
            this.success = new MutableLiveData<>();
        }
        return success;
    }

    public void setSuccess(MutableLiveData<Boolean> success) {
        this.success = success;
    }

    public ApiClient getClient() {
        if (client==null){
            client = new ApiClient();
        }
        return client;
    }

    public void setClient(ApiClient client) {
        this.client = client;
    }

    public SignupViewModel(@NonNull Application application) {
        super(application);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public void signup(){
        User user = new User(username,password,email,phonenumber);
        getClient().getApi().signUp(user).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response !=null && response.isSuccessful() && response.body()!=null){

                    getSuccess().setValue(true);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getApplication(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
