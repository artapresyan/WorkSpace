package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Admin;
import com.workspace.workSpace.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    public String removeAdmin(Long adminId, String adminPassword){
        try {
            BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
            if (bCryptPasswordEncoder.matches(adminPassword,adminRepository.getById(adminId).getAdminPassword())) {
                String name = adminRepository.getById(adminId).getAdminUsername();
                adminRepository.deleteById(adminId);
                return name + " removed.";
            }else
                return "Invalid password";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }

    public String addAdmin(String adminUsername, String adminPassword, String adminEmail, String adminPhone){
        if (adminUsername.matches("^(?=.{3,}[a-z])[a-z0-9]{4,30}$")
                && adminPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")
                && adminPhone.matches("374([99]|[98]|[97]|[96]|[95]|[94]|[93]|[91]|[77]|[60]|[55]|[44]|[43]|[41]" +
                "|[33]|[12]|[11]|[10]){2}[0-9]{6}")
                && adminEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,}")) {
            BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
            String bCryptAdminPassword=bCryptPasswordEncoder.encode(adminPassword);
            Admin newAdmin = new Admin(adminUsername, bCryptAdminPassword, adminEmail, adminPhone);
            adminRepository.save(newAdmin);
            return "Congratulations! " + adminUsername + " registered successfully.";
        }else
            return "ERROR 404";
    }

    public String editAdmin(Long adminId, String adminUsername, String adminPassword,String newAdminPassword, String adminEmail, String adminPhone) {
        try {
            Admin admin= adminRepository.getById(adminId);
            BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
            if (bCryptPasswordEncoder.matches(adminPassword,admin.getAdminPassword())) {
                if (adminUsername != null && adminUsername.matches("^(?=.{3,}[a-z])[a-z0-9]{4,30}$"))
                    admin.setAdminUsername(adminUsername);
                if (newAdminPassword != null && newAdminPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")) {
                    String bCryptNewAdminPassword=bCryptPasswordEncoder.encode(newAdminPassword);
                    admin.setAdminPassword(bCryptNewAdminPassword);
                }
                if (adminEmail != null && adminEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,}"))
                    admin.setAdminEmail(adminEmail);
                if (adminPhone != null && adminPhone.matches("374([99]|[98]|[97]|[96]|[95]|[94]|[93]|[91]|[77]|[60]|[55]|[44]|[43]|[41]" +
                        "|[33]|[12]|[11]|[10]){2}[0-9]{6}"))
                    admin.setAdminPhone(adminPhone);
                adminRepository.save(admin);
                return "Information successfully updated";
            }else
                return "Invalid password";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }
}
