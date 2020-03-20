package com.example.nlonr.contract;

import com.example.nlonr.base.BaseView;
import com.example.nlonr.entity.Login;
import com.example.nlonr.myinterface.bean.BaseObjectBean;
import com.example.nlonr.myinterface.bean.NewsChannelsBean;
import com.example.nlonr.mylibrary.observer.BaseObserver;

import io.reactivex.Flowable;

public interface MainContract {

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(Login bean);
    }

    interface Presenter {
        /**
         * 登陆
         *
         * @param username
         * @param password
         */
        void login(String username, String password);
    }
}
