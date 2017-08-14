package com.dayanghome.dayangerp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/backdoor")
public class BackdoorController {
    private static final Logger Log = LoggerFactory.getLogger(BackdoorController.class);

    @Value("${my.env}") private String env;
    @Value("${my.app-name}") private String appName;

    @RequestMapping("/info")
    public String environmentInfo(Model model) {
        Log.info("receive request");
        String ack =  "welcome to " + appName + " Current environment[" + env + "]";
        model.addAttribute("ack", ack);

        return "/backdoor/BackdoorPage";
    }
}
