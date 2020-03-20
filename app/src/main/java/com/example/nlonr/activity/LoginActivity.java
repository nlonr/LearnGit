package com.example.nlonr.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nlonr.R;
import com.example.nlonr.contract.MainContract;
import com.example.nlonr.entity.Login;
import com.example.nlonr.myinterface.bean.BaseObjectBean;
import com.example.nlonr.myself.ToastCompat;
import com.example.nlonr.presenter.MyPresenter;
import com.uber.autodispose.AutoDisposeConverter;

public class LoginActivity extends AppCompatActivity implements MainContract.View {

    MyPresenter mPresenter = new MyPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.login("ll","123456");
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
    public <T> AutoDisposeConverter<T> bindAutoDispose() {
        return null;
    }

    @Override
    public void onSuccess(Login bean) {
        if(bean.getStatus().equals("1")){
            ToastCompat.showToast(this,"登陆成功", Toast.LENGTH_SHORT);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
