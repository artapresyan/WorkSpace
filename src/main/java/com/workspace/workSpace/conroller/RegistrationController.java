package com.workspace.workSpace.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping("/")
    public String mainRegistrationModel(){
        return "main_view";
    }

    @GetMapping("/registration/employee")
    public String employeeRegistrationModel(){
        return "employee_registration_view";
    }

    @GetMapping("/registration/company")
    public String companyRegistrationModel(){
        return "company_registration_view";
    }

}