package com.ajay.mvvmpattern.viewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ajay.mvvmpattern.model.User;
import com.android.databinding.library.baseAdapters.BR;

public class LoginViewModel extends BaseObservable {
    // 1. This class will get EditText from view and pass it to model for validation check
    // 2. It will contain methods of views event triggered (like button click n etc )
    // 3. It will contain message that will be shown on an event generated (button click) and it will send them to view


    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    private User user;

    public LoginViewModel() {
        this.user = new User("","");
    }

    // editText methods through will data will come
    public void afterEmailTextChanged(CharSequence  s) {
        user.setmEamil(s.toString());

    }

    public void afterPasswordTextChanged(CharSequence s){
        user.setmPassword(s.toString());
    }

    public void onLoginClicked() {
        if (user.isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);

    }


    @Bindable
    public String toastMessage = null;    // bind that message u want to show on view

    // method that will send data back to view (Main Activity)
    private void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        // we need BaseObservable method notifyPropertyChanged to tell the View (MainActivity) at run time about this message
        notifyPropertyChanged(BR.toastMessage);  // if BR.toastMessage doesnt reslove  (tap on it press alt+enter (or right click ) --> create a field
    }


}
