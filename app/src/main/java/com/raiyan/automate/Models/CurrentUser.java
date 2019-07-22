package com.raiyan.automate.Models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "current_user")
public class CurrentUser {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userName;
    private String photoUrl;
    private String email;
    private String phoneNumber;

    @Ignore
    public CurrentUser(String userName, String photoUrl, String email, String phoneNumber) {
        this.userName = userName;
        this.photoUrl = photoUrl;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public CurrentUser(int id, String userName, String photoUrl, String email, String phoneNumber) {
        this.id = id;
        this.userName = userName;
        this.photoUrl = photoUrl;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
