package com.workspace.workSpace.entity;

import javax.persistence.*;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long companyId;

    @Column(name = "name", nullable = false)
    private String companyName;

    @Column(name = "email")
    private String companyEmail;

    @Column(name = "phone", nullable = false)
    private String companyPhone;

    @Column(name = "office_address", nullable = false)
    private String companyOfficeAddress;

    @Column(name = "username", nullable = false)
    private String companyUsername;

    @Column(name = "password", nullable = false)
    private String companyPassword;

    @Column(name = "employees")
    private Long numOfEmployees;

    public Company() {
    }

    public Company(String companyName, String companyEmail, String companyPhone,
                   String companyMainOfficeAddress, String companyUsername,
                   String companyPassword, Long numOfEmployees) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhone = companyPhone;
        this.companyOfficeAddress = companyMainOfficeAddress;
        this.companyUsername = companyUsername;
        this.companyPassword = companyPassword;
        this.numOfEmployees = numOfEmployees;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCompanyMainOfficeAddress() {
        return companyOfficeAddress;
    }

    public void setCompanyMainOfficeAddress(String companyMainOfficeAddress) {
        this.companyOfficeAddress = companyMainOfficeAddress;
    }

    public String getCompanyUsername() {
        return companyUsername;
    }

    public void setCompanyUsername(String companyUsername) {
        this.companyUsername = companyUsername;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public Long getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setNumOfEmployees(Long numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }
}
