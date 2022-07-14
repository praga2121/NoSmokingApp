package com.example.nosmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserSetting extends AppCompatActivity {

    public final static int NEW_POST_REQUEST_CODE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_settings);

    }

    public void newSmokingTips_onClick(View view) {
        Intent intent = new Intent(this, NewSmokingTips.class);
        startActivityForResult(intent, NEW_POST_REQUEST_CODE);
    }
}