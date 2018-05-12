package com.example.administrator.noto_sanscjk.hotspots.bean;

/**
 * Created by Administrator on 2018/5/3.
 */

public class HotDian {

    public static final int YITU = 0; //一张图
    public static final int SANTU = 1; //三张图
    public static final int SHIPING = 2;//视频
    private String yituname;
    private String santuname;
    private String shipingnname;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public HotDian(String yituname, String santuname, String shipingnname, int type) {
        this.yituname = yituname;
        this.santuname = santuname;
        this.shipingnname = shipingnname;
        this.type = type;
    }

    public HotDian() {
    }


    public String getYituname() {
        return yituname;
    }

    public void setYituname(String yituname) {
        this.yituname = yituname;
    }

    public String getSantuname() {
        return santuname;
    }

    public void setSantuname(String santuname) {
        this.santuname = santuname;
    }

    public String getShipingnname() {
        return shipingnname;
    }

    public void setShipingnname(String shipingnname) {
        this.shipingnname = shipingnname;
    }
}
