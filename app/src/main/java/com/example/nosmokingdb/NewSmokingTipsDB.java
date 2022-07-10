package com.example.nosmokingdb;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.sql.Blob;

//db for smoking tips
@Entity(tableName = "newSmokingTips")
public class NewSmokingTipsDB{
    @PrimaryKey(autoGenerate = true)
    public int tipsID;
    @ColumnInfo(name = "tips_title")
    public String tipsTitle;
    @ColumnInfo(name = "tips_content")
    public String tipsContent;


    public NewSmokingTipsDB(
            int tipsID,
            String tipsTitle,
            String tipsContent
    ){
        this.tipsID = tipsID;
        this.tipsTitle = tipsTitle;
        this.tipsContent = tipsContent;
    }

    @Ignore
    public NewSmokingTipsDB(
            String tipsTitle,
            String tipsContent
    ){
        this.tipsTitle = tipsTitle;
        this.tipsContent = tipsContent;
    }

    //Getter and Setter for tips id
    public int getTipsID(){
        return tipsID;
    }
    public void setTipsID(int tipsID) {
        this.tipsID = tipsID;
    }

    //Getter and setter for tips title
    public String getTipsTitle(){
        return tipsTitle;
    }
    public void setTipsTitle(String tipsTitle) {
        this.tipsTitle = tipsTitle;
    }

    //Getter and setter for tips content
    public String getTipsContent() {
        return tipsContent;
    }
    public void setTipsContent(String tipsContent) {
        this.tipsContent = tipsContent;
    }


}
