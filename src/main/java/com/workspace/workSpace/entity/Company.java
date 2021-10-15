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

    @Column(name = "email", nullable = false)
    private String companyEmail;

    @Column(name = "phone", nullable = false)
    private String companyPhone;

    @Column(name = "office_address", nullable = false)
    private String companyOfficeAddress;

    @Column(name = "username", nullable = false)
    private String companyUsername;

    @Column(name = "password", nullable = false)
    private String companyPassword;

    @Column(name = "number_of_employees")
    private int numOfEmployees;

    public Company() {
    }

    public Company(String companyName, String companyEmail, String companyPhone,
                   String companyOfficeAddress, String companyUsername,
                   String companyPassword, int numOfEmployees) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhone = companyPhone;
        this.companyOfficeAddress = companyOfficeAddress;
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

    public String getCompanyOfficeAddress() {
        return companyOfficeAddress;
    }

    public void setCompanyOfficeAddress(String companyOfficeAddress) {
        this.companyOfficeAddress = companyOfficeAddress;
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

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

}
