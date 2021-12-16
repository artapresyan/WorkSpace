package com.workspace.workSpace.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class EmployeeDetails implements UserDetails {

    private final Employee employee;

    public EmployeeDetails(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return employee.getEmployeePassword();
    }

    @Override
    public String getUsername() {
        return employee.getEmployeeUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return employee.isEmployeeNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return employee.isEmployeeNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return employee.getEmployeeFailedAttempt()<3;
    }

    @Override
    public boolean isEnabled() {
        return employee.isEmployeeEnabled();
    }
}
