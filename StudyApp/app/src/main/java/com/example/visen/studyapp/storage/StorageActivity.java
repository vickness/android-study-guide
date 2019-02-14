package com.example.visen.studyapp.storage;

import android.os.Bundle;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;

public class StorageActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        //设置标题
        setActionBarTitle("数据存储");
    }
}
