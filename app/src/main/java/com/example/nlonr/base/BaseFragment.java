package com.example.nlonr.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    /**
     * 布局id
     */
    private View contentView;
    public Context mContext;

    /**
     * 是否启用懒加载，此属性仅对BaseLazyLoadFragment有效
     * */
    private boolean isFirst = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(setLayoutId(), container, false);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 初始化
        init();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirst) {
            loadData();
            initEvent();
            isFirst = true;
        }

    }

    /**
     * 设置加载的布局Id
     */
     protected abstract int setLayoutId();

    /**
     * 初始化操作
     */
     protected abstract void init();

    /**
     * findViewById
     */
    protected View findViewById(int id) {
        return contentView.findViewById(id);
    }

    /**
     * 懒加载数据
     */
     protected abstract void loadData();

    /**
     * 点击事件
     */
    protected abstract void initEvent();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isFirst = true;
    }


}
