package com.raiyan.automate.ViewModels;

import android.app.Application;
import android.app.ListActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.raiyan.automate.Models.Rooms.Room;
import com.raiyan.automate.database.AppDatabase;

import java.util.List;

public class RoomsViewModel extends AndroidViewModel {

    private static final String TAG = RoomsViewModel.class.getSimpleName();

    private LiveData<List<Room>> rooms;

    public RoomsViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        rooms = database.roomDao().loaddAllRooms();
    }

    public LiveData<List<Room>> getRooms(){return rooms;}
}
