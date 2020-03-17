package com.example.nlonr.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.nlonr.R;
import com.example.nlonr.adapter.FirstAdapter;
import com.example.nlonr.entity.Goods;
import com.example.nlonr.myself.BaseFragment;
import com.example.nlonr.myself.BaseLazyLoadFragment;
import com.example.nlonr.myself.MyDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FirstFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recycleV;
    private Handler handler = new Handler();
    private List<Goods> list = new ArrayList<>();

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    protected void init() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        recycleV = (RecyclerView) findViewById(R.id.recycle);
        swipeRefreshLayout.setOnRefreshListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        //        瀑布流布局
//        val layoutManager1 = StaggeredGridLayoutManager(3, 1)
        //          网格布局
//        val layoutManager2 = GridLayoutManager(this, 2)
        recycleV.setLayoutManager(layoutManager);
        recycleV.addItemDecoration(new MyDecoration());
        FirstAdapter adapter = new FirstAdapter(getActivity(), list);
        recycleV.setAdapter(adapter);


    }

    @Override
    protected void loadData() {
        Goods g1 = new Goods(R.mipmap.ic_launcher, "1", "123", "1857", "");
        Goods g2 = new Goods(R.mipmap.ic_launcher, "2", "123", "1857", "22222222222");
        Goods g3 = new Goods(R.mipmap.ic_launcher, "3", "123", "1857", "123123123123123123");
        Goods g4 = new Goods(R.mipmap.ic_launcher, "4", "123", "1857", "");
        list.add(g1);
        list.add(g2);
        list.add(g3);
        list.add(g4);


//        onRefresh();
    }

    @Override
    public void onRefresh() {
        // 只加载一次数据，避免界面切换的时候，加载数据多次
//        if (recycleV.getAdapter() == null) {
            swipeRefreshLayout.setRefreshing(true);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Goods g5 = new Goods(R.mipmap.ic_launcher, "1", "123", "1857", "");
                    Goods g6 = new Goods(R.mipmap.ic_launcher, "2", "123", "1857", "");
                    Goods g7 = new Goods(R.mipmap.ic_launcher, "3", "123", "1857", "");
                    list.add(g5);
                    list.add(g6);
                    list.add(g7);
                    Objects.requireNonNull(recycleV.getAdapter()).notifyDataSetChanged();
                    swipeRefreshLayout.setRefreshing(false);
                }
            }, 1000);

//        }
    }


}







