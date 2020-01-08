package com.teser.sbtc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPage();
            }
        });
    }

    private void mainPage() {
//        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
//        startActivity(intent);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginInterface service = retrofit.create(LoginInterface.class);
        Call<Login> call = service.getLoginData();
        call.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.code() == 200) {
                    Login login = response.body();
                    assert login != null;
                    String name = login.name + " ";
                    String pass = login.password + " ";

                    System.out.println(name + " " + pass);
                    if(username.getText().toString().equalsIgnoreCase(name) && password.getText().toString().equalsIgnoreCase((pass))){
                      Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                      startActivity(intent);
                    };
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

            }
        });
    }
}
