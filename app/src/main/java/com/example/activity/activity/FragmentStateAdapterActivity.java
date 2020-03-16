package com.example.activity.activity;

import android.os.Bundle;

import com.example.activity.R;
import com.example.activity.adapter.ViewPagerFragmentStateAdapter;
import com.example.activity.fragment.FirstFragment;
import com.example.activity.utils.FragmentUtils;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;


public class FragmentStateAdapterActivity extends AppCompatActivity {

    private ViewPager2 mViewPager2;
    private TabLayout mTabLayout;
    private List<Fragment> fragments = new ArrayList<>();
    private Fragment first,second,third,forth;
    private ViewPagerFragmentStateAdapter mAdapter;
    private FragmentManager fm;

    {
        first = new FirstFragment();
        fragments.add(first);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        init();
    }

    private void init() {
        fm = getSupportFragmentManager();
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.vp);
        mAdapter = new ViewPagerFragmentStateAdapter(this, fragments);
        mViewPager2.setAdapter(mAdapter);
        mViewPager2.setOffscreenPageLimit(2);
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab0"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab3"));
        // 添加页签选中监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager2.setCurrentItem(tab.getPosition());
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
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentUtils.showHideFragment(fm,first);


    }
}






