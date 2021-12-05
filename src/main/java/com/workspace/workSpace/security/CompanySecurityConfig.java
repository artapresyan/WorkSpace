package com.workspace.workSpace.security;

import com.workspace.workSpace.service.CompanyDetailsService;
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
@Order(3)
public class CompanySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CompanyDetailsService companyDetailsService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .antMatcher("/company/*")
                .authorizeRequests()
                .antMatchers("/company/registration").permitAll()
                .antMatchers("/resources/**").authenticated()
                .antMatchers("/company/home").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/company/login")
                .loginProcessingUrl("/company/login")
                .defaultSuccessUrl("/company/home")
                .failureUrl("/company/login?error=true")
                .permitAll();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(companyDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }
}
