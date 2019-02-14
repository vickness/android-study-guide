package com.example.visen.studyapp.thread;

import android.os.Bundle;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;

public class ThreadActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        //设置标题
        setActionBarTitle("多线程操作");
    }
}
