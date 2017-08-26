package com.dayanghome.dayangerp.vo;

public class SystemAdmin {
    private Integer id;
    private String loginName;
    private String secret;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "SystemAdmin{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
