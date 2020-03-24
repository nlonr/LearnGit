package com.example.nlonr.presenter;

import com.example.nlonr.base.BasePresenter;
import com.example.nlonr.contract.FragmentContract;
import com.example.nlonr.entity.Goods;
import com.example.nlonr.bean.BaseArrayBean;
import com.example.nlonr.mylibrary.api.MyNetWorkApi;
import com.example.nlonr.mylibrary.observer.BaseObserver;
import com.example.nlonr.presenter.request.Request;
import com.example.nlonr.presenter.request.RequestFactory;

import java.util.List;

public class FragmentStatePresenter extends BasePresenter<FragmentContract.View> implements FragmentContract.GetGoods {

    public Request mRequest = RequestFactory.creator();

    @Override
    public List<Goods> getGoods(String username, String password) {
        mRequest.getGoods(username,password).compose(MyNetWorkApi.getInstance().applySchedulers(new BaseObserver<BaseArrayBean<List<Goods>>>() {

            @Override
            public void onSuccess(BaseArrayBean<List<Goods>> listBaseObjectBean) {

            }

            @Override
            public void onFailure(Throwable e) {

            }
        }));
        return null;
    }
}
