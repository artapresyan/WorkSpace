package com.workspace.workSpace.conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestingController {

    @GetMapping("/registration/employee")
    public String registrationModel(){
        return "employee_registration_view";
    }
}
