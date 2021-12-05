package com.workspace.workSpace.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(1)
public class DefaultSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                antMatcher("/*")
                .authorizeRequests()
                .antMatchers("/resource/**","/","/company/registration*","/company/login*",
                        "/employee/registration*","/employee/login*")
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
