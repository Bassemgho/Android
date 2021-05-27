package com.example.login.models;

import com.google.gson.annotations.SerializedName;

public class Bonparam {
    @SerializedName("pts")
    int pts;
    @SerializedName("delai")
    int delai;
    @SerializedName("valeurbon")
    int valeurboon;

    public Bonparam(int pts, int delai, int valeurboon) {
        this.pts = pts;
        this.delai = delai;
        this.valeurboon = valeurboon;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public int getValeurboon() {
        return valeurboon;
    }

    public void setValeurboon(int valeurboon) {
        this.valeurboon = valeurboon;
    }
}
