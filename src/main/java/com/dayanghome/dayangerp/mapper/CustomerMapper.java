package com.dayanghome.dayangerp.mapper;

import com.dayanghome.dayangerp.vo.Appointment;
import com.dayanghome.dayangerp.vo.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface CustomerMapper {
    @Insert({"INSERT INTO customer(id, wxId, wxName, chineseName, mobile, cityId, address, createTime)" +
            "VALUES(null, #{wxId}, #{wxName}, #{chineseName}, #{mobile}, #{cityId}, #{address}, #{createTime})"})
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertCustomer(Customer customer);

    @Select("SELECT * FROM customer WHERE chineseName like '%#{state}%'")
    @ResultType(value = Customer.class)
    List<Customer> findByName(String chineseName);

    @Select("SELECT * FROM customer WHERE mobile = #{mobile}")
    @ResultType(value = Customer.class)
    List<Customer> findByMobile(String mobile);

    @Select({"<script>",
            "SELECT * FROM customer WHERE id in ",
            "<foreach collection='customerIds' item='o' separator = ', ' open =\"(\" close=\")\" >#{o}</foreach>",
            "</script>"})
    @ResultType(value =  Customer.class)
    List<Customer> getCustomerInfoByIds(@Param("customerIds") Set<Integer> customerIds);
}
