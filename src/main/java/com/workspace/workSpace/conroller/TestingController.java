package com.workspace.workSpace.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class TestingController {

    @GetMapping("/employee")
    public String employeeRegistrationModel(){
        return "employee_registration_view";
    }

    @GetMapping("/company")
    public String companyRegistrationModel(){
        return "company_registration_view";
    }
}
