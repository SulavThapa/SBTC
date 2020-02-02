package com.teser.sbtc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String BaseUrl = "https://webhooks.mongodb-stitch.com/";

    private Button enter;
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(view -> {
            Log.i("When Button is clicked", "-----------------------------------------------");

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            LoginInterface service = retrofit.create(LoginInterface.class);
            Call<Login> call = service.getLoginData();
            Log.i("Reached here", "-----------------------------------------------");

            call.enqueue(new Callback<Login>() {
                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    if (response.code() == 200) {
                        Login login = response.body();
                        assert login != null;
                        Log.i("Start Before Loop", "-----------------------------------------------");


                        for (int i = 0; i < 3; i++) {
                            String email = login.email + " ";
                            String pass = login.password + " ";
                            Log.i("Start", "-----------------------------------------------");
                            Log.i("Output", email + " " + pass);
                            Log.i("End", "-----------------------------------------------");


                        }
                    }
                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    Log.i("Error", "-----------------------------------------------");
                    Log.e("Error: ", t.getMessage());
                    Log.i("Error", "-----------------------------------------------");

                }
            });
        });
    }
}
