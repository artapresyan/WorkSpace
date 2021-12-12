package com.workspace.workSpace.security;

import com.workspace.workSpace.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(2)
public class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    EmployeeDetailsService employeeDetailsService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .antMatcher("/employee/*")
                .authorizeRequests()
                .antMatchers("/employee/registration").permitAll()
                .antMatchers("/resources/**").authenticated()
                .antMatchers("/employee/home").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/employee/login")
                .loginProcessingUrl("/employee/login")
                .defaultSuccessUrl("/employee/home")
                .failureUrl("/employee/login?error=true")
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(employeeDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }
}
