package com.raiyan.automate.Models.Devices;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.raiyan.automate.Models.Devices.Device;

import java.util.Date;

@Entity(tableName = "television")
public class Television extends Device {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int volume;
    private int channel_no;

    public static final int MAX_VOLUME = 100;
    public static final int MIN_VOLUME = 0;

    public static final int MIN_CHANNEL = 0;
    public static final int MAX_CHANNEL = 1000;

    @Ignore
    public Television(int roomNumber,String PIN, float energy_consumed, int device_number, String device_name, boolean state
            , Date onTime, Date offTime, int volume, int channel_no) {
        super(roomNumber,PIN, energy_consumed, device_number, device_name, state, onTime, offTime);
        this.volume = volume;
        this.channel_no = channel_no;
    }

    public Television(int id,int roomNumber, String PIN, float energyConsumed, int device_number, String device_name,
                      boolean state, Date onTime, Date offTime,  int volume, int channel_no) {
        super(roomNumber, PIN, energyConsumed, device_number, device_name, state, onTime, offTime);
        this.id = id;
        this.volume = volume;
        this.channel_no = channel_no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getChannel_no() {
        return channel_no;
    }

    public void setChannel_no(int channel_no) {
        this.channel_no = channel_no;
    }
}
