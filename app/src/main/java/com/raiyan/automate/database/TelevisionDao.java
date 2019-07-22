package com.raiyan.automate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.raiyan.automate.Models.Devices.Television;

import java.util.List;

@Dao
public interface TelevisionDao {

    @Query("SELECT * FROM television")
    LiveData<List<Television>> loadAllTelevisions();

    @Query("SELECT * FROM television WHERE roomNumber = :roomNumber")
    LiveData<List<Television>> loadAllTelevisionsByRoom(int roomNumber);

    @Insert
    void insertTelevesion(Television television);

    @Delete
    void deleteTelevesion(Television television);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTelevesion(Television television);

}
