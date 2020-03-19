package com.example.nlonr.fragment;

import android.os.Handler;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.nlonr.R;
import com.example.nlonr.adapter.FirstAdapter;
import com.example.nlonr.entity.Goods;
import com.example.nlonr.myself.BaseFragment;
import com.example.nlonr.myself.MyDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FourthFragment extends BaseFragment  {

    private SmartRefreshLayout swipeRefreshLayout;
    private RecyclerView recycleV;
    private Handler handler = new Handler();
    private List<Goods> list = new ArrayList<>();

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    protected void init() {
        swipeRefreshLayout = (SmartRefreshLayout) findViewById(R.id.smart_refresh);
        recycleV = (RecyclerView) findViewById(R.id.recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        //        瀑布流布局
//        val layoutManager1 = StaggeredGridLayoutManager(3, 1)
        //          网格布局
//        val layoutManager2 = GridLayoutManager(this, 2)
        recycleV.setLayoutManager(layoutManager);
        recycleV.addItemDecoration(new MyDecoration(Objects.requireNonNull(getActivity()), MyDecoration.VERTICAL_LIST));
        FirstAdapter adapter = new FirstAdapter(getActivity(), list);
        recycleV.setAdapter(adapter);
        Log.d("MyApp", "这是第一个fragment");


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



    }


}
