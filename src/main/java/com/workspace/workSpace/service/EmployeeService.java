package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Employee;
import com.workspace.workSpace.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public String addEmployee(String employeeName, String employeeSurname, String employeeJobCategory,
                              String employeeEmail, String employeePhone, LocalDate employeeBirthData,
                              String employeeUsername, String employeePassword){
        if (employeeName.matches("^[A-Z][a-z]{2,15}") && employeeSurname.matches("^[A-Z][a-z]{2,25}")
                && employeeJobCategory.matches("[a-zA-z\\s]{2,20}")
                && employeeUsername.matches("[a-z]{7,}|[a-z]{3,}[a-z0-9]{4,30}")
                && employeePassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")
                && employeePhone.matches("([0]|[374]{3}|[+374]{4})([99]|[98]|[97]|[96]" +
                "|[95]|[94]|[93]|[91]|[77]|[55]|[44]|[43]|[41]|[33]){2}[0-9]{6}")
                && employeeEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]{2,15}\\.[a-z]{2,3}")){
            Employee newEmployee=new Employee(employeeName,employeeSurname,employeeJobCategory,employeeEmail,
                    employeePhone,employeeBirthData,employeeUsername,employeePassword);
            employeeRepository.save(newEmployee);
            return "Congratulations Mr."+employeeSurname+"! "+"Now you are a member of WorkSpace.";
        }else
            return "ERROR 404";
    }

    public String removeEmployee(Long id){
        try {
            employeeRepository.deleteById(id);
            return employeeRepository.getById(id).getEmployeeUsername()+"'s profile removed.";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }

    public String editEmployee(Long id,String employeeName, String employeeSurname, String employeeJobCategory,
                               String employeeEmail, String employeePhone, LocalDate employeeBirthData,
                               String employeeUsername, String employeePassword){
        try {
            Employee newEmployee = employeeRepository.getById(id);
            if (employeeName.matches("^[A-Z][a-z]{2,15}"))
                newEmployee.setEmployeeName(employeeName);
            if (employeeSurname.matches("^[A-Z][a-z]{2,25}"))
                newEmployee.setEmployeeSurname(employeeSurname);
            if (employeeEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]{2,15}\\.[a-z]{2,3}"))
                newEmployee.setEmployeeEmail(employeeEmail);
            if (employeeUsername.matches("[a-z]{7,}|[a-z]{3,}[a-z0-9]{4,30}"))
                newEmployee.setEmployeeUsername(employeeUsername);
            if (employeePassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$"))
                newEmployee.setEmployeePassword(employeePassword);
            if ( employeeJobCategory.matches("[a-zA-z\\s]{2,20}"))
                newEmployee.setEmployeeJobCategory(employeeJobCategory);
            if (employeePhone.matches("([0]|[374]{3}|[+374]{4})([99]|[98]|[97]|[96]" +
                    "|[95]|[94]|[93]|[91]|[77]|[55]|[44]|[43]|[41]|[33]){2}[0-9]{6}"))
                newEmployee.setEmployeePhone(employeePhone);
            if (employeeBirthData!=null)
                newEmployee.setEmployeeBirthData(employeeBirthData);
            employeeRepository.save(newEmployee);
            return "Information successfully updated";

        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }
}
