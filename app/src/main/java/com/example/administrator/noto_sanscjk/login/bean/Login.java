package com.example.administrator.noto_sanscjk.login.bean;

/**
 * Created by Administrator on 2018/4/25.
 */

public class Login {


    /**
     * error_code : 200
     * msg : 登录成功
     * data : {"usertoken":"520b7c3de0cccb4731d31dcd905e6472b50f8868","userid":"107","userToken":"520b7c3de0cccb4731d31dcd905e6472b50f8868"}
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
        /**
         * usertoken : 520b7c3de0cccb4731d31dcd905e6472b50f8868
         * userid : 107
         * userToken : 520b7c3de0cccb4731d31dcd905e6472b50f8868
         */

        private String usertoken;
        private String userid;
        private String userToken;

        public String getUsertoken() {
            return usertoken;
        }

        public void setUsertoken(String usertoken) {
            this.usertoken = usertoken;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }
    }
}
