package com.example.administrator.noto_sanscjk.wrench.bean;

/**
 * Created by Administrator on 2018/5/4.
 */

public class Dengdai {

    public static final int TUWEN = 0; //图文
    public static final int YUYIN = 1; //语音
    public static final int SHIPING = 2;//视频

    private String tuwen;
    private String yuyin;
    private String shiping;
    private int type;

    public Dengdai() {
    }

    public Dengdai(String tuwen, String yuyin, String shiping, int type) {
        this.tuwen = tuwen;
        this.yuyin = yuyin;
        this.shiping = shiping;
        this.type = type;
    }

    public String getTuwen() {
        return tuwen;
    }

    public void setTuwen(String tuwen) {
        this.tuwen = tuwen;
    }

    public String getYuyin() {
        return yuyin;
    }

    public void setYuyin(String yuyin) {
        this.yuyin = yuyin;
    }

    public String getShiping() {
        return shiping;
    }

    public void setShiping(String shiping) {
        this.shiping = shiping;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
