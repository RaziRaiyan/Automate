package com.raiyan.automate.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.raiyan.automate.Models.CurrentUser;
import com.raiyan.automate.Models.Devices.AC;
import com.raiyan.automate.Models.Devices.Bulb;
import com.raiyan.automate.Models.Devices.Cooler;
import com.raiyan.automate.Models.Devices.CoolerSpeedConverter;
import com.raiyan.automate.Models.Devices.DateConverter;
import com.raiyan.automate.Models.Devices.Fan;
import com.raiyan.automate.Models.Devices.Lock;
import com.raiyan.automate.Models.Devices.Oven;
import com.raiyan.automate.Models.Devices.Surveillance;
import com.raiyan.automate.Models.Devices.SurveilliancePrivacyConverter;
import com.raiyan.automate.Models.Devices.Television;

@Database(entities = {AC.class, Bulb.class, Cooler.class, Fan.class, Lock.class, Oven.class,
                        Surveillance.class, Television.class, com.raiyan.automate.Models.Rooms.Room.class,
                        CurrentUser.class}
                ,version = 1, exportSchema = false)
@TypeConverters({DateConverter.class, CoolerSpeedConverter.class, SurveilliancePrivacyConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    private static final String TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "automate_database";
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context){
        if(sInstance == null){
            synchronized (LOCK){
                Log.d(TAG, "getInstance: Crating database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(TAG, "getInstance: getting database instance");
        return sInstance;
    }

    public abstract ACDao acDao();
    public abstract BulbDao bulbDao();
    public abstract CoolerDao coolerDao();
    public abstract FanDao fanDao();
    public abstract LockDao lockDao();
    public abstract OvenDao ovenDao();
    public abstract SurvellianceDao survellianceDao();
    public abstract TelevisionDao televisionDao();
    public abstract RoomDao roomDao();
    public abstract CurrentUserDao currentUserDao();
}
