package com.example.vishnu.retro_trail.config;

import com.example.vishnu.retro_trail.pojos.CheckUser;
import com.example.vishnu.retro_trail.pojos.Task;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIinterface {
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("checkUser")
    Call<Task> checkuser(@Body CheckUser checkuser);

}
