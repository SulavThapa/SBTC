package com.teser.sbtc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

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
    private EditText username;
    private final String CHANNEL_ID = "notification";
    private final int NOTIFICATION_ID = 001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(view -> {

            //LogingUser();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                    .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                    .setContentTitle("My notification")
                    .setContentText("Much longer text that cannot fit one line...")
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Much longer text that cannot fit one line..."))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
            notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());

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
