package com.example.nlonr.application;

import android.app.Application;

import com.bumptech.glide.BuildConfig;
import com.example.nlonr.mylibrary.base.INetworkRequiredInfo;

public class MyNetWork implements INetworkRequiredInfo {

    private Application mApplication;

    public MyNetWork(Application application){
        this.mApplication = application;
    }
    @Override
    public String getAppVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public String getAppVersionCode() {
        return String.valueOf(BuildConfig.VERSION_CODE);
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public Application getApplicationContext() {
        return mApplication;
    }
}
