package com.teser.sbtc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String BaseUrl = "https://api.thingspeak.com/";
    public static String lat;
    public static String lon;

    private Button enter;
    private EditText username;
    private final String CHANNEL_ID = "notification";
    private final int NOTIFICATION_ID = 001;
//    public String lat, lon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(view -> {

            LogingUser();

            Log.i("The password is hashed", "-----------------------------------------------");
            //to hash the password with bcrypt
            String  originalPassword = "test";
            String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
            System.out.println(generatedSecuredPasswordHash);

            Log.i("When Button is clicked", "-----------------------------------------------");
            Log.i("Displaying username", username.getText().toString());

            String code = username.getText().toString();
            if(code.equals("tracker")){
                Intent intent = new Intent(MainActivity.this, Test.class);
                startActivity(intent);
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Incorrect code!! Enter the valid code",
                        Toast.LENGTH_SHORT);

                toast.show();
            }

        });
    }

    public void LogingUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.i("Reached here 1", "-----------------------------------------------");

        LoginInterface service = retrofit.create(LoginInterface.class);
        Call<MainChannel> call = service.getGpsData();
        Log.i("Reached here 2 ", "-----------------------------------------------");

        call.enqueue(new Callback<MainChannel>() {
            @Override
            public void onResponse(Call<MainChannel> call, Response<MainChannel> response) {
                Log.i("Reached here 3 ", "-----------------------------------------------");
                if (response.code() == 200) {
                    Log.i("Reached here 4 ", "-----------------------------------------------");
                    MainChannel mainChannel = (MainChannel) response.body();
                    assert mainChannel != null;

                    int ss = mainChannel.feeds.size();
                    for (int i = 0; i < ss; i++) {

                        lat = mainChannel.feeds.get(i).getField1() + " ";
                        lon = mainChannel.feeds.get(i).getField2() + " ";
                        Log.i("Start", "-----------------------------------------------");
                        Log.i("Output", lat + " " + lon);
                        Log.i("End", "-----------------------------------------------");
                    }
                }
            }

            @Override
            public void onFailure(Call<MainChannel> call, Throwable t) {
                Log.i("Error", "-----------------------------------------------");
                Log.e("Error: ", t.getMessage());
                Log.i("Error", "-----------------------------------------------");

            }
        });
    }
}
