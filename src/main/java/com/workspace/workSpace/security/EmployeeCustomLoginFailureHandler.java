package com.workspace.workSpace.security;

import com.workspace.workSpace.entity.Employee;
import com.workspace.workSpace.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class EmployeeCustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        Employee employee = employeeService.getEmployeeByUsername(username);
        if (employee != null) {
            if (employee.isEmployeeEnabled() && employee.isEmployeeNonLocked() && employee.isEmployeeNonExpired()) {
                if (employee.getEmployeeFailedAttempt() < EmployeeService.employeeMaxFailAttempts) {
                    employeeService.increaseEmployeeFailedAttempts(employee);
                } else {
                    employeeService.lockEmployeeForAttempts(employee);
                    exception = new LockedException("Your account has been locked due to 3 failed attempts."
                            + " It will be unlocked after 24 hours.");
                }
            } else if (!employee.isEmployeeNonLocked()) {
                if (employeeService.unlockEmployeeForAttempts(employee)) {
                    exception = new LockedException("Your account has been unlocked. Please try to login again.");
                }
            } else if (!employee.isEmployeeNonExpired()) {
                if (employeeService.activateEmployeeForExpire(employee)) {
                    exception = new LockedException("Your account has been activated. Please try to login again.");
                }
            }
            super.setDefaultFailureUrl("/employee/login?error");
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
