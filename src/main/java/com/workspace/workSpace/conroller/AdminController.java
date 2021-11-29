package com.workspace.workSpace.conroller;

import com.workspace.workSpace.entity.Admin;
import com.workspace.workSpace.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAllAdmins(){
       return adminService.getAdmins();
    }

    @PostMapping("/add")
    public String addAdmin(@RequestParam String adminUsername,@RequestParam String adminPassword,
                           @RequestParam String adminEmail,@RequestParam String adminPhone){
        return adminService.addAdmin(adminUsername,adminPassword,adminEmail,adminPhone);
    }

    @PutMapping("/edit")
    public String editAdmin(@RequestParam(required = false) String adminUsername,@RequestParam(required = false) String newAdminPassword,
                            @RequestParam(required = false) String adminEmail,@RequestParam(required = false) String adminPhone,
                            @RequestParam Long adminId,@RequestParam String adminPassword){
       return adminService.editAdmin(adminId, adminUsername, adminPassword, newAdminPassword, adminEmail, adminPhone);
    }

    @DeleteMapping("/remove")
    public String removeAdmin(@RequestParam Long adminId,String adminPassword){
       return adminService.removeAdmin(adminId,adminPassword);
    }
}
