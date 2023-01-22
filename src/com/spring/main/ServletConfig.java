package com.spring.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= ("com.spring.main.controller,com.spring.main.rest,com.spring.app.main.service"))

public class ServletConfig implements WebMvcConfigurer {
static {
	System.out.println("servlet config loadad...");
}
}
