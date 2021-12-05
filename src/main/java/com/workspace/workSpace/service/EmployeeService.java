package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Employee;
import com.workspace.workSpace.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(String employeeName, String employeeSurname, String employeeJobCategory,
                            String employeeEmail, String employeePhone, String employeeBirthData,
                            String employeeUsername, String employeePassword, String employeeGender,
                            String employeePasswordConfirmation) {
        if (employeeRepository.getByEmployeeEmail(employeeEmail) == null &&
                employeeRepository.getByEmployeeUsername(employeeUsername) == null) {
            if (employeeName.matches("^[A-Z][a-z]{2,20}$") && employeeSurname.matches("^[A-Z][a-z]{2,30}$")
                    && employeeJobCategory.matches("[a-zA-z\\s/]{2,}")
                    && employeeUsername.matches("^(?=.{3,}[a-z])[a-z0-9]{4,30}$")
                    && employeePassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")
                    && employeePasswordConfirmation.matches(employeePassword)
                    && (employeePhone.length() == 0 || employeePhone.matches("374([9]{2}|[98]|[97]|[96]|[95]|[94]|[93]" +
                    "|[91]|[7]{2}|[60]|[5]{2}|[4]{2}|[43]|[41]|[3]{2}|[12]|[1]{2}|[10]){2}[0-9]{6}"))
                    && employeeEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,}")
                    && (employeeBirthData.length() == 0 || employeeBirthData.matches("(19[2-9][0-9]|20[0-1][0-9]|202[0-1])/(0[1-9]|1[0-2])/" +
                    "(0[1-9]|[1-2][0-9]|3[0-1])"))) {
                String bCryptEmployeePassword = bCryptPasswordEncoder.encode(employeePassword);
                Employee newEmployee = new Employee(employeeName, employeeSurname, employeeJobCategory, employeeEmail,
                        employeePhone, employeeBirthData, employeeUsername, bCryptEmployeePassword, employeeGender);
                employeeRepository.save(newEmployee);
            }
        }
    }

    public String removeEmployee(Long employeeId, String employeePassword) {
        try {
            if (bCryptPasswordEncoder.matches(employeePassword, employeeRepository.getById(employeeId).getEmployeePassword())) {
                String name = employeeRepository.getById(employeeId).getEmployeeUsername();
                employeeRepository.deleteById(employeeId);
                return name + "'s profile removed.";
            } else
                return "Invalid password";
        } catch (NoSuchElementException e) {
            return "ERROR 404";
        }
    }

    public String editEmployee(Long employeeId, String employeeName, String employeeSurname, String employeeJobCategory,
                               String employeeEmail, String employeePhone, String employeeBirthData,
                               String employeeUsername, String employeePassword, String newEmployeePassword,
                               String employeeGender) {
        try {
            Employee employee = employeeRepository.getById(employeeId);
            if (bCryptPasswordEncoder.matches(employeePassword, employee.getEmployeePassword())) {
                if (employeeName != null && employeeName.matches("^[A-Z][a-z]{2,20}$"))
                    employee.setEmployeeName(employeeName);
                if (employeeSurname != null && employeeSurname.matches("^[A-Z][a-z]{2,30}$"))
                    employee.setEmployeeSurname(employeeSurname);
                if (employeeEmail != null && employeeEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,}")
                        && employeeRepository.getByEmployeeEmail(employeeEmail) == null)
                    employee.setEmployeeEmail(employeeEmail);
                if (employeeUsername != null && employeeUsername.matches("^(?=.{3,}[a-z])[a-z0-9]{4,30}$")
                        && employeeRepository.getByEmployeeUsername(employeeUsername) == null)
                    employee.setEmployeeUsername(employeeUsername);
                if (newEmployeePassword != null && newEmployeePassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)" +
                        "(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")) {
                    String bCryptNewEmployeePassword = bCryptPasswordEncoder.encode(newEmployeePassword);
                    employee.setEmployeePassword(bCryptNewEmployeePassword);
                }
                if (employeeJobCategory != null && employeeJobCategory.matches("[a-zA-z\\s]{2,}"))
                    employee.setEmployeeJobCategory(employeeJobCategory);
                if (employeePhone != null && employeePhone.matches("374([9]{2}|[98]|[97]|[96]|[95]|[94]|[93]" +
                        "|[91]|[7]{2}|[60]|[5]{2}|[4]{2}|[43]|[41]|[3]{2}|[12]|[1]{2}|[10]){2}[0-9]{6}"))
                    employee.setEmployeePhone(employeePhone);
                if (employeeBirthData != null && employeeBirthData.matches("(19[2-9][0-9]|20[0-1][0-9]|202[0-1])/(0[1-9]" +
                        "|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])"))
                    employee.setEmployeeBirthData(employeeBirthData);
                if (employeeGender != null)
                    employee.setEmployeeGender(employeeGender);
                employeeRepository.save(employee);
                return "Information successfully updated";
            } else
                return "Invalid password";
        } catch (NoSuchElementException e) {
            return "ERROR 404";
        }
    }
}
