package com.koora.koorafan.database;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseInstance {
    AppDatabase db;

    public AppDatabase getDb(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context,
                    AppDatabase.class, "database-name").build();
        }
        return db;
    }
}
