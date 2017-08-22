package com.dayanghome.dayangerp.form;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class AppointmentQuery {
    private String name;
    private String mobile;
    private String address;
    private Integer status;
    private Integer cityId;
    private Integer districtId;
    private Long fromDay;
    private Long toDay;
    private Integer pageNum = 0;
    private Integer pageSize = 30;

    private Integer offset;
    private String fromDayStr;
    private String toDayStr;

    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getFromDay() {
        return fromDay;
    }

    public void setFromDay(Long fromDay) {
        this.fromDay = fromDay;
    }

    public Long getToDay() {
        return toDay;
    }

    public void setToDay(Long toDay) {
        this.toDay = toDay;
    }

    public Integer getOffset() {
        if (pageNum == 0) {
            return 0;
        } else {
            return (pageNum - 1) * pageSize;
        }
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getFromDayStr() {
        return FORMATTER.print(fromDay);
    }

    public void setFromDayStr(String fromDayStr) {
        this.fromDayStr = fromDayStr;
    }

    public String getToDayStr() {
        return FORMATTER.print(toDay);
    }

    public void setToDayStr(String toDayStr) {
        this.toDayStr = toDayStr;
    }

    @Override
    public String toString() {
        return "AppointmentQuery{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", cityId=" + cityId +
                ", districtId=" + districtId +
                ", fromDay=" + fromDay +
                ", toDay=" + toDay +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                '}';
    }
}
