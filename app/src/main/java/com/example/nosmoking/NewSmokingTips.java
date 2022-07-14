package com.example.nosmoking;
import com.example.nosmokingdb.NewSmokingTipsDB;
import com.example.nosmokingdb.NoSmokingDatabase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NewSmokingTips extends AppCompatActivity{
    private static final int NEW_POST_SUCCESS = 200;
    private static final int NEW_POST_FAIL = 400;

    //xml refer declarations
    private EditText mPostTitle, mPostContent;
    private Button mBtnPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_smoking_tips);

        mPostTitle = findViewById(R.id.et_postTitle);
        mPostContent = findViewById(R.id.et_postContent);
        mBtnPost = findViewById(R.id.btn_post);

    }

    public void post_onClick(View view){
        //set title to untitled and context to no context given when user did not input anything for them
        if(mPostTitle.getText().toString()==null){
            mPostTitle.setText("Untitled");
        }
        if(mPostContent.getText().toString()==null){
            mPostContent.setText("No context given");
        }

        NoSmokingDatabase noSmokingDB = NoSmokingDatabase.getInstance(this);

        NewSmokingTipsDB newSmokingTipsDB = new NewSmokingTipsDB(
                mPostTitle.getText().toString(),
                mPostContent.getText().toString()
        );

        try{
            noSmokingDB.getNewSmokingTipsDao().insert(newSmokingTipsDB);
            Toast.makeText(this, "New smoking tips created successfully!", Toast.LENGTH_SHORT).show();

            Intent mainIntent = new Intent();

            setResult(RESULT_OK,mainIntent);
            finish();
        }
        catch(Error e){
            Toast.makeText(this, "Could not create new smoking tips post due to " + e, Toast.LENGTH_SHORT).show();
            finishActivity(NEW_POST_FAIL);
        }
    }
}
