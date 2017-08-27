package com.dayanghome.dayangerp.filter;

import com.dayanghome.dayangerp.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.dayanghome.dayangerp.config.HttpSessionConfig.COOKIE_NAME;

public class LoginCheckFilter implements Filter {
    private static final Logger Log = LoggerFactory.getLogger(AppointmentService.class);


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        Log.info("enter login check filter");
        HttpServletRequest httpRequest = (HttpServletRequest)servletRequest;
        Cookie[] cookies = httpRequest.getCookies();
        String ssoid = null;
        if(cookies != null){
            for(Cookie each : cookies){
                if(COOKIE_NAME.equals(each.getName())){
                    ssoid = each.getValue();
                }
            }
        }

        if(ssoid != null){
            //verify ssoid
            Log.warn("going to verify cookie {}", ssoid);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
