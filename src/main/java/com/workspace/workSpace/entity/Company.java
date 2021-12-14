package com.workspace.workSpace.entity;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "account_non_locked",nullable = false)
    private boolean companyNonLocked;

    @Column(name = "failed_attempt",nullable = false)
    private int companyFailedAttempt;

    @Column(name = "lock_time")
    private Date companyLockTime;

    @Column(name = "is_enabled",nullable = false)
    private boolean isCompanyEnabled;

    public Company() {
    }

    public Company(String companyName, String companyEmail, String companyPhone,
                   String companyOfficeAddress, String companyUsername,
                   String companyPassword) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPhone = companyPhone;
        this.companyOfficeAddress = companyOfficeAddress;
        this.companyUsername = companyUsername;
        this.companyPassword = companyPassword;
        this.companyNonLocked=true;
        this.companyLockTime=null;
        this.companyFailedAttempt=0;
        this.isCompanyEnabled=true;
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

    public boolean isCompanyNonLocked() {
        return companyNonLocked;
    }

    public void setCompanyNonLocked(boolean companyNonLocked) {
        this.companyNonLocked = companyNonLocked;
    }

    public int getCompanyFailedAttempt() {
        return companyFailedAttempt;
    }

    public void setCompanyFailedAttempt(int companyFailedAttempt) {
        this.companyFailedAttempt = companyFailedAttempt;
    }

    public Date getCompanyLockTime() {
        return companyLockTime;
    }

    public void setCompanyLockTime(Date companyLockTime) {
        this.companyLockTime = companyLockTime;
    }

    public boolean isCompanyEnabled() {
        return isCompanyEnabled;
    }

    public void setCompanyEnabled(boolean companyEnabled) {
        isCompanyEnabled = companyEnabled;
    }
}
