package com.example.nlonr.presenter.request;

import com.example.nlonr.entity.Goods;
import com.example.nlonr.entity.Login;
import com.example.nlonr.bean.BaseArrayBean;
import com.example.nlonr.bean.NewsChannelsBean;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Request {

     @GET("release/channel")
     Observable<Login> login(String username, String password);

     @GET("release/channel")
     Observable<BaseArrayBean<List<Goods>>> getGoods(String username, String password);

     @GET("release/channel")
     Observable<NewsChannelsBean> getChannels(String username, String password);

}
