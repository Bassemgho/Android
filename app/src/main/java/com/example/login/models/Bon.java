package com.example.login.models;

import com.google.gson.annotations.SerializedName;

public class Bon {
    @SerializedName("_id")
    String id;
    @SerializedName("id_entreprise")
    Entreprise id_entreprise;
    @SerializedName("valeurbon")
    int valeur;

    public Entreprise getId_entreprise() {
        return id_entreprise;
    }

    public void setId_entreprise(Entreprise id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
