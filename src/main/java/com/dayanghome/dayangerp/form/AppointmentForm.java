package com.dayanghome.dayangerp.form;

import com.dayanghome.dayangerp.utils.DistrictIdMap;
import com.dayanghome.dayangerp.vo.Appointment;
import com.dayanghome.dayangerp.vo.Customer;
import com.google.common.base.Strings;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;
import static com.google.common.base.Preconditions.checkArgument;

public class AppointmentForm implements Serializable {
    private String wxId = "";
    private String wxName = "";
    private String chineseName;
    private String mobile;
    private Integer gender;
    private Integer provinceId;
    private Integer cityId;
    private String address;
    private Long appointmentDay;
    private String hourBegin;//HH:mm
    private String hourEnd;//HH:mm
    private String comment;

    public void validate(){
        checkArgument(!Strings.isNullOrEmpty(mobile), "mobile can not be empty");
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

    public Long getAppointmentDay() {
        return appointmentDay;
    }

    public void setAppointmentDay(Long appointmentDay) {
        this.appointmentDay = appointmentDay;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getHourBegin() {
        return hourBegin;
    }

    public void setHourBegin(String hourBegin) {
        this.hourBegin = hourBegin;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Customer extractCustomer(){
        Customer customer = new Customer();
        customer.setWxName(wxName);
        customer.setChineseName(chineseName);
        customer.setMobile(mobile);
        customer.setGender(gender);
        customer.setProvinceId(provinceId);
        customer.setProvinceName(DistrictIdMap.provinceName(provinceId));
        customer.setCityId(cityId);
        customer.setCityName(DistrictIdMap.cityName(cityId));
        customer.setCreateTime(new Date());

        return customer;
    }


    public Appointment extractAppointment(){
        Appointment appointment = new Appointment();
        appointment.setContactMobile(mobile);
        appointment.setAddress(address);
        appointment.setProvinceId(provinceId);
        appointment.setCityId(cityId);
        DateTime appointmentDate = new DateTime(appointmentDay).withTimeAtStartOfDay();
        appointment.setAppointmentDay(new Date(appointmentDate.getMillis()));
        appointment.setStatus(0);//0=为处理 1=已处理
        appointment.setCreateTime(new Date());
        appointment.setHourBegin(hourBegin);
        appointment.setHourEnd(hourEnd);
        appointment.setComment(comment);
        appointment.setProvinceName(DistrictIdMap.provinceName(provinceId));
        appointment.setCityName(DistrictIdMap.cityName(cityId));

        return appointment;
    }
}
