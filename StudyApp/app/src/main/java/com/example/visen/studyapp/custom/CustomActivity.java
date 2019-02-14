package com.example.visen.studyapp.custom;

import android.os.Bundle;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;

public class CustomActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        //设置标题
        setActionBarTitle("自定义组件");
    }
}
