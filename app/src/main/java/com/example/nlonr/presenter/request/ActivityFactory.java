package com.example.nlonr.presenter.request;

import android.app.Activity;

public class ActivityFactory {
    public static Activity activity;

    public static Activity creator(Activity act) {
        ActivityFactory.activity = act;
        return activity;
    }

}
