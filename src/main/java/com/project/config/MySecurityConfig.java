package com.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Note: 
        // Use this to enable the tomcat basic authentication (tomcat popup rather than spring login page)
        // Note that the CSRf token is disabled for all requests (change it as you wish...)
        http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }

 } 