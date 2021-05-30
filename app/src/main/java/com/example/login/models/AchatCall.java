package com.example.login.models;

import com.google.gson.annotations.SerializedName;

public class AchatCall {
    @SerializedName("id_client")
    String id_client;
    @SerializedName("montant")
    String montant;

    public String getId_client() {
        return id_client;
    }

    public void setId_client(String id_client) {
        this.id_client = id_client;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }
}
