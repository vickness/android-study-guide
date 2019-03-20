package com.example.visen.studyapp.complex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;
import com.example.visen.studyapp.complex.banner.BannerActivity;
import com.example.visen.studyapp.complex.collapsing.CollapsingActivity;
import com.example.visen.studyapp.complex.list.ListViewActivity;
import com.example.visen.studyapp.complex.recycler.RecyclerViewActivity;
import com.example.visen.studyapp.complex.refresh.RefreshActivity;
import com.example.visen.studyapp.complex.viewpager.ViewPagerActivity;

import java.util.ArrayList;

public class ComplexActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);

        //设置标题
        setActionBarTitle("高级组件");

        //创建数组
        ArrayList<String> list = new ArrayList<>();
        list.add("ListView");
        list.add("RecyclerView");
        list.add("SmartRefreshLayout");
        list.add("Banner");
        list.add("ViewPager");
        list.add("CollapsingToolbarLayout");

        ListView listView = findViewById(R.id.complex_list);

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
                        intent.setClass(ComplexActivity.this, ListViewActivity.class);
                        break;
                    case 1:
                        intent.setClass(ComplexActivity.this, RecyclerViewActivity.class);
                        break;
                    case 2:
                        intent.setClass(ComplexActivity.this, RefreshActivity.class);
                        break;
                    case 3:
                        intent.setClass(ComplexActivity.this, BannerActivity.class);
                        break;
                    case 4:
                        intent.setClass(ComplexActivity.this, ViewPagerActivity.class);
                        break;
                    case 5:
                        intent.setClass(ComplexActivity.this, CollapsingActivity.class);
                        break;
                }

                //启动新的Activity
                startActivity(intent);
            }
        });
    }
}
