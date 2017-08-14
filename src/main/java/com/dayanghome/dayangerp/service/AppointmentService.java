package com.dayanghome.dayangerp.service;

import com.dayanghome.dayangerp.form.AppointmentForm;
import com.dayanghome.dayangerp.form.AppointmentQuery;
import com.dayanghome.dayangerp.mapper.AppointmentMapper;
import com.dayanghome.dayangerp.mapper.CustomerMapper;
import com.dayanghome.dayangerp.vo.Appointment;
import com.dayanghome.dayangerp.vo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class AppointmentService {
    private static final Logger Log = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired AppointmentMapper appointmentMapper;
    @Autowired CustomerMapper customerMapper;

    @Transactional
    public int addAppointment(AppointmentForm form){
        List<Customer> existed = customerMapper.findByMobile(form.getMobile());
        Integer customId;
        if(existed != null && existed.size() > 0){
            customId = existed.get(0).getId();
        }else{
            Customer customer = form.extractCustomer();
            customerMapper.insertCustomer(customer);
            customId = customer.getId();
            Log.info("insert new custom id {}, detail {}", customId, customer);
        }

        Appointment appointment = form.extractAppointment();
        appointment.setCustomerId(customId);
        appointmentMapper.insertAppointment(appointment);
        return appointment.getId();
    }

    public List<Appointment> searchAppoint(AppointmentQuery query){
        return appointmentMapper.searchAppointment(query);
    }

    public List<Customer> getCustomerInfo(Set<Integer> customerIds){
        return customerMapper.getCustomerInfoByIds(customerIds);
    }

    @Transactional
    public int updateAppointmentStatus(Integer appointmentId, Integer toStatus){
        return appointmentMapper.updateAppointmentStatus(appointmentId, toStatus);
    }
}
