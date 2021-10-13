package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Admin;
import com.workspace.workSpace.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAdmins(){
        return adminRepository.findAll();
    }

    public String removeAdmin(Long id){
        try {
            adminRepository.deleteById(id);
            return adminRepository.getById(id).getAdminUsername()+" removed.";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }

    public String addAdmin(String adminUsername, String adminPassword, String adminEmail, String adminPhone){
        Admin newAdmin=new Admin(adminUsername, adminPassword, adminEmail, adminPhone);
        adminRepository.save(newAdmin);
        return "Congratulations! "+adminUsername+" registered successfully.";
    }

    public String editAdmin(Long id, String adminUsername, String adminPassword, String adminEmail, String adminPhone){
        try {
            Admin admin= adminRepository.getById(id);
            if (adminUsername!=null)
                admin.setAdminUsername(adminUsername);
            if (adminPassword!=null)
                admin.setAdminPassword(adminPassword);
            if (adminEmail!=null)
                admin.setAdminEmail(adminEmail);
            if (adminPhone!=null)
                admin.setAdminPhone(adminPhone);
            adminRepository.save(admin);
            return "Information successfully updated";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }
}
