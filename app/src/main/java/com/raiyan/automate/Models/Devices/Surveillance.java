package com.raiyan.automate.Models.Devices;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.raiyan.automate.Models.Devices.Device;

import java.util.Date;

@Entity(tableName = "surveillance")
public class Surveillance extends Device {

    public enum Privacy{
        ONLY_ME(0), APARTMENT_SECURITY(1),MY_FAMILY(2),OFF(3);

        private int code;

        Privacy(int code) {
            this.code = code;
        }

        public int getCode(){
            return code;
        }
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    private Privacy privacy;
    private String videoUrl;

    @Ignore
    public Surveillance(int roomNumber,String PIN, float energy_consumed, int device_number, String device_name, boolean state
            , Date onTime, Date offTime, Privacy privacy, String videoUrl) {
        super(roomNumber,PIN, energy_consumed, device_number, device_name, state, onTime, offTime);
        this.privacy = privacy;
        this.videoUrl = videoUrl;
    }

    public Surveillance(int id,int roomNumber, String PIN, float energyConsumed, int device_number, String device_name, boolean state,
                        Date onTime, Date offTime,  Privacy privacy, String videoUrl) {
        super(roomNumber, PIN, energyConsumed, device_number, device_name, state, onTime, offTime);
        this.id = id;
        this.privacy = privacy;
        this.videoUrl = videoUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
