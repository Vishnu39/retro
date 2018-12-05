package com.example.vishnu.retro_trail.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bineesh on 10/03/2018.
 */

public class Task {
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public String getToken() {
        return token;
    }
    public String getImg() {
        return img;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }




    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String msg;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;
}
