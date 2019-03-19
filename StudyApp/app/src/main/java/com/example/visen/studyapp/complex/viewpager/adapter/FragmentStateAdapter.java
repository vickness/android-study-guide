package com.example.visen.studyapp.complex.viewpager.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentStateAdapter extends FragmentStatePagerAdapter {

    /** 构造器*/
    public FragmentStateAdapter(FragmentManager fm) {
        super(fm);
    }

    /** 返回Fragment*/
    @Override
    public Fragment getItem(int i) {
        return null;
    }

    /** 返回数量*/
    @Override
    public int getCount() {
        return 0;
    }

    /** 返回标题*/
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
