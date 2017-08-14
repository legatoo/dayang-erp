package com.dayanghome.dayangerp.controller;

import com.dayanghome.dayangerp.form.AppointmentQuery;
import com.dayanghome.dayangerp.service.AppointmentService;
import com.dayanghome.dayangerp.vo.Appointment;
import com.dayanghome.dayangerp.vo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/tob/v1")
public class ToBApiController {
    private static final Logger Log = LoggerFactory.getLogger(ToCApiController.class);

    @Autowired AppointmentService appointmentService;

    @RequestMapping(value = "/appointment/search", method = RequestMethod.POST)
    public String selectAppointmentByMobile(Model model, @RequestBody AppointmentQuery query) {
        try{
            List<Appointment> appointments =  appointmentService.searchAppoint(query);

            if (appointments != null && appointments.size() > 0) {
                Set<Integer> customerIds = appointments.stream().map(Appointment::getCustomerId).collect(Collectors.toSet());
                List<Customer> customers = appointmentService.getCustomerInfo(customerIds);
                Map<Integer, Customer> customerMap = customers.stream().collect(
                        Collectors.toMap(Customer::getId, Function.identity())
                );

                appointments.forEach(e -> e.setCustomerName(customerMap.get(e.getCustomerId()).getChineseName()));
                model.addAttribute("appointments", appointments);
            }
        }catch (Exception e){
            Log.error("failed to add appointment", e);
            model.addAttribute("appointments", Collections.EMPTY_LIST);
        }

        return "erp/AppointmentList";
    }

    @RequestMapping(value = "/appointment/markdone", method = RequestMethod.POST) @ResponseBody
    public Integer selectAppointmentByMobile(Model model, @RequestParam("appointmentId") Integer appointmentId,
                                             @RequestParam("toStatus") Integer toStatus) {
        try{
            return appointmentService.updateAppointmentStatus(appointmentId, toStatus);
        }catch (Exception e){
            Log.error("failed to add appointment", e);
            return 0;
        }
    }
}
