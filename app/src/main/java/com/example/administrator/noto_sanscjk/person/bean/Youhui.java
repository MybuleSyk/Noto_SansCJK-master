package com.example.administrator.noto_sanscjk.person.bean;

/**
 * Created by Administrator on 2018/5/3.
 */

public class Youhui {

    private String title;
    private int background;

    public Youhui(String title, int background) {
        this.title = title;
        this.background = background;
    }

    public Youhui() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }
}
