package com.example.login.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Shop {
    @SerializedName("bonparams")
    ArrayList<Bonparam> bonparams;
    @SerializedName("reductionparams")
    ArrayList<Redparams> redparams;
    @SerializedName("id_entreprise")
    Entreprise entreprise;

    public Shop(ArrayList<Bonparam> bonparams, ArrayList<Redparams> redparams, Entreprise entreprise) {
        this.bonparams = bonparams;
        this.redparams = redparams;
        this.entreprise = entreprise;
    }

    public ArrayList<Bonparam> getBonparams() {
        return bonparams;
    }

    public void setBonparams(ArrayList<Bonparam> bonparams) {
        this.bonparams = bonparams;
    }

    public ArrayList<Redparams> getRedparams() {
        return redparams;
    }

    public void setRedparams(ArrayList<Redparams> redparams) {
        this.redparams = redparams;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
