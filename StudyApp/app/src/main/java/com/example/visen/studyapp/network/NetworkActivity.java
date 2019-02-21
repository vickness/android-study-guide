package com.example.visen.studyapp.network;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.visen.studyapp.R;
import com.example.visen.studyapp.base.BaseActivity;

import java.io.IOException;
import java.util.HashMap;

public class NetworkActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        //设置标题
        setActionBarTitle("网络请求");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sync_get:
                sync_get();
                break;
            case R.id.async_get:
                async_get();
                break;
            case R.id.sync_post:
                sync_post();
                break;
            case R.id.async_post:
                async_post();
                break;
            case R.id.download:
                download();
                break;
            case R.id.upload:
                upload();
                break;
        }
    }


    /** 同步GET请求*/
    private void sync_get() {

        //同步调用会阻塞主线程,这边在子线程进行
        new Thread(new Runnable() {

            @Override
            public void run() {

            }

        }).start();
    }


    /** 异步GET请求*/
    private void async_get() {

        HashMap<String, String> params = new HashMap<>();
        params.put("type", "1");
        params.put("page", "1");

        NetworkUtils utils = new NetworkUtils()
                .setHost("https://www.apiopen.top/")
                .setUrl("satinApi")
                .setParams(params);

        utils.get(new NetworkUtils.NetworkCallBack() {
            @Override
            public void completeBlock(NetworkResponse response) {

                try {
                    Log.d("aa", response.getData().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /** 同步POST请求*/
    private void sync_post() {

    }


    /** 异步POST请求*/
    private void async_post() {

        HashMap<String, String> params = new HashMap<>();
        params.put("type", "1");
        params.put("page", "1");

        new NetworkUtils()
                .setHost("https://www.apiopen.top/")
                .setUrl("satinApi")
                .setParams(params)
                .setBodyType(NetworkUtils.EnumBodyType.URLTYPE)
                .post(new NetworkUtils.NetworkCallBack() {
                    @Override
                    public void completeBlock(NetworkResponse response) {

                        try {
                            Log.d("aa", response.getData().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }


    /** 文件下载*/
    private void download() {

    }


    /** 文件上传*/
    private void upload() {

    }
}
