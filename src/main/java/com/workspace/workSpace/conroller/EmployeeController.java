package com.workspace.workSpace.conroller;

import com.workspace.workSpace.entity.Employee;
import com.workspace.workSpace.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/home")
    public String addEmployee(Model model, @RequestParam() String employeeName, @RequestParam() String employeeSurname,
                              @RequestParam() String employeeJobCategory, @RequestParam() String employeeEmail,
                              @RequestParam(required = false) String employeePhone,
                              @RequestParam(required = false) String employeeBirthData,
                              @RequestParam() String employeeUsername, @RequestParam() String employeePassword,
                              @RequestParam() String employeeGender, @RequestParam() String employeePasswordConfirmation) {
        employeeService.addEmployee(employeeName, employeeSurname, employeeJobCategory, employeeEmail,
                employeePhone, employeeBirthData, employeeUsername, employeePassword, employeeGender, employeePasswordConfirmation);
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("employeeSurname", employeeSurname);
        model.addAttribute("employeeJobCategory", employeeJobCategory);
        model.addAttribute("employeeEmail", employeeEmail);
        model.addAttribute("employeePhone", employeePhone);
        model.addAttribute("employeeBirthData", employeeBirthData);
        model.addAttribute("employeeUsername", employeeUsername);
        model.addAttribute("employeePassword", employeePassword);
        model.addAttribute("employeeGender", employeeGender);
        model.addAttribute("employeePasswordConfirmation", employeePasswordConfirmation);
        return "employee_view";
    }

    @GetMapping("/login")
    public String employeeLogin(){
        return "employee_login_view";
    }

    @PutMapping("/edit")
    public String editEmployee(@RequestParam(required = false) String employeeName,
                               @RequestParam(required = false) String employeeSurname,
                               @RequestParam(required = false) String employeeJobCategory,
                               @RequestParam(required = false) String employeeEmail,
                               @RequestParam(required = false) String employeePhone,
                               @RequestParam(required = false) String employeeBirthData,
                               @RequestParam(required = false) String employeeUsername,
                               @RequestParam(required = false) String newEmployeePassword,
                               @RequestParam Long employeeId, @RequestParam String employeePassword,
                               @RequestParam(required = false) String employeeGender) {
        return employeeService.editEmployee(employeeId, employeeName, employeeSurname, employeeJobCategory, employeeEmail,
                employeePhone, employeeBirthData, employeeUsername, employeePassword, newEmployeePassword, employeeGender);
    }

    @DeleteMapping("/remove")
    public String removeEmployee(@RequestParam Long employeeId, @RequestParam String employeePassword) {
        return employeeService.removeEmployee(employeeId, employeePassword);
    }
}
