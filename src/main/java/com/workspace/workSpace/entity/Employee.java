package com.workspace.workSpace.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
    private LocalDate employeeBirthDate;

    @Column(name = "username", nullable = false)
    private String employeeUsername;

    @Column(name = "password", nullable = false)
    private String employeePassword;

    @Column(name = "Gender")
    private String employeeGender;

    @Column(name = "account_non_locked",nullable = false)
    private boolean employeeNonLocked;

    @Column(name = "failed_attempt",nullable = false)
    private int employeeFailedAttempt;

    @Column(name = "lock_time")
    private Date employeeLockTime;

    @Column(name = "is_enabled",nullable = false)
    private boolean isEmployeeEnabled;

    @Column(name = "employee_non_expired",nullable = false)
    private boolean employeeNonExpired;

    @Column(name = "last_login",nullable = false)
    private LocalDate lastLogin;

    public Employee() {
    }

    public Employee(String employeeName, String employeeSurname, String employeeJobCategory,
                    String employeeEmail, String employeePhone, String employeeBirthDate,
                    String employeeUsername, String employeePassword, String employeeGender) {
        if (employeeBirthDate != null && employeeBirthDate.length() != 0) {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/M/d");
            this.employeeBirthDate = LocalDate.parse(employeeBirthDate, dateFormat);
        } else {
            this.employeeBirthDate = null;
        }
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeJobCategory = employeeJobCategory;
        this.employeeEmail = employeeEmail;
        this.employeePhone = employeePhone;
        this.employeeUsername = employeeUsername;
        this.employeePassword = employeePassword;
        this.employeeGender = employeeGender;
        this.employeeNonLocked=true;
        this.employeeFailedAttempt=0;
        this.employeeLockTime=null;
        this.isEmployeeEnabled=true;
        this.employeeNonExpired=true;
        this.lastLogin=LocalDate.now();
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

    public LocalDate getEmployeeBirthDate() {
        return employeeBirthDate;
    }

    public void setEmployeeBirthDate(String employeeBirthDate) {
        if (employeeBirthDate.length() == 0) {
            this.employeeBirthDate = null;
        } else {
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/M/d");
            this.employeeBirthDate = LocalDate.parse(employeeBirthDate, dateFormat);
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

    public boolean isEmployeeNonLocked() {
        return employeeNonLocked;
    }

    public void setEmployeeNonLocked(boolean employeeNonLocked) {
        this.employeeNonLocked = employeeNonLocked;
    }

    public int getEmployeeFailedAttempt() {
        return employeeFailedAttempt;
    }

    public void setEmployeeFailedAttempt(int employeeFailedAttempt) {
        this.employeeFailedAttempt = employeeFailedAttempt;
    }

    public Date getEmployeeLockTime() {
        return employeeLockTime;
    }

    public void setEmployeeLockTime(Date employeeLockTime) {
        this.employeeLockTime = employeeLockTime;
    }

    public boolean isEmployeeEnabled() {
        return isEmployeeEnabled;
    }

    public void setEmployeeEnabled(boolean employeeEnabled) {
        isEmployeeEnabled = employeeEnabled;
    }

    public boolean isEmployeeNonExpired() {
        return employeeNonExpired;
    }

    public void setEmployeeNonExpired(boolean employeeNonExpired) {
        this.employeeNonExpired = employeeNonExpired;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }
}


