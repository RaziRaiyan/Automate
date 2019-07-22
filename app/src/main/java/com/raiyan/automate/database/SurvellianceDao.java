package com.raiyan.automate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.raiyan.automate.Models.Devices.Surveillance;

import java.util.List;

@Dao
public interface SurvellianceDao {

    @Query("SELECT * FROM surveillance")
    LiveData<List<Surveillance>> loadAllSurveilliances();

    @Query("SELECT * FROM surveillance WHERE roomNumber = :roomNumber")
    LiveData<List<Surveillance>> loadAllSurveilliancesByRoom(int roomNumber);

    @Insert
    void insertSurveilliance(Surveillance surveillance);

    @Delete
    void deleteSurveilliance(Surveillance surveillance);

    @Update
    void updateSurveilliance(Surveillance surveillance);

}
