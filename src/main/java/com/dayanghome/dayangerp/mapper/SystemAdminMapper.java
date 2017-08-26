package com.dayanghome.dayangerp.mapper;

import com.dayanghome.dayangerp.vo.Appointment;
import com.dayanghome.dayangerp.vo.SystemAdmin;
import org.apache.ibatis.annotations.*;

@Mapper
public interface SystemAdminMapper {
    @Insert({"INSERT INTO system_admin " +
            "(id, loginName, secret, status)" +
            "VALUES(null, #{loginName}, #{secret}, 1)"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertSystemAdmin(SystemAdmin systemAdmin);


    @Select({"<script>" +
            "SELECT * FROM system_admin WHERE status = 1 " +
            "<if test=\"loginName!=null and loginName != ''\">AND loginName = '${loginName}' </if>" +
            "<if test=\"secret!=null and secret != ''\">AND secret = '${secret}' </if>" +
            "</script>"})
    @ResultType(SystemAdmin.class)
    SystemAdmin verifySystemAdminLogin(SystemAdmin admin);
}
