package com.example.passwordmanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UrlDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(URLs... url);

    @Delete
    void deleteUrl(URLs url);

    @Update
    void update(URLs url);

    @Query("DELETE FROM urls")
    void deleteAll();

    @Query("SELECT * from urls LIMIT 1")
    URLs[] getAnyUrl();

    @Query("SELECT * from urls ORDER BY id ASC")
    LiveData<List<URLs>> getAllUrls();
}
