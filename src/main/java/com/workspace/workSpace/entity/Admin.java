package com.workspace.workSpace.entity;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long adminId;

    @Column(name = "username")
    private String adminUsername;

    @Column(name = "password")
    private String adminPassword;

    @Column(name = "email")
    private String adminEmail;

    @Column(name = "phone")
    private String adminPhone;

    public Admin() {
    }

    public Admin(String adminUsername, String adminPassword, String adminEmail, String adminPhone) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail;
        this.adminPhone = adminPhone;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }
}
