package com.example.vishnu.retro_trail.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bineesh on 08/03/2018.
 */

public class CheckUser {
    @SerializedName("cred1")
    @Expose
    private String cred1;

    public CheckUser(String cred1){
        this.cred1 = cred1;

    }

    public String getcred1() {
        return cred1;
    }

    public void setCred1(String cred1) {
        this.cred1 = cred1;
    }
}
