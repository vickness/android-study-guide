package com.example.visen.studyapp.network;

import android.os.Bundle;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;

public class NetworkActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        //设置标题
        setActionBarTitle("网络请求");
    }
}
