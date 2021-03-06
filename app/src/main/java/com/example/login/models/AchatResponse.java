package com.example.login.models;

import com.google.gson.annotations.SerializedName;

public class AchatResponse {
    @SerializedName("success")
    Boolean success;
    @SerializedName("message")
    String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
