package com.example.nlonr.activity;

import android.os.Bundle;
import android.util.Log;

import com.example.nlonr.R;
import com.example.nlonr.adapter.ViewPagerFragmentStateAdapter;
import com.example.nlonr.base.BaseActivity;
import com.example.nlonr.contract.FragmentContract;
import com.example.nlonr.entity.Goods;
import com.example.nlonr.fragment.FirstFragment;
import com.example.nlonr.fragment.FourthFragment;
import com.example.nlonr.fragment.SecondFragment;
import com.example.nlonr.fragment.ThirdFragment;
import com.example.nlonr.mylibrary.FragmentUtils;
import com.example.nlonr.presenter.FragmentStatePresenter;
import com.example.nlonr.presenter.LoginPresenter;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class FragmentStateActivity extends BaseActivity implements FragmentContract.View {

    private ViewPager2 mViewPager2;
    private TabLayout mTabLayout;
    private List<Fragment> fragments = new ArrayList<>();
    private Fragment first, second, third, forth;
    private ViewPagerFragmentStateAdapter mAdapter;
    private FragmentManager fm;
    private FragmentStatePresenter mPresenter = new FragmentStatePresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置是否显示标题栏
        setShowTitle(true);
        //设置是否显示状态栏
        setShowStatusBar(true);
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_second;
    }

    @Override
    protected void initView() {
        fm = getSupportFragmentManager();
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.vp);
        mViewPager2.setOffscreenPageLimit(2);

        mTabLayout.addTab(mTabLayout.newTab().setText("关注"));
        mTabLayout.addTab(mTabLayout.newTab().setText("推荐"));
        mTabLayout.addTab(mTabLayout.newTab().setText("抗击新肺炎"));
        mTabLayout.addTab(mTabLayout.newTab().setText("视频"));

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void initData() {
        first = new FirstFragment();
        second = new SecondFragment();
        third = new ThirdFragment();
        forth = new FourthFragment();
        fragments.add(first);
        fragments.add(second);
        fragments.add(third);
        fragments.add(forth);

        initOthers();
    }

    private void initOthers() {
        Log.d("MyApp", "这是fragmentActivity ---> initOthers()");
        mAdapter = new ViewPagerFragmentStateAdapter(this, fragments);
        mViewPager2.setAdapter(mAdapter);


        // 添加页签选中监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager2.setCurrentItem(tab.getPosition());
                FragmentUtils.showHideFragment(fm, fragments.get(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        // 注册页面变化的回调接口
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mTabLayout.setScrollPosition(position, 0, false);
                Objects.requireNonNull(mTabLayout.getTabAt(position)).select();
                FragmentUtils.showHideFragment(fm, fragments.get(position));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MyApp", "这是fragmentActivity ---> onResume");

        new FragmentStatePresenter().getGoods("ll", "123456");


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
    public void onSuccess(List<Goods> bean) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
        mPresenter = null;

    }
}






