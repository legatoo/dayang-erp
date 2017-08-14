package com.dayanghome.dayangerp.form;

public class AppointmentQuery {
    private String mobile;
    private String address;
    private Integer status;
    private Integer cityId;
    private Integer districtId;

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

    @Override
    public String toString() {
        return "AppointmentQuery{" +
                "mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", cityId=" + cityId +
                ", districtId=" + districtId +
                '}';
    }
}
