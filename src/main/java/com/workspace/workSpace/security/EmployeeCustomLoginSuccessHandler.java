package com.workspace.workSpace.security;

import com.workspace.workSpace.entity.Employee;
import com.workspace.workSpace.entity.EmployeeDetails;
import com.workspace.workSpace.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class EmployeeCustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    EmployeeService employeeService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        EmployeeDetails employeeDetails = (EmployeeDetails) authentication.getPrincipal();
        Employee employee = employeeDetails.getEmployee();
        if (employee.getEmployeeFailedAttempt() > 0)
            employeeService.resetEmployeeFailedAttempts(employee.getEmployeeUsername());
        employeeService.updateEmployeeLastLogin(employee);
        super.setDefaultTargetUrl("/employee/home");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
