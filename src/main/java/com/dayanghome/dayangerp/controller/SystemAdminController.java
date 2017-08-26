package com.dayanghome.dayangerp.controller;

import com.dayanghome.dayangerp.enums.ResultCode;
import com.dayanghome.dayangerp.result.Result;
import com.dayanghome.dayangerp.service.AppointmentService;
import com.dayanghome.dayangerp.service.SystemAdminService;
import com.dayanghome.dayangerp.vo.SystemAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.google.common.base.Preconditions.checkState;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/tob/v1/systemadmin")
public class SystemAdminController {

    private static final Logger Log = LoggerFactory.getLogger(ToCApiController.class);

    @Autowired SystemAdminService systemAdminService;

    @RequestMapping(value = "/add", method = RequestMethod.POST) @ResponseBody
    public Result addSystemAdmin(@RequestBody SystemAdmin systemAdmin) {
        Result result = new Result();

        try{
            int systemAdminId =  systemAdminService.addNewSystemAdmin(systemAdmin);
            result.setCode(ResultCode.SUCCESS);
            result.setData(systemAdminId);
        }catch (Exception e){
            Log.error("failed to add system admin", e);
            result.setCode(ResultCode.INTERNAL_ERROR);
        }

        return result;
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST) @ResponseBody
    public Result verifySystemAdmin(@RequestBody SystemAdmin systemAdmin) {
        Result result = new Result();

        try{
            SystemAdmin exist =  systemAdminService.verigySystemAdmin(systemAdmin);
            checkState(exist != null, "system verify failed");
            result.setCode(ResultCode.SUCCESS);
            result.setData(exist);
        }catch (Exception e){
            Log.error("failed to verify system admin");
            result.setCode(ResultCode.INTERNAL_ERROR);
        }

        return result;
    }
}
