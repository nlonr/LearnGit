package com.example.nlonr.contract;

import com.example.nlonr.base.BaseView;

public interface LoginContract {

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(com.example.nlonr.entity.Login bean);
    }

    interface Login{
        void login(String username, String password);
    }


}
