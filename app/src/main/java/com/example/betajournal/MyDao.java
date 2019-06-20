package com.example.betajournal;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addSavedEntry(SavedEntries savedEntries);

    @Query("select * from entries")
    public List<SavedEntries> getSavedEntries();
}
