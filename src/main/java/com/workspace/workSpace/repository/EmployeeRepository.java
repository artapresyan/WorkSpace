package com.workspace.workSpace.repository;

import com.workspace.workSpace.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee getByEmployeeEmail(String employeeEmail);

    Employee getByEmployeeUsername(String employeeUsername);
}
