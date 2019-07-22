package com.raiyan.automate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.raiyan.automate.Models.Devices.Bulb;

import java.util.List;

@Dao
public interface BulbDao {

    @Insert
    void insertBulb(Bulb bulb);

    @Delete
    void deleteBulb(Bulb bulb);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateBulb(Bulb bulb);

    @Query("SELECT * FROM bulb")
    LiveData<List<Bulb>> loadAllBulbs();

    @Query("SELECT * FROM bulb WHERE roomNumber = :roomNumber")
    LiveData<List<Bulb>> loadAllBulbsByRoom(int roomNumber);
}
