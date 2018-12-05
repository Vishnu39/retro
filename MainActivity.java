package com.example.vishnu.retro_trail;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vishnu.retro_trail.config.APIinterface;
import com.example.vishnu.retro_trail.config.ApiClient;
import com.example.vishnu.retro_trail.pojos.CheckUser;
import com.example.vishnu.retro_trail.pojos.Task;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText checkuser_et;
    Button check_bt;
    APIinterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkuser_et=findViewById(R.id.checkuser);
        check_bt=findViewById(R.id.check);
        check_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkuser_API();
            }
        });
    }

    private void checkuser_API() {
        String user=checkuser_et.getText().toString();
        apiInterface = ApiClient.getClient().create(APIinterface.class);
        CheckUser checkuserpojo = new CheckUser(user);
        Call<Task> callregister = apiInterface.checkuser(checkuserpojo);
        callregister.enqueue(new Callback<Task>() {
            @Override
            public void onResponse(@NonNull Call<Task> call, @NonNull Response<Task> response) {
                String otp  = "";
                Task x = response.body();
                if(x == null){
                    try {
                        String error = response.errorBody().string();
                        Log.e("ERROR",error);

                        Toast.makeText(MainActivity.this, "NULL", Toast.LENGTH_SHORT).show();

                    }catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "IOException", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    String code = String.valueOf(x.getCode());
                    String msg = String.valueOf(x.getMsg());
                    if (msg.equals("success")){
                        Log.e("code ", code);
                        Toast.makeText(MainActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                    }
                    else if (msg.equals("false")) {
                        Toast.makeText(MainActivity.this, "UnRegistewred", Toast.LENGTH_SHORT).show();
                    }
                }


               /* if(String.valueOf(response.body()).equals("true")){
                    callback.onuserexist(0,"");
                }
                else if(String.valueOf(response.body()).equals("true")){
                    callback.onusernotexist();
                }
                else {
                    try {
                        if (!response.body().isJsonNull()) {
                            otp = response.body().getAsJsonObject().get("otp").getAsString();
                            Log.e("OTP ", otp);
                            callback.onuserexist(1,otp);
                        }
                        //res = String.valueOf(response.body());
                    } catch (Exception e) {
                        callback.onfailure(String.valueOf(e));
                        Log.e("Exception ", e.getLocalizedMessage());
                    }
                }*/
                Log.e("RESPONSE", String.valueOf(response.body()));
            }
            @Override
            public void onFailure(@NonNull Call<Task> call, @NonNull Throwable t) {
                // Log.e("FAILED",t.getMessage());
                Toast.makeText(MainActivity.this, "Failured", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
