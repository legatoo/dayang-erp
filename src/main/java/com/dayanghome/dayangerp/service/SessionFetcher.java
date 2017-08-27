package com.dayanghome.dayangerp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.session.Session;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class SessionFetcher {
    private static final Logger Log = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    private RedisOperationsSessionRepository repository;

    public static final String SESSION_PREFIX = "spring:session:sessions:";

    public Session getSessionById(String ssoid){
        String sessionId = SESSION_PREFIX + ssoid;
        try{

            return repository.getSession(ssoid);
        } catch (Exception e){
            Log.error("", e);
            return null;
        }
    }
}
