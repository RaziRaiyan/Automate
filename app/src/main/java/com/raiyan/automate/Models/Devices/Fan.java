package com.raiyan.automate.Models.Devices;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.raiyan.automate.Models.Devices.Device;

import java.util.Date;

@Entity(tableName = "fan")
public class Fan extends Device {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int speed;
    public static final int MAX_SPEED = 5;

    @Ignore
    public Fan(int roomNumber,String PIN, float energy_consumed, int device_number, String device_name, boolean state,
               Date onTime, Date offTime, int speed) {
        super(roomNumber,PIN, energy_consumed, device_number, device_name, state, onTime, offTime);
        this.speed = speed;
    }

    public Fan(int id,int roomNumber, String PIN, float energyConsumed, int device_number, String device_name,
               boolean state, Date onTime, Date offTime,  int speed) {
        super(roomNumber, PIN, energyConsumed, device_number, device_name, state, onTime, offTime);
        this.id = id;
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
