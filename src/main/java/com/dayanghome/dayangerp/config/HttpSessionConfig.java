package com.dayanghome.dayangerp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;


@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class HttpSessionConfig {

    @Value("${server.session.timeout}")
    private Integer sessionTimeout;

    public static final String COOKIE_NAME = "DYSSIONID";

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName(COOKIE_NAME); // <1>
        serializer.setCookiePath("/"); // <2>
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$"); // <3>
        serializer.setCookieMaxAge(sessionTimeout);
        return serializer;
    }
}