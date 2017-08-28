package com.dayanghome.dayangerp.vo;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{
    private Integer id;
    private String wxName;
    private String chineseName;
    private String mobile;
    private Integer gender;
    private Integer provinceId;
    private String provinceName;
    private Integer cityId;
    private String cityName;
    private Date createTime;
    private Date updateTIme;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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
                ", wxName='" + wxName + '\'' +
                ", chineseName='" + chineseName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", gender=" + gender +
                ", provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", createTime=" + createTime +
                ", updateTIme=" + updateTIme +
                '}';
    }
}
