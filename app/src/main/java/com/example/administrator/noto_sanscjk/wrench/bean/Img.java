package com.example.administrator.noto_sanscjk.wrench.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/9.
 */

public class Img implements Serializable{
    private String imgRoad;

    public Img() {
    }

    public Img(String imgRoad) {
        this.imgRoad = imgRoad;
    }

    public String getImgRoad() {
        return imgRoad;
    }

    public void setImgRoad(String imgRoad) {
        this.imgRoad = imgRoad;
    }

}
