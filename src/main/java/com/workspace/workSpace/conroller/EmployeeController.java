package com.workspace.workSpace.conroller;

import com.workspace.workSpace.entity.Employee;
import com.workspace.workSpace.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/add")
    public String addEmployee(@RequestParam String employeeName,@RequestParam String employeeSurname,
                              @RequestParam String employeeJobCategory,@RequestParam String employeeEmail,
                              @RequestParam(required = false) String employeePhone,
                              @RequestParam(required = false) String employeeBirthData,
                              @RequestParam String employeeUsername,@RequestParam String employeePassword){
        return employeeService.addEmployee(employeeName, employeeSurname, employeeJobCategory, employeeEmail,
                employeePhone, employeeBirthData, employeeUsername, employeePassword);
    }

    @PutMapping("/edit")
    public String editEmployee(@RequestParam(required = false) String employeeName,@RequestParam(required = false) String employeeSurname,
                               @RequestParam(required = false) String employeeJobCategory,@RequestParam(required = false) String employeeEmail,
                               @RequestParam(required = false) String employeePhone, @RequestParam(required = false) String employeeBirthData,
                               @RequestParam(required = false) String employeeUsername,@RequestParam(required = false) String newEmployeePassword,
                               @RequestParam Long employeeId, @RequestParam String employeePassword){
        return employeeService.editEmployee(employeeId, employeeName, employeeSurname, employeeJobCategory, employeeEmail,
                employeePhone, employeeBirthData, employeeUsername, employeePassword, newEmployeePassword);
    }
    @DeleteMapping("/remove")
    public String removeEmployee(@RequestParam Long employeeId, @RequestParam String employeePassword){
        return employeeService.removeEmployee(employeeId, employeePassword);
    }
}
