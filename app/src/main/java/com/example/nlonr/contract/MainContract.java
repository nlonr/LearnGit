package com.example.nlonr.contract;

import com.example.nlonr.base.BaseView;
import com.example.nlonr.entity.Login;

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
         * @param username
         * @param password
         */
        void login(String username, String password);

    }
}
