package com.raiyan.automate.Models.Devices;

import java.util.Date;

public class Device {

    protected int roomNumber;
    protected String PIN;
    protected float energyConsumed;
    protected int device_number;
    protected String device_name;
    protected boolean state;
    protected Date onTime;
    protected Date offTime;


    public Device(int roomNumber, String PIN, float energyConsumed, int device_number,
                  String device_name, boolean state, Date onTime, Date offTime) {
        this.roomNumber = roomNumber;
        this.PIN = PIN;
        this.energyConsumed = energyConsumed;
        this.device_number = device_number;
        this.device_name = device_name;
        this.state = state;
        this.onTime = onTime;
        this.offTime = offTime;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getOnTime() {
        return onTime;
    }

    public void setOnTime(Date onTime) {
        this.onTime = onTime;
    }

    public Date getOffTime() {
        return offTime;
    }

    public void setOffTime(Date offTime) {
        this.offTime = offTime;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public float getEnergyConsumed() {
        return energyConsumed;
    }

    public void setEnergyConsumed(float energyConsumed) {
        this.energyConsumed = energyConsumed;
    }

    public int getDevice_number() {
        return device_number;
    }

    public void setDevice_number(int device_number) {
        this.device_number = device_number;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }
}
