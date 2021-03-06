package com.example.nlonr.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.nlonr.R;
import com.example.nlonr.base.BaseActivity;
import com.example.nlonr.contract.LoginContract;
import com.example.nlonr.entity.Login;
import com.example.nlonr.entity.Person;
import com.example.nlonr.myself.ToastCompat;
import com.example.nlonr.presenter.LoginPresenter;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    private Button btnLogin;
    private LoginPresenter mPresenter = new LoginPresenter();
    private BasePopupView popupView;
    private List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //设置是否显示标题栏
        setShowTitle(true);
        //设置是否显示状态栏
        setShowStatusBar(true);
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);

        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new String("她付钱了可以过去"));



    }

    @Override
    protected int initLayout() {
        if (!isPad(this)) {
            return R.layout.activity_login;
        } else {
            return R.layout.activity_login;
        }
    }

    @Override
    public void onTrimMemory(int level) {


        super.onTrimMemory(level);
    }

    @Override
    protected void initView() {
        btnLogin = findViewById(R.id.btn_login);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventBusMsg(String event) {
        switch (event) {
            case "她付钱了可以过去":
                ToastCompat.showToast(this, "谢谢惠顾", Toast.LENGTH_SHORT);
                break;

        }

    }

    @Override
    protected void initData() {

        for (int i = 0; i < 100; i++) {
            Person person = Person.getPerson();
            person.setAge(120);
            person.setName("袁隆平");
            personList.add(person);
        }

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
        popupView = new XPopup.Builder(this).asLoading("正在加载中").show();
    }

    @Override
    public void hideLoading() {
        popupView.dismiss();
        popupView.delayDismiss(200);
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
        mPresenter.detachView();
        mPresenter = null;
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }


}
