package com.ubin.android_gubinmall;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.ubin.android_gubinmall.bean.Tab;
import com.ubin.android_gubinmall.widget.CartFragment;
import com.ubin.android_gubinmall.widget.CategoryFragment;
import com.ubin.android_gubinmall.widget.HomeFragment;
import com.ubin.android_gubinmall.widget.HotFragment;
import com.ubin.android_gubinmall.widget.MineFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {

        private FragmentTabHost mTabhost;
        private LayoutInflater mInflater;
        private List<Tab> mTabs = new ArrayList<Tab>(5);

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

//            mInflater = LayoutInflater.from(this);
//            mTabhost = this.findViewById(android.R.id.tabhost);
//            mTabhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
//
//            View view = mInflater.inflate(R.layout.tab_indicator,null);
//            ImageView img = view.findViewById(R.id.icon_tab);
//            TextView text = view.findViewById(R.id.txt_indicator);
//
//            TabHost.TabSpec tabSpec = mTabhost.newTabSpec("主页");
//
//            img.setBackgroundResource(R.mipmap.icon_home);
//            text.setText("主页");
//
//            mTabhost.addTab(tabSpec,HomeFragment.class,null);

            initTab();
        }

        private void initTab(){
            Tab tab_home = new Tab(R.string.home,R.drawable.slector_icon_home,HomeFragment.class);
            Tab tab_hot = new Tab(R.string.hot,R.drawable.selector_icon_hot,HotFragment.class);
            Tab tab_category = new Tab(R.string.category,R.drawable.selector_icon_category, CategoryFragment.class);
            Tab tab_cart = new Tab(R.string.cart,R.drawable.selector_icon_cart,CartFragment.class);
            Tab tab_mine = new Tab(R.string.mine,R.drawable.selector_icon_mine,MineFragment.class);

            mTabs.add(tab_home);
            mTabs.add(tab_hot);
            mTabs.add(tab_category);
            mTabs.add(tab_cart);
            mTabs.add(tab_mine);

            mInflater = LayoutInflater.from(this);
            mTabhost = this.findViewById(android.R.id.tabhost);
            mTabhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);

            for (Tab tab:mTabs){
                TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));

                tabSpec.setIndicator(buildIndicator(tab));

                mTabhost.addTab(tabSpec,tab.getFragment(),null);
            }

            //去除分割线
            mTabhost.getTabWidget().setShowDividers((LinearLayout.SHOW_DIVIDER_NONE));
            mTabhost.setCurrentTab(0);
        }

        private View buildIndicator(Tab tab){

            View view = mInflater.inflate(R.layout.tab_indicator,null);
            ImageView img = view.findViewById(R.id.icon_tab);
            TextView text = view.findViewById(R.id.txt_indicator);

            img.setBackgroundResource(tab.getIcon());
            text.setText(tab.getTitle());

            return view;
        }
}

