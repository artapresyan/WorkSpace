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
        if (adminUsername.matches("[a-z]{7,}|[a-z]{3,}[a-z0-9]{4,}")
                && adminPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")
                && adminPhone.matches("([0]|[374]{3}|[+374]{4})([99]|[98]|[97]|[96]|[95]|[94]|[93]" +
                "|[91]|[77]|[60]|[55]|[44]|[43]|[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}")
                && adminEmail.matches("^[a-z][a-z0-9-_\\.]+[a-z0-9]+@[a-z]+\\.[a-z]{2,3}")) {
            Admin newAdmin = new Admin(adminUsername, adminPassword, adminEmail, adminPhone);
            adminRepository.save(newAdmin);
            return "Congratulations! " + adminUsername + " registered successfully.";
        }else
            return "ERROR 404";
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
