package com.example.visen.studyapp.complex.list;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewActivity extends BaseActivity {

    private ListView listView;

    private ArrayList<HashMap<String, Object>> simpleItems;

    private ArrayList<String> arrayItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //设置标题
        setActionBarTitle("ListView 用法");

        //获取ListView
        listView = findViewById(R.id.base_listView);

        //绑定点击方法
        RadioGroup radioGroup = findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(onCheckedChanged());

        /*定义一个HashMap动态数组*/
        simpleItems = new ArrayList<>();
        /*在数组中存放数据*/
        for(int i=0; i<50; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("itemIcon", R.drawable.ic_launcher_foreground);//加入图片
            map.put("itemTitle", "第"+i+"行");
            map.put("itemDetail", "这是第"+i+"行");
            simpleItems.add(map);
        }

        //创建字符串动态数组
        arrayItems = new ArrayList<>();
        /*在数组中存放数据*/
        for(int i=0; i<50; i++) {
            arrayItems.add("第"+i+"行");
        }

        //默认选择第一种
        //创建ArrayAdapter适配器，只能返回一行文字
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item_main, arrayItems);
        //设置适配器
        listView.setAdapter(adapter);
    }

    /** 选择适配器类型*/
    private RadioGroup.OnCheckedChangeListener onCheckedChanged() {

        return new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioBtn1:
                    {
                        //创建ArrayAdapter适配器，只能返回一行文字
                        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListViewActivity.this, R.layout.item_main, arrayItems);
                        //设置适配器
                        listView.setAdapter(adapter);
                    }
                    break;
                    case R.id.radioBtn2:
                    {
                        //将被添加到Map映射上的key
                        String[] keys = {"itemIcon", "itemTitle", "itemDetail"};
                        //将绑定数据的视图的ID跟from参数对应，这些被绑定的视图元素应该全是TextView
                        int[] ids = {R.id.itemIcon, R.id.itemTitle, R.id.itemDetail};

                        //创建SimpleAdapter适配器，能返回多种组件
                        SimpleAdapter adapter = new SimpleAdapter(ListViewActivity.this, simpleItems, R.layout.item_list_type1, keys, ids);
                        //设置适配器
                        listView.setAdapter(adapter);
                    }
                    break;
                    case R.id.radioBtn3:
                    {
                        //创建MyBaseAdapter适配器
                        MyBaseAdapter adapter = new MyBaseAdapter(ListViewActivity.this, simpleItems);
                        listView.setAdapter(adapter);
                    }
                    break;
                }
            }
        };

    }
}
