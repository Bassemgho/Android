package com.example.login.models;

import com.google.gson.annotations.SerializedName;

public class Entreprise {
    @SerializedName("name")
    String name;
    @SerializedName("logo")
    String logo;

    public Entreprise(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
