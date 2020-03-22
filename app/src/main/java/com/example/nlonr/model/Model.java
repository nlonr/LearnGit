package com.example.nlonr.model;

import com.example.nlonr.entity.Goods;
import com.example.nlonr.entity.Login;
import com.example.nlonr.myinterface.bean.BaseObjectBean;
import com.example.nlonr.myinterface.bean.NewsChannelsBean;
import com.example.nlonr.mylibrary.api.MyNetWorkApi;
import com.example.nlonr.mylibrary.observer.BaseObserver;
import com.example.nlonr.presenter.request.Request;

import java.util.List;

import io.reactivex.Observable;

public class Model implements Request {

    @Override
    public Observable<Login> login(String username, String password) {
        return MyNetWorkApi.getService(Request.class).login(username, password);
    }

    @Override
    public Observable<BaseObjectBean<List<Goods>>> getGoods(String username, String password) {
        return MyNetWorkApi.getService(Request.class).getGoods(username, password);
    }

    @Override
    public Observable<NewsChannelsBean> getChannels(String username, String password) {
        return MyNetWorkApi.getService(Request.class).getChannels(username, password);
    }


}





