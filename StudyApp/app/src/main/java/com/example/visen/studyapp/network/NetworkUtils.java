package com.example.visen.studyapp.network;

import okhttp3.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/** 网络请求工具*/
public class NetworkUtils {

    private OkHttpClient okHttpClient;
    /** 主机域名*/
    private String host;
    /** 请求地址*/
    private String defaultUrl;
    /** 请求头*/
    private HashMap<String, String> defaultHeaders;
    /** 请求体*/
    private HashMap<String, String> params;
    /** 数据类型*/
    private EnumBodyType bodyType;
    /** 上传文件列表*/
    private ArrayList<NetworkFileData> fileItems;


    /** 定义请求回调接口*/
    public interface NetworkCallBack {
        /** 请求结束*/
        void completeBlock(NetworkResponse response);
    }

    /** 定义枚举类型*/
    public enum EnumBodyType {
        JSONTYPE,
        FORMTYPE,
        URLTYPE,
        FILETYPE;
    }

    /** 构造器*/
    public NetworkUtils() {
        okHttpClient = new OkHttpClient();
    }

    /** 设置主机域名*/
    public NetworkUtils setHost(String host) {
        this.host = host;
        return this;
    }

    /** 设置URL*/
    public NetworkUtils setUrl(String url) {
        this.defaultUrl = this.host + url;
        return this;
    }

    /** 设置请求头*/
    public NetworkUtils setHeaders(HashMap<String, String> headers) {
        this.defaultHeaders = headers;
        return this;
    }

    /** 设置参数*/
    public NetworkUtils setParams(HashMap<String, String> object) {
        this.params = object;
        return this;
    }

    /** 设置参数格式*/
    public NetworkUtils setBodyType(EnumBodyType type) {
        this.bodyType = type;
        return this;
    }

    /** 设置文件*/
    public NetworkUtils setFileItems(ArrayList<NetworkFileData> fileItems) {
        this.fileItems = fileItems;
        return this;
    }

    /** GET请求*/
    public void get(final NetworkCallBack netWorkCallBack) {
        //拼接完整GET地址
        String requestUrl = this.defaultUrl + paramsToString(this.params);
        //创建请求头
        Headers headers = creatHeaders(this.defaultHeaders);
        //创建请求
        Request request = new Request.Builder().url(requestUrl).headers(headers).get().build();
        //创建请求回调
        Call requestCall = okHttpClient.newCall(request);
        //发起异步请求
        requestCall.enqueue(requestCallBack(netWorkCallBack));
    }


    /** POST请求*/
    public void post(final NetworkCallBack netWorkCallBack) {
        //创建请求头
        Headers headers = creatHeaders(this.defaultHeaders);
        //创建请求体
        RequestBody body = null;
        switch (this.bodyType) {
            case JSONTYPE:
            {
                MediaType JSON = MediaType.parse("application/json;charset=utf-8");
                body = RequestBody.create(JSON, this.params.toString());
            }
                break;
            case FORMTYPE:
            {
                MultipartBody.Builder builder = new MultipartBody.Builder();
                //遍历添加参数
                for(String key : this.params.keySet()) {
                    builder.addFormDataPart(key, String.valueOf(this.params.get(key)));
                }
                //遍历添加文件
                for (NetworkFileData file : this.fileItems) {
                    builder.addFormDataPart(file.getFilePath(), file.getFileName(), RequestBody.create(MediaType.parse(file.getMediaType()), file.getFile()));
                }
                body = builder.build();
            }
                break;
            case URLTYPE:
            {
                FormBody.Builder builder = new FormBody.Builder();
                //遍历添加参数
                for(String key : this.params.keySet()) {
                    builder.add(key, String.valueOf(this.params.get(key)));
                }
                body = builder.build();
            }
                break;
        }

        //创建请求
        Request request = new Request.Builder().url(this.defaultUrl).headers(headers).post(body).build();
        //创建请求回调
        Call requestCall = okHttpClient.newCall(request);
        //发起异步请求
        requestCall.enqueue(requestCallBack(netWorkCallBack));
    }


    /** 请求回调处理*/
    private Callback requestCallBack(final NetworkCallBack netWorkCallBack) {
        return new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                if (netWorkCallBack != null) {

                    /** 创建请求失败结果*/
                    NetworkResponse responseData = new NetworkResponse();
                    responseData.setState(false);
                    responseData.setData(null);
                    responseData.setMessage("网络错误，请求失败");
                    responseData.setCode(404);
                    netWorkCallBack.completeBlock(responseData);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (netWorkCallBack != null) {

                    /** 创建请求成功结果*/
                    NetworkResponse responseData = new NetworkResponse();
                    responseData.setState(true);
                    responseData.setMessage("请求成功");
                    responseData.setCode(response.code());
                    responseData.setData(response.body());
                    netWorkCallBack.completeBlock(responseData);
                }
            }
        };
    }


    /** 创建Headers*/
    private Headers creatHeaders(HashMap<String, String> params) {

        //创建Headers
        Headers.Builder builder = new Headers.Builder();
        if (params == null) return builder.build();

        //遍历添加Headers
        for(String key : params.keySet()) {
            builder.add(key, String.valueOf(params.get(key)));
        }
        return builder.build();
    }

    /** 将HashMap参数转化为GET参数*/
    private String paramsToString(HashMap<String, String> params) {

        if (params == null) return "";

        Iterator<String> it = params.keySet().iterator();
        StringBuffer sb = null;
        while (it.hasNext()) {
            String key = it.next();
            String value = params.get(key);
            if (sb == null) {
                sb = new StringBuffer();
                sb.append("?");
            } else {
                sb.append("&");
            }
            sb.append(key);
            sb.append("=");
            sb.append(value);
        }
        return sb.toString();
    }
}
