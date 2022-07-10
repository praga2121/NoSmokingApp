package com.example.nosmokingdb;

import android.annotation.TargetApi;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NewSmokingTipsDao {
    @Query("SELECT * FROM newSmokingTips")
    List<NewSmokingTipsDB> getAll();

    @Insert(onConflict = 1)
    void insert(NewSmokingTipsDB newSmokingTipsDB);

    @Update
    void update(NewSmokingTipsDB newSmokingTipsDB);

    @Delete
    void delete(NewSmokingTipsDB newSmokingTipsDB);
}
