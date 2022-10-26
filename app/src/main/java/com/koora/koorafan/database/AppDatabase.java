package com.koora.koorafan.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.koora.koorafan.dao.TeamDao;
import com.koora.koorafan.model.Team;

@Database(entities = {Team.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase instance;

    public abstract TeamDao teamDao();

    public static AppDatabase getInstance(Context context){

        if (instance == null){
            instance = Room
                    .databaseBuilder(context, AppDatabase.class, "koora_database")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

}