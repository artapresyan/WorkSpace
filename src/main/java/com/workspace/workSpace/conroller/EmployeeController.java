package com.workspace.workSpace.conroller;

import com.workspace.workSpace.entity.Employee;
import com.workspace.workSpace.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @GetMapping("/home")
    public String getCompanyHomepage(@ModelAttribute("Employee") Employee employee, Model model) {
        model.getAttribute(employee.getEmployeeName());
        model.getAttribute(employee.getEmployeeUsername());
        return "employee_view";
    }

    @GetMapping("/login-error")
    public String employeeLoginErrorCase(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        model.addAttribute("errorMessage", errorMessage);
        return "redirect:/employee/login";
    }

    @PostMapping("/registration")
    public String addNewEmployee(Model model, @RequestParam() String employeeName, @RequestParam() String employeeSurname,
                              @RequestParam() String employeeJobCategory, @RequestParam() String employeeEmail,
                              @RequestParam(required = false) String employeePhone,
                              @RequestParam(required = false) String employeeBirthData,
                              @RequestParam() String employeeUsername, @RequestParam() String employeePassword,
                              @RequestParam() String employeeGender, @RequestParam() String employeePasswordConfirmation) {
        employeeService.addEmployee(employeeName, employeeSurname, employeeJobCategory, employeeEmail,
                employeePhone, employeeBirthData, employeeUsername, employeePassword, employeeGender, employeePasswordConfirmation);
        model.addAttribute(new Employee(employeeName, employeeSurname, employeeJobCategory, employeeEmail, employeePhone,
                employeeBirthData, employeeUsername, employeePassword, employeeGender));
        return "redirect:/employee/login";
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
