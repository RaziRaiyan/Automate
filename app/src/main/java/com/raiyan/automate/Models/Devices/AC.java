package com.raiyan.automate.Models.Devices;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "ac")
public class AC extends Device {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int temperature;
    private boolean swing;

    public static final int MAX_TEMP = 33;
    public static final int MIN_TEMP = 16;

    @Ignore
    public AC(int roomNumber, String PIN, float energy_consumed, int device_number, String device_name, boolean state,
              Date onTime, Date offTime, int temperature, boolean swing) {
        super(roomNumber,PIN, energy_consumed, device_number, device_name, state, onTime, offTime);
        this.temperature = temperature;
        this.swing = swing;
    }

    public AC( int id, int roomNumber, String PIN, float energyConsumed, int device_number, String device_name,
              boolean state, Date onTime, Date offTime, int temperature, boolean swing) {
        super(roomNumber, PIN, energyConsumed, device_number, device_name, state, onTime, offTime);
        this.id = id;
        this.temperature = temperature;
        this.swing = swing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isSwing() {
        return swing;
    }

    public void setSwing(boolean swing) {
        this.swing = swing;
    }
}
