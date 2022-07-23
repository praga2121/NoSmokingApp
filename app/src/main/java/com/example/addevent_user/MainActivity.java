package com.example.addevent_user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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
    }
}