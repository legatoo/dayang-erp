package com.dayanghome.dayangerp.service;

import com.dayanghome.dayangerp.form.CustomerQuery;
import com.dayanghome.dayangerp.mapper.AppointmentMapper;
import com.dayanghome.dayangerp.mapper.CustomerMapper;
import com.dayanghome.dayangerp.vo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerService {
    private static final Logger Log = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    AppointmentMapper appointmentMapper;
    @Autowired
    CustomerMapper customerMapper;

    public List<Customer> searchCustomer(CustomerQuery query){
        return customerMapper.searchCustomers(query);
    }

    public int countTotalCustomer(CustomerQuery query){
        return customerMapper.countCustomer(query);
    }
    public List<Customer> getCustomerInfo(Set<Integer> customerIds){
        return customerMapper.getCustomerInfoByIds(customerIds);
    }
}
