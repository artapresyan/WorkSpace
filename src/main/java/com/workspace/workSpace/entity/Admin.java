package com.workspace.workSpace.entity;

import com.workspace.workSpace.enums.User;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long adminId;

    @Column(name = "username",nullable = false)
    private String adminUsername;

    @Column(name = "password",nullable = false)
    private String adminPassword;

    @Column(name = "email",nullable = false)
    private String adminEmail;

    @Column(name = "phone",nullable = false)
    private String adminPhone;

    @Column(name = "user_type", nullable = false)
    private final String userAdmin= User.Admin.getUser();

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

    public String getUserAdmin() {
        return userAdmin;
    }

}
