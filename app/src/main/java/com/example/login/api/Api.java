package com.example.login.api;

import com.example.login.models.AchatCall;
import com.example.login.models.AchatResponse;
import com.example.login.models.HomeResponse;
import com.example.login.models.LoginCall;
import com.example.login.models.LoginResponse;
import com.example.login.models.ShopResponse;
import com.example.login.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {
    //    @FormUrlEncoded
    @POST("/app/signin")
    Call<LoginResponse> signIn(@Body LoginCall loginCall);
    @POST("/app/signincaissier")
    Call<LoginResponse> signInC(@Body LoginCall loginCall);
    //    @FormUrlEncoded
    @POST("/app/signup/")
    Call<LoginResponse> signUp(@Body User user);

    @GET("/app/cards")
    Call<HomeResponse> fetshdata(@Header("Authorization") String token);
    @GET("/app/shop/get")
    Call<ShopResponse> fetshshops(@Header("Authorization") String token);
//    @FormUrlEncoded
    @POST("/app/addachat")
    Call<AchatResponse> postmontant(@Header("Authorization") String token, @Body AchatCall achatCall);


}
