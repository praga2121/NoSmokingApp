package com.example.nosmokingdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {NewSmokingTipsDB.class}, version = 1)
public abstract class NoSmokingDatabase extends RoomDatabase {
    private static final String DB_NAME = "noSmoking_db";
    public abstract NewSmokingTipsDao getNewSmokingTipsDao();
    public static NoSmokingDatabase noSmokingDB;

    public static NoSmokingDatabase getInstance(Context context) {
        if (null == noSmokingDB) {
            noSmokingDB = Room.databaseBuilder(context.getApplicationContext(), NoSmokingDatabase.class, DB_NAME).allowMainThreadQueries().build();
        }
        return noSmokingDB;
    }
}

