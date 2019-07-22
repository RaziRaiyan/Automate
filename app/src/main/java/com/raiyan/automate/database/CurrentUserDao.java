package com.raiyan.automate.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.raiyan.automate.Models.CurrentUser;

import java.util.List;

@Dao
public interface CurrentUserDao {

    @Query("SELECT * FROM current_user")
    LiveData<CurrentUser> getCurrentUser();
}
