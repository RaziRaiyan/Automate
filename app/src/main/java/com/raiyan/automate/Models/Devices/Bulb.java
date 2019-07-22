package com.raiyan.automate.Models.Devices;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.raiyan.automate.Models.Devices.Device;

import java.util.Date;

@Entity(tableName = "bulb")
public class Bulb extends Device {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @Ignore
    public Bulb(int roomNumber,String PIN, float energy_consumed, int device_number, String device_name,
                boolean state, Date onTime, Date offTime) {
        super(roomNumber, PIN, energy_consumed, device_number, device_name, state, onTime, offTime);
    }

    public Bulb(int id, int roomNumber, String PIN, float energyConsumed, int device_number, String device_name,
                boolean state, Date onTime, Date offTime ) {
        super(roomNumber, PIN, energyConsumed, device_number, device_name, state, onTime, offTime);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
