package com.example.visen.studyapp.complex.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.visen.studyapp.R;

import java.util.HashMap;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public ImageView itemIcon;
    public TextView itemTitle;
    public TextView itemDetail;
    public Button itemButton;

    /** 构造器，传入视图并绑定变量*/
    public MyViewHolder(View itemView) {
        super(itemView);

        itemIcon = itemView.findViewById(R.id.itemIcon);
        itemTitle = itemView.findViewById(R.id.itemTitle);
        itemDetail = itemView.findViewById(R.id.itemDetail);
        itemButton = itemView.findViewById(R.id.itemBtn);
    }

    /** 设置对应的数据*/
    public void setItemData(HashMap<String, Object> item) {

        itemIcon.setImageResource(R.drawable.ic_launcher_foreground);
        itemTitle.setText(item.get("itemTitle").toString());
        itemDetail.setText(item.get("itemDetail").toString());
    }
}
