package com.example.nlonr.myinterface;

import com.example.nlonr.entity.Login;
import com.example.nlonr.myinterface.bean.NewsChannelsBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetWorkInterface {

    @GET("release/channel")
    Observable<Login> login(String name, String pass);

    @GET("release/channel")
    Observable<NewsChannelsBean> getNewsChannels();


}
