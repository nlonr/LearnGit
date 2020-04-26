package com.example.nlonr.activity;

import android.util.Log;
import com.example.nlonr.R;
import com.example.nlonr.base.BaseActivity;
import com.example.nlonr.utils.GsonUtil;

import java.util.HashMap;
import java.util.Map;

public class GoodsActivity extends BaseActivity {

    Map<String,String> map = new HashMap<>();

    @Override
    protected int initLayout() {
        return R.layout.activity_goods;
    }

    @Override
    protected void initView() {

        map.put("Zhang_Qiang","123456");

        GsonUtil.toJson(map);

    }


    private String getPhone(){

        int[] num = {0, 1, 2, 3, 4, 5, 8, 9};
        int[] index = {1, 6, 4, 0, 1, 5, 5, 2, 5, 7, 0};
        String phone = "";
        for (int i = 0; i < index.length; i++) {
            phone += num[index[i]];
        }
        Log.d("MyApp", phone);

        return phone;
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void initData() {

    }
}
