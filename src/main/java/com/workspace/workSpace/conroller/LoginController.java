package com.workspace.workSpace.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/company/login")
    public String companyLogin(){
        return "company_login_view";
    }

    @GetMapping("/employee/login")
    public String employeeLogin(){
        return "employee_login_view";
    }
}
