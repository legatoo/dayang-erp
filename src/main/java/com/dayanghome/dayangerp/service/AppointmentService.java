package com.dayanghome.dayangerp.service;

import com.dayanghome.dayangerp.form.AppointmentForm;
import com.dayanghome.dayangerp.form.AppointmentQuery;
import com.dayanghome.dayangerp.form.CustomerQuery;
import com.dayanghome.dayangerp.mapper.AppointmentMapper;
import com.dayanghome.dayangerp.mapper.CustomerMapper;
import com.dayanghome.dayangerp.vo.Appointment;
import com.dayanghome.dayangerp.vo.Customer;
import com.google.common.base.Strings;
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
        Customer customer = form.extractCustomer();

        boolean exist = false;
        if(!Strings.isNullOrEmpty(form.getMobile())){
            List<Customer> existed = customerMapper.findByMobile(form.getMobile());
            if(existed != null && existed.size() > 0) {
                customer = existed.get(0);
                exist = true;
            }
        }

        if(!exist){
            customerMapper.insertCustomer(customer);
            Log.info("insert new custom id {}, detail {}", customer.getId(), customer);
        }

        Appointment appointment = form.extractAppointment();
        appointment.setCustomerId(customer.getId());
        appointment.setCustomerName(customer.getChineseName());
        appointmentMapper.insertAppointment(appointment);
        return appointment.getId();
    }

    public List<Appointment> searchAppoint(AppointmentQuery query){
        return appointmentMapper.searchAppointment(query);
    }

    public int countAppointments(AppointmentQuery query){
        return appointmentMapper.countByQuery(query);
    }

    public List<Customer> searchCustomer(CustomerQuery query){
        return customerMapper.searchCustomers(query);
    }
    public List<Customer> getCustomerInfo(Set<Integer> customerIds){
        return customerMapper.getCustomerInfoByIds(customerIds);
    }

    @Transactional
    public int updateAppointmentStatus(Integer appointmentId, Integer toStatus){
        return appointmentMapper.updateAppointmentStatus(appointmentId, toStatus);
    }

    @Transactional
    public int deleteAppointment(Integer appointmentId){
        return appointmentMapper.deleteAppointment(appointmentId);
    }

    @Transactional
    public int addCommentOnAppointment(Integer appointmentId, String comment){
        return appointmentMapper.addCommentOnAppointment(appointmentId, comment);
    }
}
