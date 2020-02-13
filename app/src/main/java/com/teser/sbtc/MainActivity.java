package com.teser.sbtc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

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

            //LogingUser();

            Log.i("The password is hashed", "-----------------------------------------------");
            //to hash the password with bcrypt
            String  originalPassword = "test";
            String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
            System.out.println(generatedSecuredPasswordHash);

            Log.i("When Button is clicked", "-----------------------------------------------");


            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        });
    }

    private void LogingUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.i("Reached here 1", "-----------------------------------------------");

        LoginInterface service = retrofit.create(LoginInterface.class);
        Call<List<Login>> call = service.getLoginData();
        Log.i("Reached here 2 ", "-----------------------------------------------");

        call.enqueue(new Callback<List<Login>>() {
            @Override
            public void onResponse(Call<List<Login>> call, Response<List<Login>> response) {
                Log.i("Reached here 3 ", "-----------------------------------------------");
                if (response.code() == 200) {
                    Log.i("Reached here 4 ", "-----------------------------------------------");
                    Login login = (Login) response.body();
                    assert login != null;

                    String email = login.email + " ";
                    String pass = login.password + " ";
                    Log.i("Start", "-----------------------------------------------");
                    Log.i("Output", email + " " + pass);
                    Log.i("End", "-----------------------------------------------");
                }
            }

            @Override
            public void onFailure(Call<List<Login>> call, Throwable t) {
                Log.i("Error", "-----------------------------------------------");
                Log.e("Error: ", t.getMessage());
                Log.i("Error", "-----------------------------------------------");

            }
        });
    }
}
