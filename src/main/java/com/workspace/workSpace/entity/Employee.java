package com.workspace.workSpace.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeId;

    @Column(name = "name", nullable = false)
    private String employeeName;

    @Column(name = "surname",nullable = false)
    private String employeeSurname;

    @Column(name = "job_category", nullable = false)
    private String employeeJobCategory;

    @Column(name = "email",nullable = false)
    private String employeeEmail;

    @Column(name = "phone")
    private String employeePhone;

    @Column(name = "birth_date")
    private LocalDate employeeBirthData;

    @Column(name = "username",nullable = false)
    private String employeeUsername;

    @Column(name = "password",nullable = false)
    private String employeePassword;

    public Employee() {
    }

    public Employee(String employeeName, String employeeSurname, String employeeJobCategory,
                    String employeeEmail, String employeePhone, LocalDate employeeBirthData,
                    String employeeUsername, String employeePassword) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeJobCategory = employeeJobCategory;
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

    public String getEmployeeJobCategory() {
        return employeeJobCategory;
    }

    public void setEmployeeJobCategory(String employeeWorkSector) {
        this.employeeJobCategory = employeeWorkSector;
    }

}


