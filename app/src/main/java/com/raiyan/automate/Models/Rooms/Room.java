package com.raiyan.automate.Models.Rooms;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.raiyan.automate.Models.Devices.AC;
import com.raiyan.automate.Models.Devices.Bulb;
import com.raiyan.automate.Models.Devices.Cooler;
import com.raiyan.automate.Models.Devices.Fan;
import com.raiyan.automate.Models.Devices.Lock;
import com.raiyan.automate.Models.Devices.Surveillance;
import com.raiyan.automate.Models.Devices.Television;

import java.util.List;

@Entity(tableName = "room")
public class Room {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String roomName;
    private int roomNumber;
    private String photoUrl;

    public Room(int id, String roomName, int roomNumber, String photoUrl) {
        this.id = id;
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.photoUrl = photoUrl;
    }

    @Ignore
    public Room(String roomName, int roomNumber, String photoUrl) {
        this.roomName = roomName;
        this.roomNumber = roomNumber;
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
