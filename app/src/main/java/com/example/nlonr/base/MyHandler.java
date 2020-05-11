package com.example.nlonr.base;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import org.greenrobot.eventbus.EventBus;

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
//                EventBus.getDefault().post(new String("她付钱了可以过去"));
            }
        }
    }
}