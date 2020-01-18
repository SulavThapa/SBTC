package com.teser.sbtc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.navigation_map:
                Intent intent2 = new Intent(BusActivity.this, MapsActivity.class);
                startActivity(intent2);
                return true;
            case R.id.navigation_bus:
                return false;
            case R.id.navigation_profile:
                Intent intent3 = new Intent(BusActivity.this, ProfileActivity.class);
                startActivity(intent3);
                return true;
        }
        return false;
    };
}
