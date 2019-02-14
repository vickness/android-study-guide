package com.example.visen.studyapp.complex.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.visen.studyapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 重写 onCreateViewHolder ，onBindViewHolder，getItemCount
 * */
public class MyRecycleAdapter extends RecyclerView.Adapter {

    private LayoutInflater inflater;
    private ArrayList<HashMap<String, Object>> arrayList;

    /** 构造器*/
    public MyRecycleAdapter(Context context, ArrayList<HashMap<String, Object>> list) {
        this.inflater = LayoutInflater.from(context);
        this.arrayList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //绑定自定义视图
        View view = inflater.inflate(R.layout.item_list_type1, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //设置数据
        HashMap<String, Object> item = arrayList.get(i);
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.setItemData(item);
    }

    @Override
    public int getItemCount() {
        //设置数据长度
        return arrayList.size();
    }
}
