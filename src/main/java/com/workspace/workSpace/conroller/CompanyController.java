package com.workspace.workSpace.conroller;

import com.workspace.workSpace.entity.Company;
import com.workspace.workSpace.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.getCompanies();
    }

    @PostMapping("/home")
    public String addNewCompany(Model model, @RequestParam String companyName, @RequestParam String companyEmail,
                                @RequestParam String companyPhone, @RequestParam String companyOfficeAddress,
                                @RequestParam String companyUsername, @RequestParam String companyPassword,
                                @RequestParam String companyPasswordConfirmation) {
        companyService.addCompany(companyName, companyEmail, companyPhone, companyOfficeAddress, companyUsername,
                companyPassword, companyPasswordConfirmation);
        model.addAttribute("companyName", companyName);
        model.addAttribute("companyEmail", companyEmail);
        model.addAttribute("companyPhone", companyPhone);
        model.addAttribute("companyUsername", companyUsername);
        model.addAttribute("companyPassword", companyPassword);
        model.addAttribute("companyOfficeAddress", companyOfficeAddress);
        model.addAttribute("companyPasswordConfirmation", companyPasswordConfirmation);
        return "company_view";
    }

    @PutMapping("/edit")
    public String editCompanyInfo(@RequestParam(required = false) String companyName, @RequestParam(required = false) String companyEmail,
                                  @RequestParam(required = false) String companyPhone, @RequestParam(required = false) String companyOfficeAddress,
                                  @RequestParam(required = false) String companyUsername, @RequestParam(required = false) String newCompanyPassword,
                                  @RequestParam Long companyId, @RequestParam String companyPassword) {
        return companyService.editCompany(companyId, companyName, companyEmail, companyPhone, companyOfficeAddress,
                companyUsername, companyPassword, newCompanyPassword);
    }

    @DeleteMapping("/remove")
    public String removeCompany(@RequestParam Long companyId, @RequestParam String companyPassword) {
        return companyService.removeCompany(companyId, companyPassword);
    }
}
