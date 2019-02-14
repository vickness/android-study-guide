package com.example.visen.studyapp.simple;

import android.os.Bundle;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;

public class SimpleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        //设置标题
        setActionBarTitle("基础组件");
    }
}
