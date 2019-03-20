package com.example.visen.studyapp.complex.collapsing;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toolbar;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;
import com.example.visen.studyapp.complex.recycler.MyRecycleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class CollapsingActivity extends BaseActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);

        //得到当前界面的装饰视图
        if(Build.VERSION.SDK_INT >= 21) {

            //设置全屏模式
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            //设置状态栏颜色为透明
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        // 隐藏当前Activity的标题
        getSupportActionBar().hide();//隐藏标题栏

    }
}
