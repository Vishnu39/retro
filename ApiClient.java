package com.example.vishnu.retro_trail.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String USER_IMG_URL = "http://onfully.in/user/image/";
    public static final String BASE_IMG_URL = "http://onfully.in/images/";
    public static final String BASE_URL = "http://onfully.in/api/";
    public static final String PROFILE_BASE_URL = "http://onfully.in/";

    private static Retrofit retrofit = null;
        public static Retrofit getClient() {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(logging);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            if (retrofit==null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(httpClient.build())
                        .build();
            }
            return retrofit;
        }
}
