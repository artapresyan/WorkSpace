package com.workspace.workSpace.conroller;

import com.workspace.workSpace.entity.Company;
import com.workspace.workSpace.entity.CompanyDetails;
import com.workspace.workSpace.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/all")
    public List<Company> getAllCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("/login-error")
    public String companyLoginErrorCase(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String errorMessage = null;
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                errorMessage = ex.getMessage();
            }
        }
        model.addAttribute("errorMessage", errorMessage);

        return "redirect:/company/login";
    }

    @GetMapping("/home")
    public String getCompanyHomepage(Authentication authentication, Model model) {
        try {
            CompanyDetails companyDetails = (CompanyDetails) authentication.getPrincipal();
            Company company = companyDetails.getCompany();
            model.addAttribute("company", company);
            return "company_view";
        } catch (NoSuchElementException e) {
            return "redirect:/company/login";
        }
    }

    @PostMapping("/registration")
    public String addNewCompany(@RequestParam(value = "compName") String companyName, @RequestParam(value = "compEmail") String companyEmail,
                                @RequestParam(value = "compPhone") String companyPhone, @RequestParam(value = "compOfficeAddress") String companyOfficeAddress,
                                @RequestParam(value = "compUsername") String companyUsername, @RequestParam(value = "compPassword") String companyPassword,
                                @RequestParam(value = "compPasswordConfirmation") String companyPasswordConfirmation,
                                @RequestParam(value="numOfEmployees") String numOfEmployees) {
        companyService.addCompany(companyName, companyEmail, companyPhone, companyOfficeAddress, companyUsername,
                companyPassword, companyPasswordConfirmation,numOfEmployees);
        return "redirect:/company/login";
    }

    @PutMapping("/edit")
    public String editCompanyInfo(@RequestParam(required = false) String companyName, @RequestParam(required = false) String companyEmail,
                                  @RequestParam(required = false) String companyPhone, @RequestParam(required = false) String companyOfficeAddress,
                                  @RequestParam(required = false) String companyUsername, @RequestParam(required = false) String newCompanyPassword,
                                  @RequestParam Long companyId, @RequestParam String companyPassword,
                                  @RequestParam(required = false) String numOfEmployees) {
        return companyService.editCompany(companyId, companyName, companyEmail, companyPhone, companyOfficeAddress,
                companyUsername, companyPassword, newCompanyPassword,numOfEmployees);
    }

    @DeleteMapping("/remove")
    public String removeCompany(@RequestParam Long companyId, @RequestParam String companyPassword) {
        return companyService.removeCompany(companyId, companyPassword);
    }
}
