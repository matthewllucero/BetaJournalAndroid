package com.example.betajournal;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {SavedEntries.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();

}
