package com.dayanghome.dayangerp.controller;

import com.dayanghome.dayangerp.enums.ResultCode;
import com.dayanghome.dayangerp.form.AppointmentForm;
import com.dayanghome.dayangerp.form.AppointmentQuery;
import com.dayanghome.dayangerp.result.Result;
import com.dayanghome.dayangerp.service.AppointmentService;
import com.dayanghome.dayangerp.service.CustomerService;
import com.dayanghome.dayangerp.vo.Appointment;
import com.dayanghome.dayangerp.vo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/tob/v1/appointment")
public class AppointmentController {
    private static final Logger Log = LoggerFactory.getLogger(ToCApiController.class);

    @Autowired AppointmentService appointmentService;
    @Autowired CustomerService customerService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Result addAppointment(@RequestBody AppointmentForm appointmentForm) {
        Result result = new Result();

        try {
            appointmentForm.validate();
            int appointmentId = appointmentService.addAppointment(appointmentForm);
            result.setCode(ResultCode.SUCCESS);
            result.setData(appointmentId);
        } catch (Exception e) {
            Log.error("failed to add appointment", e);
            result.setCode(ResultCode.INTERNAL_ERROR);
        }

        return result;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Result queryAppointments(@RequestBody AppointmentQuery query) {
        Result result = new Result();
        try {
            List<Appointment> appointments = appointmentService.searchAppoint(query);
            int total = 0;
            if (appointments != null && appointments.size() > 0) {
                Set<Integer> customerIds = appointments.stream().map(Appointment::getCustomerId).collect(Collectors.toSet());
                List<Customer> customers = customerService.getCustomerInfo(customerIds);
                Map<Integer, Customer> customerMap = customers.stream().collect(
                        Collectors.toMap(Customer::getId, Function.identity())
                );

                appointments.forEach(e -> {
                    e.setCustomerName(customerMap.get(e.getCustomerId()).getChineseName());
                    e.setGender(customerMap.get(e.getCustomerId()).getGender());
                    e.mergeHourBeginAndEnd();
                });

                total = appointmentService.countAppointments(query);
            }

            result.setCode(ResultCode.SUCCESS);
            result.setLength(total);
            result.setData(appointments);
        } catch (Exception e) {
            Log.error("failed to add appointment", e);
            result.setCode(ResultCode.INTERNAL_ERROR);
        }

        return result;
    }

    @RequestMapping(value = "/markdone", method = RequestMethod.POST) @ResponseBody
    public Result markAppointmentDone(@RequestParam("appointmentId") Integer appointmentId,
                                      @RequestParam("toStatus") Integer toStatus) {
        Result result = new Result();
        try{
            Integer code = appointmentService.updateAppointmentStatus(appointmentId, toStatus);
            result.setCode(ResultCode.SUCCESS);
            result.setData(code);
        }catch (Exception e){
            Log.error("failed to update appointment", e);
            result.setCode(ResultCode.INTERNAL_ERROR);
        }

        return result;
    }

    @RequestMapping(value = "/addcomment", method = RequestMethod.POST) @ResponseBody
    public Result addCommentOnAppointment(@RequestParam("appointmentId") Integer appointmentId,
                                          @RequestParam("comment") String comment) {
        Result result = new Result();
        try{
            Integer code = appointmentService.addCommentOnAppointment(appointmentId, comment);
            result.setCode(ResultCode.SUCCESS);
            result.setData(code);
        }catch (Exception e){
            Log.error("failed to update appointment", e);
            result.setCode(ResultCode.INTERNAL_ERROR);
        }

        return result;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST) @ResponseBody
    public Result deleteAppointment(@RequestParam("appointmentId") Integer appointmentId) {
        Result result = new Result();
        try{
            Integer code = appointmentService.deleteAppointment(appointmentId);
            result.setCode(ResultCode.SUCCESS);
            result.setData(code);
        }catch (Exception e){
            Log.error("failed to delete appointment", e);
            result.setCode(ResultCode.INTERNAL_ERROR);
        }

        return result;
    }
}
