package com.example.nlonr.application;

import android.app.Application;
import android.content.Context;

import com.example.nlonr.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import com.example.nlonr.mylibrary.base.NetworkApi;

import java.util.HashMap;
import java.util.Map;

public class MyApp extends Application {
    public static String Update_URL = "https://www.baidu.com";
    private static MyApp mInstance = null;
    public static Map<String,String> map;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        NetworkApi.init(new MyNetWork(mInstance));
        setSmartRL();
    }

    public static Map<String,String> getCacheMap(){
        if(map==null){
            map = new HashMap<>();
        }

        return map;
    }

    private void setSmartRL(){
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.blue_light, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    public static MyApp getInstance() {
        return mInstance;
    }


}
