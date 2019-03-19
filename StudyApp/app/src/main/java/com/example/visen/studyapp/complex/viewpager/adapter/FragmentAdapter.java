package com.example.visen.studyapp.complex.viewpager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.example.visen.studyapp.complex.viewpager.view.SubFragment;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentPagerAdapter {

    ArrayList<String> arrayList;

    /** 构造器*/
    public FragmentAdapter(FragmentManager fm, ArrayList<String> list) {
        super(fm);
        arrayList = list;
    }

    /** 返回数量*/
    @Override
    public int getCount() {
        return arrayList.size();
    }

    /** FragmentPagerAdapter会将所有生成的 Fragment 对象通过 FragmentManager 保存起来备用，
     * 以后需要该 Fragment 时，都会从 FragmentManager 读取，
     * 而不会再次调用 getItem() 方法。该方法只有在创建新的Fragment时才调用。
     * */
    @Override
    public Fragment getItem(int i) {
        String text = arrayList.get(i);
        return SubFragment.newInstance(text, String.valueOf(i));
    }

    /** 超出缓存的页面，将调用该方法从视图中移除。*/
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }


    /********************* 以下方法可选************************/
    /** 返回标题*/
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String text = arrayList.get(position);
        return text;
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
