package com.example.administrator.noto_sanscjk.person.bean;

/**
 * Created by LiYRong on 2018/5/16.
 */

public class AddAddress {


    /**
     * error_code : 300
     * msg : 请添加地址
     */

    private int error_code;
    private String msg;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
