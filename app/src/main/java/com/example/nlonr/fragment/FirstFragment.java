package com.example.nlonr.fragment;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nlonr.R;
import com.example.nlonr.adapter.FirstAdapter;
import com.example.nlonr.entity.Goods;
import com.example.nlonr.base.BaseFragment;
import com.example.nlonr.myself.MyDecoration;
import com.example.nlonr.myself.ToastCompat;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FirstFragment extends BaseFragment implements View.OnClickListener {

    private SmartRefreshLayout smartRefresh;
    private RecyclerView recycleV;
    private Handler handler = new Handler();
    private List<Goods> list = new ArrayList<>();
    private TextView tvLeader;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    protected void init() {
        Log.d("MyApp", "这是FirstFragment ---> ");
        if (getArguments() != null) {
            getArguments().get("asd");
        }
        tvLeader = (TextView) findViewById(R.id.first_fragment_leader);

        smartRefresh = (SmartRefreshLayout) findViewById(R.id.smart_refresh);
        smartRefresh.setReboundDuration(600);
        recycleV = (RecyclerView) findViewById(R.id.recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycleV.setLayoutManager(layoutManager);
        recycleV.addItemDecoration(new MyDecoration(Objects.requireNonNull(getActivity()), MyDecoration.VERTICAL_LIST));
        FirstAdapter adapter = new FirstAdapter(getActivity(), list);
        recycleV.setAdapter(adapter);

        adapter.setOnItemClickListener(new FirstAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ToastCompat.showToast(getActivity(), "我是第 " + position + " 个item", Toast.LENGTH_SHORT);
            }
        });

        smartRefresh();
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

    @Override
    protected void initEvent() {
        tvLeader.setOnClickListener((View.OnClickListener) mContext);
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    private void smartRefresh() {
        // 只加载一次数据，避免界面切换的时候，加载数据多次
        smartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (list.size() < 15) {
                            loadMore();
                            smartRefresh.finishRefresh();
                        } else {
//                            Toast.makeText(getActivity(), "刷新完成！", Toast.LENGTH_SHORT);
                            ToastCompat.showToast(getActivity(), "刷新完成", Toast.LENGTH_SHORT);
                            smartRefresh.finishRefresh();
                        }
                    }
                });
            }
        });

        smartRefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (list.size() < 12) {
                            loadMore();
                            smartRefresh.finishLoadMore();
                        } else {
//                            Toast.makeText(getActivity(), "暂无可加载数据！", Toast.LENGTH_SHORT);
                            ToastCompat.showToast(getActivity(), "暂无可加载数据", Toast.LENGTH_SHORT);
                            smartRefresh.finishLoadMore();
                        }
                    }
                });
            }
        });

//        smartRefresh.autoRefresh();

    }

    private void loadMore() {
        Goods g5 = new Goods(R.mipmap.ic_launcher, "1", "123", "1857", "");
        Goods g6 = new Goods(R.mipmap.ic_launcher, "2", "123", "1857", "");
        Goods g7 = new Goods(R.mipmap.ic_launcher, "3", "123", "1857", "");

        list.add(g5);
        list.add(g6);
        list.add(g7);
        Objects.requireNonNull(recycleV.getAdapter()).notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDestroyView() {
        list = null;
        super.onDestroyView();
    }

}







