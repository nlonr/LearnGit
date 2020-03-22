package com.example.nlonr.contract;

import com.example.nlonr.base.BaseView;
import com.example.nlonr.entity.Goods;

import java.util.List;

public interface FragmentContract{

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(Throwable throwable);

        void onSuccess(List<Goods> bean);
    }

    interface GetGoods{
        /**
         * 获取列表
         * @param username
         * @param password
         * @return
         */
        List<Goods> getGoods(String username, String password);
    }


}
