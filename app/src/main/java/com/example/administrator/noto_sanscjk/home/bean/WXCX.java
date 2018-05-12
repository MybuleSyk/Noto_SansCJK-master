package com.example.administrator.noto_sanscjk.home.bean;

/**
 * Created by LiYRong on 2018/5/12.
 */

public class WXCX {

    private String name;

    private int type;

    public WXCX() {
    }

    public WXCX(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
