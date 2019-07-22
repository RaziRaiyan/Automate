package com.raiyan.automate.Models.Devices;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "oven")
public class Oven extends Device {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int temperature;
    private int timLeftMinutes;

    public static final int MAX_TEMP = 140;
    public static final int MIN_TEMP = 50;

    @Ignore
    public Oven(int roomNumber, String PIN, float energy_consumed, int device_number, String device_name, boolean state
            , Date onTime, Date offTime, int temperature, int timLeftMinutes) {
        super(roomNumber,PIN, energy_consumed, device_number, device_name, state, onTime, offTime);
        this.temperature = temperature;
        this.timLeftMinutes = timLeftMinutes;
    }

    public Oven(int id,int roomNumber, String PIN, float energyConsumed, int device_number, String device_name, boolean state,
                Date onTime, Date offTime,  int temperature, int timLeftMinutes) {
        super(roomNumber, PIN, energyConsumed, device_number, device_name, state, onTime, offTime);
        this.id = id;
        this.temperature = temperature;
        this.timLeftMinutes = timLeftMinutes;
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

    public int getTimLeftMinutes() {
        return timLeftMinutes;
    }

    public void setTimLeftMinutes(int timLeftMinutes) {
        this.timLeftMinutes = timLeftMinutes;
    }
}
