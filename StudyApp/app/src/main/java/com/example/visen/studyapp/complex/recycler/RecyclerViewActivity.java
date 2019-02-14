package com.example.visen.studyapp.complex.recycler;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        //设置标题
        setActionBarTitle("RecyclerView 用法");

        //获取recyclerView
        recyclerView = findViewById(R.id.recyclerView);

        //创建布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局方向
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置管理器
        recyclerView.setLayoutManager(layoutManager);

        //设置分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


        /*定义一个HashMap动态数组*/
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        /*在数组中存放数据*/
        for(int i=0; i<50; i++) {

            HashMap<String, Object> map = new HashMap<>();
            map.put("itemTitle", "第"+i+"行");
            map.put("itemDetail", "这是第"+i+"行");
            arrayList.add(map);
        }

        //创建适配器
        MyRecycleAdapter recycleAdapter = new MyRecycleAdapter(this, arrayList);
        recyclerView.setAdapter(recycleAdapter);
    }
}
