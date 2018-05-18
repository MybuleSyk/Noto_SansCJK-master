package com.example.administrator.noto_sanscjk.home.bean;

import java.util.List;

/**
 * Created by LiYRong on 2018/5/15.
 */

public class ShopList {


    /**
     * error_code : 200
     * msg : 成功
     * data : [{"id":"1","shopimg":"/Public//Goods_img/2018-05-14/timg.jpg","price":"14.00","name":"手机维修1","shopcompay":"富刚科技","tip":"碎屏,扩容,换电池","tipp":["碎屏","扩容","换电池"]},{"id":"1","shopimg":"/Public//Goods_img/2018-05-14/timg.jpg","price":"14.00","name":"手机维修1","shopcompay":"富刚科技","tip":"碎屏,扩容,换电池","tipp":["碎屏","扩容","换电池"]},{"id":"1","shopimg":"/Public//Goods_img/2018-05-14/timg.jpg","price":"14.00","name":"手机维修1","shopcompay":"富刚科技","tip":"碎屏,扩容,换电池","tipp":["碎屏","扩容","换电池"]},{"id":"1","shopimg":"/Public//Goods_img/2018-05-14/timg.jpg","price":"14.00","name":"手机维修1","shopcompay":"富刚科技","tip":"碎屏,扩容,换电池","tipp":["碎屏","扩容","换电池"]}]
     */

    private int error_code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * shopimg : /Public//Goods_img/2018-05-14/timg.jpg
         * price : 14.00
         * name : 手机维修1
         * shopcompay : 富刚科技
         * tip : 碎屏,扩容,换电池
         * tipp : ["碎屏","扩容","换电池"]
         */

        private String id;
        private String shopimg;
        private String price;
        private String name;
        private String shopcompay;
        private String tip;
        private List<String> tipp;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getShopimg() {
            return shopimg;
        }

        public void setShopimg(String shopimg) {
            this.shopimg = shopimg;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShopcompay() {
            return shopcompay;
        }

        public void setShopcompay(String shopcompay) {
            this.shopcompay = shopcompay;
        }

        public String getTip() {
            return tip;
        }

        public void setTip(String tip) {
            this.tip = tip;
        }

        public List<String> getTipp() {
            return tipp;
        }

        public void setTipp(List<String> tipp) {
            this.tipp = tipp;
        }
    }
}
