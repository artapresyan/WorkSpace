package com.workspace.workSpace.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/company/add","/company/edit","/company/remove",
                "/admin/all","/admin/add","/admin/edit","/admin/remove","/employee/add","/employee/edit",
                "/employee/remove","/job/add","/job/edit",
                "/job/remove");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    }
}
