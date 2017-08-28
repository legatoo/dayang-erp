package com.dayanghome.dayangerp.controller;

import com.dayanghome.dayangerp.enums.ResultCode;
import com.dayanghome.dayangerp.form.CustomerQuery;
import com.dayanghome.dayangerp.result.Result;
import com.dayanghome.dayangerp.service.AppointmentService;
import com.dayanghome.dayangerp.service.CustomerService;
import com.dayanghome.dayangerp.vo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/tob/v1/customer")
public class CustomerController {
    private static final Logger Log = LoggerFactory.getLogger(ToCApiController.class);


    @Autowired
    CustomerService customerService;
    @RequestMapping(value = "/search", method = RequestMethod.POST) @ResponseBody
    public Result queryCustomers(@RequestBody CustomerQuery query){
        Result result = new Result();
        try {
            List<Customer> customers = customerService.searchCustomer(query);
            result.setCode(ResultCode.SUCCESS);
            if(customers == null || customers.size() == 0){
                result.setLength(0);
            }else{
                result.setLength(customerService.countTotalCustomer(query));
            }
            result.setData(customers);
        } catch (Exception e){
            Log.error("failed to query customers", e);
            result.setCode(ResultCode.INTERNAL_ERROR);
        }

        return result;
    }
}
