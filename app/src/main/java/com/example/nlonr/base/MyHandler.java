package com.example.nlonr.base;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

public class MyHandler extends Handler {
    WeakReference<Activity> mWeakReference;

    public MyHandler(Activity activity) {
        mWeakReference = new WeakReference<Activity>(activity);
    }

    @Override
    public void handleMessage(Message msg) {
        final Activity activity = mWeakReference.get();
        if (activity != null) {
            if (msg.what == 1) {

            }
        }
    }
}