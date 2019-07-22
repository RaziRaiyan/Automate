package com.raiyan.automate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.raiyan.automate.Models.Devices.Cooler;

import java.util.List;

@Dao
public interface CoolerDao {
    @Query("SELECT * FROM cooler")
    LiveData<List<Cooler>> loadAllCoolers();

    @Query("SELECT * FROM cooler WHERE roomNumber = :roomNumber")
    LiveData<List<Cooler>> loadAllCoolersByRoom(int roomNumber);

    @Insert
    void insertCooler(Cooler cooler);

    @Delete
    void deleteCooler(Cooler cooler);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCooler(Cooler cooler);
}
