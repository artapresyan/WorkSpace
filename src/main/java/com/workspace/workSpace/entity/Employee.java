package com.workspace.workSpace.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeId;

    @Column(name = "name")
    private String employeeName;

    @Column(name = "surname")
    private String employeeSurname;


    @Column(name = "sector")
    private String employeeWorkSector;

    @Column(name = "email")
    private String employeeEmail;

    @Column(name = "phone")
    private String employeePhone;

    @Column(name = "birth_date")
    private LocalDate employeeBirthData;

    @Column(name = "username")
    private String employeeUsername;

    @Column(name = "password")
    private String employeePassword;

    public Employee() {
    }

    public Employee(String employeeName, String employeeSurname, String employeeWorkSector,
                    String employeeEmail, String employeePhone, LocalDate employeeBirthData,
                    String employeeUsername, String employeePassword) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeWorkSector = employeeWorkSector;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.employeeBirthData = employeeBirthData;
        this.employeeUsername = employeeUsername;
        this.employeePassword = employeePassword;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public LocalDate getEmployeeBirthData() {
        return employeeBirthData;
    }

    public void setEmployeeBirthData(LocalDate employeeBirthData) {
        this.employeeBirthData = employeeBirthData;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeWorkSector() {
        return employeeWorkSector;
    }

    public void setEmployeeWorkSector(String employeeWorkSector) {
        this.employeeWorkSector = employeeWorkSector;
    }

}


