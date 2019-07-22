package com.raiyan.automate.ViewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.raiyan.automate.Models.CurrentUser;
import com.raiyan.automate.database.AppDatabase;

public class LoginViewModel extends AndroidViewModel {

    private static final String TAG = LoginViewModel.class.getSimpleName();

    private LiveData<CurrentUser> currentUser;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving current user from the database");
        currentUser = database.currentUserDao().getCurrentUser();
    }

//    public LiveData<CurrentUser> getCurrentUser(){return currentUser;}
    public CurrentUser getCurrentUser(){return currentUser.getValue();}
}
