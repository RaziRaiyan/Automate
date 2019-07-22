package com.raiyan.automate.Models.Devices;

import androidx.room.TypeConverter;

public class CoolerSpeedConverter {

    @TypeConverter
    public static Cooler.SPEED toSpeed(int code){
        if(code == Cooler.SPEED.LOW.getCode()){
            return Cooler.SPEED.LOW;
        }else if(code == Cooler.SPEED.MEDIUM.getCode()){
            return Cooler.SPEED.MEDIUM;
        }else {
            return Cooler.SPEED.HIGH;
        }
    }

    @TypeConverter
    public static int toInteger(Cooler.SPEED speed){
        return speed.getCode();
    }

}
