package com.example.nlonr.base;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;

public abstract class BaseLazyLoadFragment extends BaseFragment {
    /**
     * 是否已经初始化结束
     */
    private boolean isPrepare;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setLazyLoad(true);
        isPrepare = true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isPrepare = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isPrepare) {
            // 将数据加载逻辑放到onResume()方法中
            loadData();
            init();
            isPrepare = false;
        }
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        // 显示状态发生变化
        onVisibleToUser();
    }

    /**
     * 判断是否需要加载数据
     */
    private void onVisibleToUser() {
        // 如果已经初始化完成，并且显示给用户
        if (isPrepare && getUserVisibleHint()) {
            loadData();
        }
    }

}
