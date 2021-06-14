package com.example.login.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GetRep {
    @SerializedName("success")
    Boolean success;
    @SerializedName("data")
    ArrayList<Bon> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<Bon> getData() {
        return data;
    }

    public void setData(ArrayList<Bon> data) {
        this.data = data;
    }
}
