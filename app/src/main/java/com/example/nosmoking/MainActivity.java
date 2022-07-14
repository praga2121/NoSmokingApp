package com.example.nosmoking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.nosmokingdb.NoSmokingDatabase;


public class MainActivity extends AppCompatActivity {
    NoSmokingDatabase noSmokingDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noSmokingDatabase = Room.databaseBuilder(getApplicationContext(), NoSmokingDatabase.class, "new_smoking_tips").allowMainThreadQueries().build();
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
