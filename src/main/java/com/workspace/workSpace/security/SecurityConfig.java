package com.workspace.workSpace.security;

import com.workspace.workSpace.service.CompanyDetailsService;
import com.workspace.workSpace.service.EmployeeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity( securedEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Order(1)
    @Configuration
    public static class CompanyConfig extends WebSecurityConfigurerAdapter{
        @Autowired
        CompanyDetailsService companyDetailsService;

        @Autowired
        BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(companyDetailsService).passwordEncoder(bCryptPasswordEncoder);
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/resource/**","/","/registration/company*","/company/login*",
                    "/registration/employee*","/employee/login*");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/company/**")
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/**")
                    .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/company/login")
                    .loginProcessingUrl("/company/login")
                    .defaultSuccessUrl("/company/home")
                    .failureUrl("/company/login-error");
        }
    }

    @Order(2)
    @Configuration
    public static class EmployeeConfig extends WebSecurityConfigurerAdapter{

        @Autowired
        EmployeeDetailsService employeeDetailsService;

        @Autowired
        BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(employeeDetailsService).passwordEncoder(bCryptPasswordEncoder);
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring().antMatchers("/resource/**","/","/registration/company*","/company/login*",
                    "/registration/employee*","/employee/login*");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/employee/**")
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/**")
                    .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/employee/login")
                    .loginProcessingUrl("/employee/login")
                    .defaultSuccessUrl("/employee/home")
                    .failureUrl("/employee/login-error");
        }
    }
}
