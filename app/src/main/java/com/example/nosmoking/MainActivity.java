package com.example.nosmoking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.room.Room;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.nosmokingdb.NoSmokingDatabase;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    NoSmokingDatabase noSmokingDatabase;
    private AdView mAdView;
    Button notifyBtn;

    EditText title;
    EditText moneySpent;
    Button addEvent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title=findViewById(R.id.editTitle);
        moneySpent=findViewById(R.id.editMoneySpent);
        addEvent=findViewById(R.id.buttonAddEvent);

        addEvent.setOnClickListener(v -> {
            if (!title.getText().toString().isEmpty() && !moneySpent.getText().toString().isEmpty()) {

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, title.getText().toString());
                intent.putExtra(CalendarContract.Events.DESCRIPTION, moneySpent.getText().toString());

                intent.putExtra(Intent.EXTRA_EMAIL,"hello123@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "There is no app that support this action", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(MainActivity.this, "Please fill all the fields",
                        Toast.LENGTH_SHORT).show();
            }
        });

        MobileAds.initialize(this, initializationStatus -> {

        });

        noSmokingDatabase = Room.databaseBuilder(getApplicationContext(), NoSmokingDatabase.class, "new_smoking_tips").allowMainThreadQueries().build();

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        notifyBtn = findViewById(R.id.notify_btn);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Notification", "Notification" , NotificationManager.IMPORTANCE_DEFAULT );
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"Notification");
                builder.setContentTitle("Notification from No Smoking App");
                builder.setContentText("Daily Reminder to Stay Healthy!");
                builder.setSmallIcon(R.drawable.ic_launcher_foreground);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());

            }
        });
    }

    public void user_onClick(View view) {
        Intent intent = new Intent(this, UserSetting.class);
        startActivity(intent);
    }

    public void ranking_onClick(View view) {
        Intent intent = new Intent(this, Ranking.class);
        startActivity(intent);
    }

    public void smokingTips_onClick(View view) {
        Intent intent = new Intent(this, SmokingTips.class);
        startActivity(intent);
    }

    public void community_onClick(View view) {
        Intent intent = new Intent(this, Messenger.class);
        startActivity(intent);
    }

    public void getHelp_onClick(View view) {
        Intent intent = new Intent(this, GetHelp.class);
        startActivity(intent);
    }
}
