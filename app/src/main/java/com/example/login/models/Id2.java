package com.example.login.models;

import com.google.gson.annotations.SerializedName;

public class Id2 {
    @SerializedName("id_client")
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
