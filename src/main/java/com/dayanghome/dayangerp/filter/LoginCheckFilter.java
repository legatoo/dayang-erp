package com.dayanghome.dayangerp.filter;

import com.dayanghome.dayangerp.service.AppointmentService;
import com.dayanghome.dayangerp.service.FilterBeanProvider;
import com.dayanghome.dayangerp.service.SessionFetcher;
import com.google.common.base.Strings;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.session.Session;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        if(HttpMethod.OPTIONS.name().equals(httpRequest.getMethod())){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }


        if(!Strings.isNullOrEmpty(ssoid)){
            //verify ssoid
            Log.warn("going to verify cookie {}", ssoid);

            SessionFetcher sessionFetcher = FilterBeanProvider.getBean("sessionFetcher", SessionFetcher.class);
            Session session = sessionFetcher.getSessionById(ssoid);

            if(session != null){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }


        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String origin = httpRequest.getHeader("Origin");
        httpResponse.setHeader("Access-Control-Allow-Origin", Strings.isNullOrEmpty(origin) ? "*" : origin);
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        httpResponse.setHeader("Access-Control-Allow-Credentials ", "true");
        httpResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        httpResponse.setStatus(HttpStatus.FORBIDDEN.value());
    }

    @Override
    public void destroy() {

    }
}
