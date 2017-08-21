package com.dayanghome.dayangerp.vo;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{
    private Integer id;
    private String wxId;
    private String wxName;
    private String chineseName;
    private String mobile;
    private Integer gender;
    private Integer cityId;
    private String address;
    private Date createTime;
    private Date updateTIme;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTIme() {
        return updateTIme;
    }

    public void setUpdateTIme(Date updateTIme) {
        this.updateTIme = updateTIme;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", wxId='" + wxId + '\'' +
                ", wxName='" + wxName + '\'' +
                ", chineseName='" + chineseName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender='" + gender + '\'' +
                ", cityId=" + cityId +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", updateTIme=" + updateTIme +
                '}';
    }
}
