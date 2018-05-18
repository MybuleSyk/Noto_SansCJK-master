package com.example.administrator.noto_sanscjk.person.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/4/26.
 */

public class Address {


    /**
     * error_code : 200
     * msg : 成功
     * data : {"list":[{"address_id":"20","userid":"107","consignee":"哈哈哈","country":null,"province":"天津市","city":"天津市","distreet":"和平区","mobile":"Ggggggg","address":"天津市天津市和平区","lat":"0","log":"0","is_select":"0","video_id":null},{"address_id":"21","userid":"107","consignee":"哈哈哈","country":null,"province":"山西省","city":"阳泉市","distreet":"盂  县","mobile":"1221515","address":"山西省阳泉市盂  县","lat":"0","log":"0","is_select":"0","video_id":null}]}
     */

    private int error_code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * address_id : 20
             * userid : 107
             * consignee : 哈哈哈
             * country : null
             * province : 天津市
             * city : 天津市
             * distreet : 和平区
             * mobile : Ggggggg
             * address : 天津市天津市和平区
             * lat : 0
             * log : 0
             * is_select : 0
             * video_id : null
             */

            private String address_id;
            private String userid;
            private String consignee;
            private Object country;
            private String province;
            private String city;
            private String distreet;
            private String mobile;
            private String address;
            private String lat;
            private String log;
            private String is_select;
            private Object video_id;

            public String getAddress_id() {
                return address_id;
            }

            public void setAddress_id(String address_id) {
                this.address_id = address_id;
            }

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getConsignee() {
                return consignee;
            }

            public void setConsignee(String consignee) {
                this.consignee = consignee;
            }

            public Object getCountry() {
                return country;
            }

            public void setCountry(Object country) {
                this.country = country;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistreet() {
                return distreet;
            }

            public void setDistreet(String distreet) {
                this.distreet = distreet;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLog() {
                return log;
            }

            public void setLog(String log) {
                this.log = log;
            }

            public String getIs_select() {
                return is_select;
            }

            public void setIs_select(String is_select) {
                this.is_select = is_select;
            }

            public Object getVideo_id() {
                return video_id;
            }

            public void setVideo_id(Object video_id) {
                this.video_id = video_id;
            }
        }
    }
}
