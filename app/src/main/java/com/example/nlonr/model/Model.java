package com.example.nlonr.model;

import com.example.nlonr.entity.Goods;
import com.example.nlonr.entity.Login;
import com.example.nlonr.bean.BaseArrayBean;
import com.example.nlonr.bean.NewsChannelsBean;
import com.example.nlonr.mylibrary.api.MyNetWorkApi;
import com.example.nlonr.presenter.request.Request;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.Body;

public class Model implements Request {

    @Override
    public Observable<Login> login(String username, String password) {
        return MyNetWorkApi.getService(Request.class).login(username, password);
    }

    @Override
    public Observable<BaseArrayBean<List<Goods>>> getGoods(String username, String password) {
        return MyNetWorkApi.getService(Request.class).getGoods(username, password);
    }

    @Override
    public Observable<NewsChannelsBean> getChannels(@Body Login vo) {
        return MyNetWorkApi.getService(Request.class).getChannels(vo);
    }


}





