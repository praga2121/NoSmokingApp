package com.example.nosmoking;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nosmokingdb.NewSmokingTipsDB;
import com.example.nosmokingdb.NoSmokingDatabase;


public class SmokingTipsPost extends AppCompatActivity {
    NoSmokingDatabase noSmokingDatabase;
    private TextView mTipsTitle;
    private TextView mTipsContent;

    public final static int NEW_POST_REQUEST_CODE = 11;

    private int tipsID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smoking_tips_post);

        mTipsTitle = findViewById(R.id.tv_tipsTitle);
        mTipsContent = findViewById(R.id.tv_tipsContent);

        Intent intent = getIntent();
        tipsID = intent.getIntExtra("TIPS_ID", 0);
        mTipsTitle.setText(intent.getStringExtra("TIPS_TITLE"));
        mTipsContent.setText(intent.getStringExtra("TIPS_CONTENT"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_POST_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                NoSmokingDatabase noSmokingDatabase = NoSmokingDatabase.getInstance(this);
                NewSmokingTipsDB currentTips = noSmokingDatabase.getNewSmokingTipsDao().getTipsFromID(tipsID);
                mTipsTitle.setText(currentTips.getTipsTitle());
                mTipsContent.setText(currentTips.getTipsContent());
            }

        }

    }
}