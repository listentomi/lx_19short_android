package com.example.chapter3.homework;

import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
/**
 * 使用 ViewPager 和 Fragment 做一个简单版的好友列表界面
 * 1. 使用 ViewPager 和 Fragment 做个可滑动界面
 * 2. 使用 TabLayout 添加 Tab 支持
 * 3. 对于好友列表 Fragment，使用 Lottie 实现 Loading 效果，在 5s 后展示实际的列表，要求这里的动效是淡入淡出
 */
public class Ch3Ex3Activity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4, view5;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private List<String> listTitles;
    private List<Fragment> fragments;
    private List<TextView> listTextViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch3ex3);

        // TODO: ex3-1. 添加 ViewPager 和 Fragment 做可滑动界面
        //      FragmentManager manager = getSupportFragmentManager();
        // FragmentTransaction transaction = manager.beginTransaction();
        // transaction.add(R.id.,new PlaceholderFragment());

        mViewPager = (ViewPager) findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        initData();
        // TODO: ex3-2, 添加 TabLayout 支持 Tab
    }
        private void initData(){
            listTitles = new ArrayList<>();
            fragments = new ArrayList<>();
            listTextViews = new ArrayList<>();
            listTitles.add("One");
            listTitles.add("Two");
            listTitles.add("Three");
            listTitles.add("Four");
            for (int i = 0; i < listTitles.size(); i++) {
                PlaceholderFragment fragment = PlaceholderFragment.newInstance(listTitles.get(i));
                fragments.add(fragment);
            }
            //mTabLayout.setTabMode(TabLayout.SCROLL_AXIS_HORIZONTAL);//设置tab模式，当前为系统默认模式
            for (int i = 0; i < listTitles.size(); i++) {
                mTabLayout.addTab(mTabLayout.newTab().setText(listTitles.get(i)));//添加tab选项
            }

            FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return fragments.get(position);
                }
                @Override
                public int getCount() {
                    return fragments.size();
                }
                //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
                @Override
                public CharSequence getPageTitle(int position) {
                    return listTitles.get(position);
                }
            };
            mViewPager.setAdapter(mAdapter);
            mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
           // mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
        }
}

