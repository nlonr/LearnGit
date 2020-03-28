package com.example.nlonr.fragment;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nlonr.R;
import com.example.nlonr.adapter.FirstAdapter;
import com.example.nlonr.entity.Goods;
import com.example.nlonr.base.BaseLazyLoadFragment;
import com.example.nlonr.myself.MyDecoration;
import com.example.nlonr.myself.ToastCompat;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SecondFragment extends BaseLazyLoadFragment implements OnBannerListener {

    private SmartRefreshLayout smartRefresh;
    private RecyclerView recycleV;
    private Handler handler = new Handler();
    private List<Goods> list = new ArrayList<>();
    private Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    @Override
    protected int setLayoutId() {
        return R.layout.fragment_second;
    }

    @Override
    protected void init() {
        banner = (Banner) findViewById(R.id.banner);
        smartRefresh = (SmartRefreshLayout) findViewById(R.id.smart_refresh);
        recycleV = (RecyclerView) findViewById(R.id.recycle);
        smartRefresh.setReboundDuration(600);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recycleV.setLayoutManager(layoutManager);
        recycleV.addItemDecoration(new MyDecoration(Objects.requireNonNull(getActivity()), MyDecoration.VERTICAL_LIST));
        recycleV.addItemDecoration(new MyDecoration(Objects.requireNonNull(getActivity()), MyDecoration.HORIZONTAL_LIST));
        FirstAdapter adapter = new FirstAdapter(getActivity(), list);
        recycleV.setAdapter(adapter);

        smartRefresh();
        initBanner();
    }

    private void initBanner() {
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();

        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");

        list_title.add("好好学习");
        list_title.add("天天向上");
        list_title.add("热爱劳动");
        list_title.add("不搞对象");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();

    }

    @Override
    public void OnBannerClick(int position) {
        ToastCompat.showToast(getActivity(), "我是第 " + position + " 个图片", Toast.LENGTH_SHORT);
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).asBitmap().load((String) path).into(imageView);
        }
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

    private void smartRefresh() {
        // 只加载一次数据，避免界面切换的时候，加载数据多次
        smartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (list.size() < 10) {
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
                        if (list.size() < 10) {
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


}
