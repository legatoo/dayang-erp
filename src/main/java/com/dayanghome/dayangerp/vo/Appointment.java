package com.dayanghome.dayangerp.vo;

import com.google.common.base.Strings;

import java.io.Serializable;
import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;

public class Appointment implements Serializable{
    private Integer id;
    private Integer customerId;
    private String customerName;
    private String contactMobile;
    private Integer cityId;
    private Integer districtId;
    private String address;
    private Date appointmentDay;
    private Integer hourBegin;
    private Integer hourEnd;
    private Integer status;
    private Date createTime;
    private Date updateTime;

    //non-db field
    private Integer gender;
    private String hourRange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(Date appointmentDay) {
        this.appointmentDay = appointmentDay;
    }

    public Integer getHourBegin() {
        return hourBegin;
    }

    public void setHourBegin(Integer hourBegin) {
        this.hourBegin = hourBegin;
    }

    public Integer getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(Integer hourEnd) {
        this.hourEnd = hourEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getHourRange() {
        return hourRange;
    }

    public void setHourRange(String hourRange) {
        this.hourRange = hourRange;
    }

    public void mergeHourBeginAndEnd(){
        this.hourRange = this.hourBegin + "时 - " + this.hourEnd + "时";
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", contactMobile='" + contactMobile + '\'' +
                ", cityId=" + cityId +
                ", districtId=" + districtId +
                ", address='" + address + '\'' +
                ", appointmentDay=" + appointmentDay +
                ", hourBegin='" + hourBegin + '\'' +
                ", hourEnd='" + hourEnd + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", gender=" + gender +
                '}';
    }
}
