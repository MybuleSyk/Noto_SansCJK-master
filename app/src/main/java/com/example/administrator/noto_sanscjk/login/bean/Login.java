package com.example.administrator.noto_sanscjk.login.bean;

/**
 * Created by Administrator on 2018/4/25.
 */

public class Login {

    private String status;
    private int  code;


    public Login() {
    }

    public Login(String status, int code) {
        this.status = status;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
