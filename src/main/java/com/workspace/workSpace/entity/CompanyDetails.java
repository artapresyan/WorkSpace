package com.workspace.workSpace.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class CompanyDetails implements UserDetails {

    private final Company company;

    public CompanyDetails(Company company) {
        this.company = company;
    }

    public Company getCompany(){
        return company;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return company.getCompanyPassword();
    }

    @Override
    public String getUsername() {
        return company.getCompanyUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return company.isCompanyNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return company.isCompanyNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return company.getCompanyFailedAttempt()<3;
    }

    @Override
    public boolean isEnabled() {
        return company.isCompanyEnabled();
    }
}
