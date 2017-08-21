package com.dayanghome.dayangerp.form;

public class CustomerQuery {
    private String chineseName;
    private String mobile;

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "CustomerQuery{" +
                "chineseName='" + chineseName + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
