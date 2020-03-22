package com.example.nlonr.presenter;

import com.example.nlonr.base.BasePresenter;
import com.example.nlonr.contract.MainContract;
import com.example.nlonr.entity.Login;
import com.example.nlonr.mylibrary.api.MyNetWorkApi;
import com.example.nlonr.mylibrary.observer.BaseObserver;
import com.example.nlonr.presenter.request.Request;
import com.example.nlonr.presenter.request.RequestFactory;

public class MyPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    Request mRequest = RequestFactory.creator();

    @Override
    public void login(String username, String password) {
        if (!isViewAttached()) {
            return;
        }
        mView.showLoading();
        mRequest.login(username, password).compose(MyNetWorkApi.getInstance().applySchedulers(new BaseObserver<Login>() {
            @Override
            public void onSuccess(Login login) {
                mView.onSuccess(login);
                mView.hideLoading();
            }

            @Override
            public void onFailure(Throwable e) {
                mView.onError(e);
                mView.hideLoading();
            }
        }));

    }

//    private Activity activity;
//
//    public MyPresenter(Activity activity){
//        this.activity = activity;
//    }
//    Request mRequest = RequestFactory.creator();
//    Activity act = ActivityFactory.creator(activity);
//
//    public Observable<Login> login(String username, String password) {
//
//       return mRequest.login(username, password).compose(MyNetWorkApi.getInstance().applySchedulers(new BaseObserver<Login>() {
//           @Override
//           public void onSuccess(Login login) {
//               act.onSuccess(login);
//           }
//           @Override
//           public void onFailure(Throwable e) {
//
//           }
//       }));


}

