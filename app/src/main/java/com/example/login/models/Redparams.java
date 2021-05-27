package com.example.login.models;

import com.google.gson.annotations.SerializedName;

public class Redparams {
    @SerializedName("ptsred")
    int ptsred;
    @SerializedName("delaired")
    int delaired;
    @SerializedName("percent")
    int percent;

    public Redparams(int ptsred, int delaired, int percent) {
        this.ptsred = ptsred;
        this.delaired = delaired;
        this.percent = percent;
    }

    public int getPtsred() {
        return ptsred;
    }

    public void setPtsred(int ptsred) {
        this.ptsred = ptsred;
    }

    public int getDelaired() {
        return delaired;
    }

    public void setDelaired(int delaired) {
        this.delaired = delaired;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
