package com.workspace.workSpace.enums;

import com.workspace.workSpace.entity.Admin;
import com.workspace.workSpace.entity.Company;

public enum User {
    Employee("employee"),
    Admin("admin"),
    Company("company");

    private final String user;

    User(String user){
        this.user=user;
    }
    public String getUser(){
        return user;
    }
}
