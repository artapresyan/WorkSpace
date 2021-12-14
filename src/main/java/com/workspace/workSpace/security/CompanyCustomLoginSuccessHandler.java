package com.workspace.workSpace.security;

import com.workspace.workSpace.entity.Company;
import com.workspace.workSpace.entity.CompanyDetails;
import com.workspace.workSpace.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CompanyCustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private CompanyService companyService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        CompanyDetails companyDetails = (CompanyDetails) authentication.getPrincipal();
        Company company = companyDetails.getCompany();
        if (company.getCompanyFailedAttempt() > 0)
            companyService.resetCompanyFailedAttempts(company.getCompanyUsername());
        super.setDefaultTargetUrl("/company/home");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
