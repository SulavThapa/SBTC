package com.teser.sbtc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_map:
                Intent intent2 = new Intent(ProfileActivity.this, MapsActivity.class);
                startActivity(intent2);
                return true;
            case R.id.navigation_bus:
                Intent intent3 = new Intent(ProfileActivity.this, BusActivity.class);
                startActivity(intent3);
                return true;
            case R.id.navigation_profile:
                return false;
        }
        return false;
    };

}
