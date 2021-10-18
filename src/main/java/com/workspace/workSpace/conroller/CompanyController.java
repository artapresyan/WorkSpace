package com.workspace.workSpace.conroller;

import com.workspace.workSpace.entity.Company;
import com.workspace.workSpace.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/all")
    public List<Company> getAllCompanies(){
        return companyService.getCompanies();
    }

    @PostMapping("/add")
    public String addNewCompany(@RequestParam String companyName,@RequestParam String companyEmail,
                                @RequestParam String companyPhone, @RequestParam String companyOfficeAddress,
                                @RequestParam String companyUsername, @RequestParam String companyPassword) {
        return companyService.addCompany(companyName, companyEmail, companyPhone, companyOfficeAddress, companyUsername,
                companyPassword);
    }
    @PutMapping("/edit")
    public String editCompanyInfo(@RequestParam(required = false) String companyName,@RequestParam(required = false) String companyEmail,
                                  @RequestParam(required = false) String companyPhone, @RequestParam(required = false) String companyOfficeAddress,
                                  @RequestParam(required = false) String companyUsername, @RequestParam(required = false) String companyPassword,
                                  @RequestParam Long companyId) {
        return companyService.editCompany(companyId, companyName, companyEmail, companyPhone, companyOfficeAddress,
                companyUsername, companyPassword);
    }

    @DeleteMapping("/remove")
    public String removeCompany(@RequestParam Long companyId,@RequestParam String companyPassword){
        return companyService.removeCompany(companyId,companyPassword);
    }
}
