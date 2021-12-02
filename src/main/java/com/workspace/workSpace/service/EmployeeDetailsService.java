package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Employee;
import com.workspace.workSpace.entity.EmployeeDetails;
import com.workspace.workSpace.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.getByEmployeeUsername(username);
        if (employee != null)
            return new EmployeeDetails(employee);
        else
            throw new UsernameNotFoundException("Employee Not Found");
    }
}
