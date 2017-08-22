package com.dayanghome.dayangerp.form;

import com.dayanghome.dayangerp.vo.Appointment;
import com.dayanghome.dayangerp.vo.Customer;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

public class AppointmentForm implements Serializable {
    private String wxId;
    private String wxName;
    private String chineseName;
    private String mobile;
    private Integer gender;
    private Integer cityId;
    private Integer districtId;
    private String address;
    private Long appointmentDay;
    private Integer hourBegin;
    private Integer hourEnd;

    public void validate(){

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

    public Customer extractCustomer(){
        Customer customer = new Customer();
        customer.setWxId(wxId);
        customer.setWxName(wxName);
        customer.setChineseName(chineseName);
        customer.setMobile(mobile);
        customer.setGender(gender);
        customer.setCityId(cityId);
        customer.setCityId(districtId);
        customer.setAddress(address);
        customer.setCreateTime(new Date());

        return customer;
    }


    public Appointment extractAppointment(){
        Appointment appointment = new Appointment();
        appointment.setContactMobile(mobile);
        appointment.setAddress(address);
        appointment.setCityId(cityId);
        appointment.setDistrictId(districtId);
        DateTime appointmentDate = new DateTime(appointmentDay).withTimeAtStartOfDay();
        appointment.setAppointmentDay(new Date(appointmentDate.getMillis()));
        appointment.setStatus(0);//0=为处理 1=已处理
        appointment.setCreateTime(new Date());
        appointment.setHourBegin(hourBegin);
        appointment.setHourEnd(hourEnd);

        return appointment;
    }
}
