package com.example.nosmoking;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nosmokingdb.NewSmokingTipsDB;
import com.example.nosmokingdb.NoSmokingDatabase;

import java.util.List;

public class SmokingTips extends AppCompatActivity {
    private RecyclerView mSmokingTips;
    private SmokingTipsAdapter mSmokingTipsAdapter;

    public final static int NEW_POST_REQUEST_CODE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smoking_tips);

        TextView textView = findViewById(R.id.tv_proTips);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        NoSmokingDatabase noSmokingDatabase = NoSmokingDatabase.getInstance(this);
        mSmokingTips = findViewById(R.id.rv_smokingTips);

        List<NewSmokingTipsDB> smokingTipsList = noSmokingDatabase.getNewSmokingTipsDao().getAll();

        mSmokingTipsAdapter = new SmokingTipsAdapter(this, smokingTipsList);
        mSmokingTips.setAdapter(mSmokingTipsAdapter);
        mSmokingTips.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_POST_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                NoSmokingDatabase noSmokingDatabase = NoSmokingDatabase.getInstance(this);
                List<NewSmokingTipsDB> smokingTipsList = noSmokingDatabase.getNewSmokingTipsDao().getAll();
                mSmokingTipsAdapter = new SmokingTipsAdapter(this, smokingTipsList);
                mSmokingTips.setAdapter(mSmokingTipsAdapter);
                mSmokingTips.setLayoutManager(new LinearLayoutManager(this));
                mSmokingTips.getAdapter().notifyDataSetChanged();
            }
        }

    }
}
