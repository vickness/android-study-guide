package com.example.visen.studyapp.complex.viewpager.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.visen.studyapp.R;

import java.util.ArrayList;

public class SimpleAdapter extends PagerAdapter {

    ArrayList<String> arrayList;
    private LayoutInflater inflater;

    /** 构造器*/
    public SimpleAdapter(Context context, ArrayList<String> list) {
        arrayList = list;
        inflater = LayoutInflater.from(context);
    }

    /** 返回页数*/
    @Override
    public int getCount() {
        return arrayList.size();
    }

    /** 创建指定位置的页面视图*/
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //创建视图
        View view = inflater.inflate(R.layout.view_page, container, false);
        TextView textView = view.findViewById(R.id.page_text);

        //设置文字内容
        String text = arrayList.get(position);
        textView.setText(text);

        //加入缓存并返回
        container.addView(view);
        return view;
    }

    /** 销毁指定位置的视图*/
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        //移除缓存
        container.removeView((View) object);
    }


    /********************** 以下方法可选***********************/
    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    /** 代表了当前的页面是否与给定的键相关联*/
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    /** 该方法由ViewPager在获取描述页面的标题时调用。该方法默认返回null。*/
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    /** 该方法返回给定页面的比例宽度，范围(0.f-1.f]。*/
    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }


    /** 在展示的界面中有改变将要发生时调用*/
    @Override
    public void startUpdate(@NonNull ViewGroup container) {
        super.startUpdate(container);
    }

    /** 展示界面中的改变完成时调用。在这个时间点上，你必须确保所有的页面已被合适的从container中添加或移除。*/
    @Override
    public void finishUpdate(@NonNull ViewGroup container) {
        super.finishUpdate(container);
    }

    /** 该方法由应用程序在适配器数据改变时主动调用*/
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    /** 保存与适配器关联的实例状态，当当前UI状态需要重建时恢复*/
    @Nullable
    @Override
    public Parcelable saveState() {
        return super.saveState();
    }

    /** 恢复之前由saveState ()保存的与适配器关联的实例状态*/
    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
        super.restoreState(state, loader);
    }
}
