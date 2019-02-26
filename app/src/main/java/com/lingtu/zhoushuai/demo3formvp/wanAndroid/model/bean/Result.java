package com.lingtu.zhoushuai.demo3formvp.wanAndroid.model.bean;

public class Result<D> {
    public final static int SUCCEED_CODE = 0;

    public int errorCode;
    public String errorMsg;
    public D data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
