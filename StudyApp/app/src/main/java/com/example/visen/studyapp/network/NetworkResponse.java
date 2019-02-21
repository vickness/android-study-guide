package com.example.visen.studyapp.network;

import okhttp3.ResponseBody;

public class NetworkResponse {

    /** 请求状态*/
    private Boolean state;

    /** 请求内容*/
    private ResponseBody data;

    /** 提示信息*/
    private String message;

    /** 状态码*/
    private Integer code;


    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public ResponseBody getData() {
        return data;
    }

    public void setData(ResponseBody data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "NetWorkResponse{" +
                "state=" + state +
                ", data=" + data +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
