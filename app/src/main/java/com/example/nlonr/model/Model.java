package com.example.nlonr.model;

import com.example.nlonr.myinterface.NetWorkInterface;
import com.example.nlonr.myinterface.bean.NewsChannelsBean;
import com.example.nlonr.mylibrary.api.MyNetWorkApi;
import com.example.nlonr.mylibrary.observer.BaseObserver;

public class Model {

    public void getNewsChannels(){

        MyNetWorkApi.getService(NetWorkInterface .class)
                .getNewsChannels()
                .compose(MyNetWorkApi.getInstance().applySchedulers(new BaseObserver<NewsChannelsBean>(){
                    @Override
                    public void onSuccess(NewsChannelsBean newsChannelsBean) {

                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                }));

    }

}
