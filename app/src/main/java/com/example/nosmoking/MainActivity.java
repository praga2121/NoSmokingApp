package com.example.nosmoking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.nosmokingdb.NoSmokingDatabase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    NoSmokingDatabase noSmokingDatabase;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, initializationStatus -> {

        });

        noSmokingDatabase = Room.databaseBuilder(getApplicationContext(), NoSmokingDatabase.class, "new_smoking_tips").allowMainThreadQueries().build();

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void smokingTips_onClick(View view) {
        Intent intent = new Intent(this, SmokingTips.class);
        startActivity(intent);
    }

    public void user_onClick(View view) {
        Intent intent = new Intent(this, UserSetting.class);
        startActivity(intent);
    }
}
