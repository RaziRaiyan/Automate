package com.raiyan.automate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.raiyan.automate.Models.Devices.AC;

import java.util.List;

@Dao
public interface ACDao {

    @Query("SELECT * FROM ac")
    LiveData<List<AC>> loadAllACs();

    @Query("SELECT * FROM ac WHERE roomNumber = :roomNumber")
    LiveData<List<AC>> loadAllACsByRoom(int roomNumber);

    @Delete
    void deleteAC(AC ac);

    @Insert
    void insertAC(AC ac);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateAC(AC ac);

}
