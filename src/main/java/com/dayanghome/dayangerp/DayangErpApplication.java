package com.dayanghome.dayangerp;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Arrays;

@SpringBootApplication
public class DayangErpApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DayangErpApplication.class, args);

//		System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//		String[] beanNames = ctx.getBeanDefinitionNames();
//		Arrays.sort(beanNames);
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}
	}
}
