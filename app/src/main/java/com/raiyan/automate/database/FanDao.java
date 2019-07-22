package com.raiyan.automate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.raiyan.automate.Models.Devices.Fan;

import java.util.List;

@Dao
public interface FanDao {

    @Query("SELECT * FROM fan")
    LiveData<List<Fan>> loadAllFans();

    @Query("SELECT * FROM fan WHERE roomNumber = :roomNumber")
    LiveData<List<Fan>> loadAllFansByRoom(int roomNumber);

    @Insert
    void insertFan(Fan fan);

    @Delete
    void  deleteFan(Fan fan);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateFan(Fan fan);

}
