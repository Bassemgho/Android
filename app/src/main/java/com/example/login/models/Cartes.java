package com.example.login.models;

import com.google.gson.annotations.SerializedName;

public class Cartes {
    @SerializedName("id_entreprise")
    private Entreprise entreprise;
    @SerializedName("solde")
    private String solde;

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }
}
