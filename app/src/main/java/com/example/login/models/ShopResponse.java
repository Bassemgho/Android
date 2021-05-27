package com.example.login.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShopResponse {
    @SerializedName("success")
    @Expose
    Boolean success;
    @SerializedName("data")
    @Expose
    ArrayList<Shop> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<Shop> getData() {
        return data;
    }

    public void setData(ArrayList<Shop> shops) {
        this.data = shops;
    }
}
