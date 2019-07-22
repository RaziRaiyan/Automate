package com.raiyan.automate.Models.Devices;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.raiyan.automate.Models.Devices.Device;

import java.util.Date;

@Entity(tableName = "lock")
public class Lock extends Device {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int password;

    @Ignore
    public Lock(int roomNumber,String PIN, float energy_consumed, int device_number, String device_name, boolean state,
                Date onTime, Date offTime, int password) {
        super(roomNumber, PIN, energy_consumed, device_number, device_name, state, onTime, offTime);
        this.password = password;
    }

    public Lock(int id,int roomNumber, String PIN, float energyConsumed, int device_number, String device_name,
                boolean state, Date onTime, Date offTime,  int password) {
        super(roomNumber, PIN, energyConsumed, device_number, device_name, state, onTime, offTime);
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
