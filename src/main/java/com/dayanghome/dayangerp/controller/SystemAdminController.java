package com.dayanghome.dayangerp.controller;

import com.dayanghome.dayangerp.enums.ResultCode;
import com.dayanghome.dayangerp.result.Result;
import com.dayanghome.dayangerp.service.SystemAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/api/tob/v1/systemadmin")
public class SystemAdminController {

    private static final Logger Log = LoggerFactory.getLogger(ToCApiController.class);

    @Autowired
    SystemAdminService systemAdminService;

    @RequestMapping(value = "/active", method = RequestMethod.POST) @ResponseBody
    public Result addSystemAdmin(@RequestParam("adminId") Integer adminId) {
        Result result = new Result();

        try{
            int success =  systemAdminService.activateAdminUser(adminId);
            result.setCode(ResultCode.SUCCESS);
            result.setData(success);
        }catch (Exception e){
            Log.error("failed to activate system admin", e);
            result.setCode(ResultCode.INTERNAL_ERROR);
        }

        return result;
    }
}
