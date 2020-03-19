package com.example.nlonr.mylibrary.commoninterceptor;

import android.util.Log;

import java.io.IOException;

import com.example.nlonr.mylibrary.base.INetworkRequiredInfo;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CommonRequestInterceptor implements Interceptor {
    private INetworkRequiredInfo requiredInfo;
    public CommonRequestInterceptor(INetworkRequiredInfo requiredInfo){
        this.requiredInfo = requiredInfo;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("os", "android");
        builder.addHeader("appVersion",this.requiredInfo.getAppVersionCode());
        Log.d("MainActivity",chain.request().url().toString());
        return chain.proceed(builder.build());
    }

}