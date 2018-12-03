package com.ajay.mvvmpattern.model;

import android.databinding.BaseObservable;
import android.text.TextUtils;
import android.util.Patterns;

public class User extends BaseObservable {
    private String mEamil;
    private String mPassword;

    public User(String mEamil, String mPassword) {
        this.mEamil = mEamil;
        this.mPassword = mPassword;
    }

    public String getmEamil() {
        return mEamil;
    }

    public void setmEamil(String mEamil) {
        this.mEamil = mEamil;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }


    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getmEamil()) && Patterns.EMAIL_ADDRESS.matcher(getmEamil()).matches() && getmPassword().length() > 5;
    }
}
