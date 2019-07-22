package com.raiyan.automate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.raiyan.automate.Models.Rooms.Room;

import java.util.List;

@Dao
public interface RoomDao {

    @Query("SELECT * FROM room")
    LiveData<List<Room>> loaddAllRooms();

    @Insert
    void insertRoom(Room room);

    @Delete
    void deleteRoom(Room room);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateRoom(Room room);
}
