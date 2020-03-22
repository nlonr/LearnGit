package com.example.nlonr.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.nlonr.R;
import com.example.nlonr.base.BaseActivity;
import com.example.nlonr.contract.LoginContract;
import com.example.nlonr.entity.Login;
import com.example.nlonr.myself.ToastCompat;
import com.example.nlonr.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private Button btnLogin;
    private LoginPresenter mPresenter = new LoginPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //设置是否显示标题栏
        setShowTitle(true);
        //设置是否显示状态栏
        setShowStatusBar(true);
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        btnLogin = findViewById(R.id.btn_login);

        setListeners();
    }

    @Override
    protected void initData() {
        ImageView img = new ImageView(this);
        getCacheFile("http:\\www.baidu.com\\0152000891000212.jpg", img);
    }


    @Override
    protected void setListeners() {
        btnLogin.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                mPresenter.login("ll", "123456");
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onSuccess(Login bean) {
        if (bean.getStatus().equals("1")) {
            ToastCompat.showToast(this, "登陆成功", Toast.LENGTH_SHORT);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter = null;
    }


}
