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
        Employee newEmployee=new Employee(employeeName,employeeSurname,employeeJobCategory,employeeEmail,
                                            employeePhone,employeeBirthData,employeeUsername,employeePassword);
        employeeRepository.save(newEmployee);
        return "Congratulations Mr."+employeeSurname+"! "+"Now you are a member of WorkSpace.";
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
            Employee employee = employeeRepository.getById(id);
            if (employeeName !=null)
            employee.setEmployeeName(employeeName);
            if (employeeSurname !=null)
            employee.setEmployeeSurname(employeeSurname);
            if (employeeEmail !=null)
            employee.setEmployeeEmail(employeeEmail);
            if (employeeUsername !=null)
            employee.setEmployeeUsername(employeeUsername);
            if (employeePassword !=null)
            employee.setEmployeePassword(employeePassword);
            if (employeeJobCategory !=null)
                employee.setEmployeeJobCategory(employeeJobCategory);
            if (employeePhone!=null)
                employee.setEmployeePhone(employeePhone);
            if (employeeBirthData!=null)
                employee.setEmployeeBirthData(employeeBirthData);
            employeeRepository.save(employee);
            return "Information successfully updated";

        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }
}
