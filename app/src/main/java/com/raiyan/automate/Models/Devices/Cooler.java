package com.raiyan.automate.Models.Devices;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.raiyan.automate.Models.Devices.Device;

import java.util.Date;

@Entity(tableName = "cooler")
public class Cooler extends Device {

    public enum SPEED{
        LOW(0),MEDIUM(1),HIGH(2);

        private int code;

        SPEED(int code) {
            this.code = code;
        }

        public int getCode(){
            return code;
        }
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    private SPEED speed;
    private boolean swing;

    @Ignore
    public Cooler(int roomNumber,String PIN, float energy_consumed, int device_number, String device_name, boolean state
            , Date onTime, Date offTime, SPEED speed, boolean swing) {
        super(roomNumber,PIN, energy_consumed, device_number, device_name, state, onTime, offTime);
        this.speed = speed;
        this.swing = swing;
    }

    public Cooler(int id,int roomNumber, String PIN, float energyConsumed, int device_number, String device_name,
                  boolean state, Date onTime, Date offTime,  SPEED speed, boolean swing) {
        super(roomNumber, PIN, energyConsumed, device_number, device_name, state, onTime, offTime);
        this.id = id;
        this.speed = speed;
        this.swing = swing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SPEED getSpeed() {
        return speed;
    }

    public void setSpeed(SPEED speed) {
        this.speed = speed;
    }

    public boolean isSwing() {
        return swing;
    }

    public void setSwing(boolean swing) {
        this.swing = swing;
    }
}
