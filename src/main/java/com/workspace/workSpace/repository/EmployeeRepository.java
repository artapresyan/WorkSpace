package com.workspace.workSpace.repository;

import com.workspace.workSpace.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
      List<Employee> getByEmployeeEmail(String employeeEmail);
      List<Employee> getByEmployeeUsername(String employeeUsername);
      List<Employee> getByEmployeeEmailAndEmployeePassword(String employeeEmail,String employeePassword);
      List<Employee> getByEmployeeUsernameAndEmployeePassword(String employeeUsername,String employeePassword);
}
