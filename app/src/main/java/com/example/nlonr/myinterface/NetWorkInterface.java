package com.example.nlonr.myinterface;

import com.example.nlonr.entity.Greeter;
import com.example.nlonr.myinterface.bean.NewsChannelsBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetWorkInterface {

    @GET("release/channel")
    Observable<NewsChannelsBean> getNewsChannels();

    @POST("release/channel")
    Observable<Greeter> getManyGreeter();
}
