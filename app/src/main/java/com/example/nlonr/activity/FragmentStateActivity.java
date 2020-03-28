package com.example.nlonr.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.example.nlonr.R;
import com.example.nlonr.adapter.ViewPagerFragmentStateAdapter;
import com.example.nlonr.application.ActivityCollector;
import com.example.nlonr.base.BaseActivity;
import com.example.nlonr.contract.FragmentContract;
import com.example.nlonr.entity.Goods;
import com.example.nlonr.fragment.FirstFragment;
import com.example.nlonr.fragment.FourthFragment;
import com.example.nlonr.fragment.SecondFragment;
import com.example.nlonr.fragment.ThirdFragment;
import com.example.nlonr.utils.FragmentUtils;
import com.example.nlonr.presenter.FragmentStatePresenter;
import com.google.android.material.tabs.TabLayout;
import androidx.core.content.ContextCompat;
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
    private int show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置是否显示标题栏
//        setShowTitle(true);
        //设置是否显示状态栏
//        setShowStatusBar(true);

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

        mAdapter = new ViewPagerFragmentStateAdapter(this, fragments);
        mViewPager2.setAdapter(mAdapter);

        initOthers();
    }

    private void initOthers() {
        // 添加页签选中监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                show = tab.getPosition();
                Log.d("MyApp", "mTabLayout : " + show);
                if (view instanceof TextView) {
                    // 改变 tab 未选择状态下的字体大小
                    ((TextView) view).setTextSize(18);
                    // 改变 tab 未选择状态下的字体颜色
                    ((TextView) view).setTextColor(ContextCompat.getColor(FragmentStateActivity.this, R.color.black));
                }

                mViewPager2.setCurrentItem(tab.getPosition());
                FragmentUtils.showHideFragment(fm, fragments.get(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (view instanceof TextView) {
                    // 改变 tab 未选择状态下的字体大小
                    ((TextView) view).setTextSize(16);
                    // 改变 tab 未选择状态下的字体颜色
                    ((TextView) view).setTextColor(ContextCompat.getColor(FragmentStateActivity.this, R.color.black));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        // 注册页面变化的回调接口
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                Log.d("MyApp", "这是什么值：" + position + "   " + positionOffset + "   " + positionOffsetPixels);
//                int i = fragments.size() - 1;
//                if (positionOffsetPixels > 400) {
//                    onPageSelected(position + 1);
//                }
//
//                if (position == i) {
//                    i--;
//                    onPageSelected(position - 1);
//                    if (i == 0) {
//                        return;
//                    }
//                }
//            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                show = position;
                Log.d("MyApp", "mViewPager2 : " + position);
                mTabLayout.setScrollPosition(position, 0, false);
                Objects.requireNonNull(mTabLayout.getTabAt(position)).select();
                FragmentUtils.showHideFragment(fm, fragments.get(position));
            }
        });


    }

    //    @Override
//    protected void onResume() {
//        super.onResume();


//        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        assert activityManager != null;
//        int memorySize = activityManager.getMemoryClass();
//        Log.d("MyApp", "占用 " + memorySize + " 内存");

//    }

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
        fragments = null;
        ActivityCollector.removeActivity(this);
        Log.d("MyApp", "------ onDestroy ------");
    }

}






