package com.example.visen.studyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.visen.studyapp.complex.ComplexActivity;
import com.example.visen.studyapp.custom.CustomActivity;
import com.example.visen.studyapp.network.NetworkActivity;
import com.example.visen.studyapp.simple.SimpleActivity;
import com.example.visen.studyapp.storage.StorageActivity;
import com.example.visen.studyapp.thread.ThreadActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建数组
        ArrayList<String> list = new ArrayList<>();
        list.add("基础组件");
        list.add("高级组件");
        list.add("自定义组件");
        list.add("数据缓存");
        list.add("网络请求");
        list.add("多线程");

        //根据ID获取ListView组件
        ListView listView = findViewById(R.id.listView);

        //创建适配器
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.item_main, list);

        //设置适配器
        listView.setAdapter(adapter);

        //设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //创建意图
                Intent intent = new Intent();

                switch (position) {
                    case 0:
                        intent.setClass(MainActivity.this, SimpleActivity.class);
                        break;
                    case 1:
                        intent.setClass(MainActivity.this, ComplexActivity.class);
                        break;
                    case 2:
                        intent.setClass(MainActivity.this, CustomActivity.class);
                        break;
                    case 3:
                        intent.setClass(MainActivity.this, StorageActivity.class);
                        break;
                    case 4:
                        intent.setClass(MainActivity.this, NetworkActivity.class);
                        break;
                    case 5:
                        intent.setClass(MainActivity.this, ThreadActivity.class);
                        break;
                }

                //启动新的Activity
                startActivity(intent);
            }
        });
    }
}
