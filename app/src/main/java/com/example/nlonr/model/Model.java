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
//                .compose(
//                MyNetWorkApi.getInstance().applySchedulers(new BaseObserver<Login>() {
//                    @Override
//                    public void onSuccess(Login login) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Throwable e) {
//
//                    }
//                }));
    }

    @Override
    public Observable<BaseObjectBean<List<Goods>>> getGoods(String username, String password) {
        return null;
    }

    @Override
    public Observable<NewsChannelsBean> getChannels(String username, String password) {
        return null;
    }


}





