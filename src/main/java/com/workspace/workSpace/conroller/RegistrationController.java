package com.workspace.workSpace.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping("/")
    public String mainRegistrationModel(){
        return "main_view";
    }

    @GetMapping("/employee/registration")
    public String employeeRegistrationModel(){
        return "employee_registration_view";
    }

    @GetMapping("/company/registration")
    public String companyRegistrationModel(){
        return "company_registration_view";
    }

}
