package com.raiyan.automate.Models.Devices;

import androidx.room.TypeConverter;

public class SurveilliancePrivacyConverter {

    @TypeConverter
    public static Surveillance.Privacy toPrivacy(int code){
        if(code == Surveillance.Privacy.ONLY_ME.getCode()){
            return Surveillance.Privacy.ONLY_ME;
        }else if(code ==  Surveillance.Privacy.APARTMENT_SECURITY.getCode()){
            return Surveillance.Privacy.APARTMENT_SECURITY;
        }else if(code == Surveillance.Privacy.MY_FAMILY.getCode()){
            return Surveillance.Privacy.MY_FAMILY;
        }else {
            return Surveillance.Privacy.OFF;
        }
    }

    @TypeConverter
    public static int toInteger(Surveillance.Privacy privacy){
        return privacy.getCode();
    }
}
