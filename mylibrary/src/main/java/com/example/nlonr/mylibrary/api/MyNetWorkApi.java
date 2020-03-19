package com.example.nlonr.mylibrary.api;

import com.example.nlonr.mylibrary.base.NetworkApi;
import com.example.nlonr.mylibrary.beans.ServerBaseResponse;
import com.example.nlonr.mylibrary.errorhandler.ExceptionHandle;
import com.example.nlonr.mylibrary.uitls.TecentUtil;

import java.io.IOException;

import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MyNetWorkApi  extends NetworkApi {

    private static volatile MyNetWorkApi sInstance;

    public static MyNetWorkApi getInstance() {
        if (sInstance == null) {
            synchronized (MyNetWorkApi.class) {
                if (sInstance == null) {
                    sInstance = new MyNetWorkApi();
                }
            }
        }
        return sInstance;
    }

    public static  <T> T getService(Class<T> service) {
        return getInstance().getRetrofit(service).create(service);
    }

    @Override
    protected Interceptor getInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                String timeStr = TecentUtil.getTimeStr();
                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("Source", "source");
                builder.addHeader("Authorization", TecentUtil.getAuthorization(timeStr));
                builder.addHeader("Date", timeStr);
                return chain.proceed(builder.build());
            }
        };
    }

    protected <T> Function<T, T> getAppErrorHandler() {
        return new Function<T, T>() {
            @Override
            public T apply(T response) throws Exception {
                //response中code码不会0 出现错误
                if (response instanceof ServerBaseResponse && ((ServerBaseResponse) response).showapiResCode != 0) {
                    ExceptionHandle.ServerException exception = new ExceptionHandle.ServerException();
                    exception.code = ((ServerBaseResponse) response).showapiResCode;
                    exception.message = ((ServerBaseResponse) response).showapiResError != null ? ((ServerBaseResponse) response).showapiResError : "";
                    throw exception;
                }
                return response;
            }
        };
    }

    @Override
    public String getFormal() {
        return "http://service-o5ikp40z-1255468759.ap-shanghai.apigateway.myqcloud.com/";
    }

    @Override
    public String getTest() {
        return "http://service-o5ikp40z-1255468759.ap-shanghai.apigateway.myqcloud.com/";
    }

}
