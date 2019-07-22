package com.raiyan.automate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.raiyan.automate.Models.Devices.Oven;

import java.util.List;

@Dao
public interface OvenDao {

    @Query("SELECT * FROM oven")
    LiveData<List<Oven>> loadAllOvens();

    @Query("SELECT * FROM oven WHERE roomNumber = :roomNumber")
    LiveData<List<Oven>> loadAllOvensByRoom(int roomNumber);

    @Insert
    void insertOven(Oven oven);

    @Delete
    void deleteOven(Oven oven);

    @Update
    void updateOven(Oven oven);
}
