package com.dayanghome.dayangerp.mapper;

import com.dayanghome.dayangerp.form.AppointmentQuery;
import com.dayanghome.dayangerp.vo.Appointment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppointmentMapper {

    @Insert({"INSERT INTO appointment(id, customerId, customerName, contactMobile, cityId, address, appointmentDay, hourBegin, hourEnd, status, createTime)" +
            "VALUES(null, #{customerId}, #{customerName}, #{contactMobile}, #{cityId}, #{address}, #{appointmentDay}, #{hourBegin}, #{hourEnd}, #{status}, #{createTime})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertAppointment(Appointment appointment);

    @Select({"<script>" +
            "SELECT * FROM appointment WHERE 1 = 1 " +
            "<if test=\"name!=null and name != ''\">AND customerName like '%${name}%' </if>" +
            "<if test=\"mobile!=null and mobile != ''\">AND contactMobile = ${mobile} </if>" +
            "<if test=\"address!=null\">AND contactMobile like '%${address}%' </if>" +
            "<if test=\"status!=null\">AND status = ${status} </if>" +
            "<if test=\"cityId!=null\">AND cityId = ${cityId} </if>" +
            "<if test=\"districtId!=null\">AND districtId = ${districtId} </if>" +
            "<if test=\"fromDay!=null\"><![CDATA[ AND appointmentDay >= '${fromDayStr}' ]]></if>" +
            "<if test=\"toDay!=null\"><![CDATA[ AND appointmentDay <= '${toDayStr}' ]]></if>" +
            "limit #{offset}, #{pageSize}" +
            "</script>"})
    @ResultType(Appointment.class)
    List<Appointment> searchAppointment(AppointmentQuery query);

    @Select({"<script>" +
            "SELECT count(1) FROM appointment WHERE 1 = 1 " +
            "<if test=\"name!=null and name != ''\">AND customerName like '%${name}%' </if>" +
            "<if test=\"mobile!=null and mobile != ''\">AND contactMobile = ${mobile} </if>" +
            "<if test=\"address!=null\">AND contactMobile like '%${address}%' </if>" +
            "<if test=\"status!=null\">AND status = ${status} </if>" +
            "<if test=\"cityId!=null\">AND cityId = ${cityId} </if>" +
            "<if test=\"districtId!=null\">AND districtId = ${districtId} </if>" +
            "<if test=\"fromDay!=null\"><![CDATA[ AND appointmentDay >= '${fromDayStr}' ]]></if>" +
            "<if test=\"toDay!=null\"><![CDATA[ AND appointmentDay <= '${toDayStr}' ]]></if>" +
            "</script>"})
    @ResultType(Integer.class)
    int countByQuery(AppointmentQuery query);

    @Update({"UPDATE appointment SET status = #{toStatus} WHERE id = #{appointmentId}"})
    int updateAppointmentStatus(@Param("appointmentId") Integer appointmentId, @Param("toStatus") Integer toStatus);

    @Delete({"DELETE FROM appointment WHERE id = #{appointmentId}"})
    int deleteAppointment(@Param("appointmentId") Integer appointmentId);
}
