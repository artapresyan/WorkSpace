package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Employee;
import com.workspace.workSpace.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
                              String employeeEmail, String employeePhone, String employeeBirthData,
                              String employeeUsername, String employeePassword){
        if (employeeName.matches("^[A-Z][a-z]{2,20}$") && employeeSurname.matches("^[A-Z][a-z]{2,30}$")
                && employeeJobCategory.matches("[a-zA-z\\s]{2,}")
                && employeeUsername.matches("^(?=.{3,}[a-z])[a-z0-9]{4,30}$")
                && employeePassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")
                && employeePhone.matches("374([99]|[98]|[97]|[96]|[95]|[94]|[93]" +
                "|[91]|[77]|[60]|[55]|[44]|[43]|[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}")
                && employeeEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,}")
                && employeeBirthData.matches("(19[2-9][0-9]|20[0-1][0-9]|202[0-1])/(0[1-9]|1[0-2])/" +
                "(0[1-9]|[1-2][0-9]|3[0-1])")){
            Employee newEmployee=new Employee(employeeName,employeeSurname,employeeJobCategory,employeeEmail,
                    employeePhone,employeeBirthData,employeeUsername,employeePassword);
            employeeRepository.save(newEmployee);
            return "Congratulations Mr."+employeeSurname+"! "+"Now you are a member of WorkSpace.";
        }else
            return "ERROR 404";
    }

    public String removeEmployee(Long employeeId, String password){
        try {
            if (password.equals(employeeRepository.getById(employeeId).getEmployeePassword())) {
                String name = employeeRepository.getById(employeeId).getEmployeeUsername();
                employeeRepository.deleteById(employeeId);
                return name + "'s profile removed.";
            }else
                return "Invalid password";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }

    public String editEmployee(Long employeeId,String employeeName, String employeeSurname, String employeeJobCategory,
                               String employeeEmail, String employeePhone, String employeeBirthData,
                               String employeeUsername, String employeePassword){
        try {
            Employee newEmployee = employeeRepository.getById(employeeId);
            if (employeeName!=null && employeeName.matches("^[A-Z][a-z]{2,20}$"))
                newEmployee.setEmployeeName(employeeName);
            if (employeeSurname!=null && employeeSurname.matches("^[A-Z][a-z]{2,30}$"))
                newEmployee.setEmployeeSurname(employeeSurname);
            if (employeeEmail!=null && employeeEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,}"))
                newEmployee.setEmployeeEmail(employeeEmail);
            if (employeeUsername!=null && employeeUsername.matches("^(?=.{3,}[a-z])[a-z0-9]{4,30}$"))
                newEmployee.setEmployeeUsername(employeeUsername);
            if (employeePassword!=null && employeePassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$"))
                newEmployee.setEmployeePassword(employeePassword);
            if (employeeJobCategory!=null && employeeJobCategory.matches("[a-zA-z\\s]{2,}"))
                newEmployee.setEmployeeJobCategory(employeeJobCategory);
            if (employeePhone!=null && employeePhone.matches("374([99]|[98]|[97]|[96]|[95]|[94]|[93]" +
                    "|[91]|[77]|[60]|[55]|[44]|[43]|[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}"))
                newEmployee.setEmployeePhone(employeePhone);
            if (employeeBirthData!=null && employeeBirthData.matches("(19[2-9][0-9]|20[0-1][0-9]|202[0-1])/(0[1-9]" +
                    "|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])"))
                newEmployee.setEmployeeBirthData(employeeBirthData);
            employeeRepository.save(newEmployee);
            return "Information successfully updated";

        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }
}
