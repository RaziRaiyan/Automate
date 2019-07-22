package com.raiyan.automate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.raiyan.automate.Models.Devices.Lock;

import java.util.List;

@Dao
public interface LockDao {

    @Query("SELECT * FROM lock")
    LiveData<List<Lock>> loadAllLocks();

    @Query("SELECT * FROM lock WHERE roomNumber = :roomNumber")
    LiveData<List<Lock>> loadAllLocksByRoom(int roomNumber);

    @Insert
    void insertLock(Lock lock);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateLock(Lock lock);

    @Delete
    void deleteLock(Lock lock);
}
