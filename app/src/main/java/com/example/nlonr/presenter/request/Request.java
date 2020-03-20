package com.example.nlonr.presenter.request;

import com.example.nlonr.entity.Goods;
import com.example.nlonr.entity.Login;
import com.example.nlonr.myinterface.bean.BaseObjectBean;
import com.example.nlonr.myinterface.bean.NewsChannelsBean;


import java.util.List;

import io.reactivex.Observable;

public interface Request {

     Observable<Login> login(String username, String password);

     Observable<BaseObjectBean<List<Goods>>> getGoods(String username, String password);

     Observable<NewsChannelsBean> getChannels(String username, String password);

}
