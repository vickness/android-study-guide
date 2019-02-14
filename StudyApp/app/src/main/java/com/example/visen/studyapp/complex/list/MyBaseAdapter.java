package com.example.visen.studyapp.complex.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.visen.studyapp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 继承BaseAdapter之后，需要重写以下四个方法：getCount，getItem，getItemId，getView。
 * */
public class MyBaseAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<HashMap<String, Object>> arrayList;

    public MyBaseAdapter(Context context, ArrayList<HashMap<String, Object>> list) {
        this.arrayList = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //加载布局为一个视图
        View view = inflater.inflate(R.layout.item_list_type2,null);
        HashMap<String, Object> item = arrayList.get(position);

        //在view视图中根据ID查找对应的控件
        ImageView itemIcon1 = view.findViewById(R.id.itemIcon1);
        ImageView itemIcon2 = view.findViewById(R.id.itemIcon2);
        ImageView itemIcon3 = view.findViewById(R.id.itemIcon3);
        TextView itemTitle = view.findViewById(R.id.itemTitle);
        TextView itemDetail = view.findViewById(R.id.itemDetail);

        //设置对应的值
        itemIcon1.setImageResource(R.drawable.ic_launcher_foreground);
        itemIcon2.setImageResource(R.drawable.ic_launcher_foreground);
        itemIcon3.setImageResource(R.drawable.ic_launcher_foreground);

        itemTitle.setText(item.get("itemTitle").toString());
        itemDetail.setText(item.get("itemDetail").toString());

        return view;
    }
}
