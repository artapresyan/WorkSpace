package com.workspace.workSpace.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long employeeId;

    @Column(name = "name", nullable = false)
    private String employeeName;

    @Column(name = "surname", nullable = false)
    private String employeeSurname;

    @Column(name = "job_category", nullable = false)
    private String employeeJobCategory;

    @Column(name = "email", nullable = false)
    private String employeeEmail;

    @Column(name = "phone")
    private String employeePhone;

    @Column(name = "birth_date")
    private LocalDate employeeBirthData;

    @Column(name = "username", nullable = false)
    private String employeeUsername;

    @Column(name = "password", nullable = false)
    private String employeePassword;

    @Column(name = "Gender")
    private String employeeGender;

    public Employee() {
    }

    public Employee(String employeeName, String employeeSurname, String employeeJobCategory,
                    String employeeEmail, String employeePhone, String employeeBirthData,
                    String employeeUsername, String employeePassword, String employeeGender) {
        if (employeeBirthData != null && employeeBirthData.length() != 0) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/M/d");
            this.employeeBirthData = LocalDate.parse(employeeBirthData, dateFormat);
        } else {
            this.employeeBirthData = null;
        }
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeJobCategory = employeeJobCategory;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.employeeUsername = employeeUsername;
        this.employeePassword = employeePassword;
        this.employeeGender = employeeGender;
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
        if (employeePhone.length() == 0)
            this.employeePhone = null;
        else
            this.employeePhone = employeePhone;
    }

    public LocalDate getEmployeeBirthData() {
        return employeeBirthData;
    }

    public void setEmployeeBirthData(String employeeBirthData) {
        if (employeeBirthData.length() == 0) {
            this.employeeBirthData = null;
        } else {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/M/d");
            this.employeeBirthData = LocalDate.parse(employeeBirthData, dateFormat);
        }
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

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

}


