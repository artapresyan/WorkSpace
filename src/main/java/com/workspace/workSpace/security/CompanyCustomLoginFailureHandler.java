package com.workspace.workSpace.security;

import com.workspace.workSpace.entity.Company;
import com.workspace.workSpace.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CompanyCustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private CompanyService companyService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String username = request.getParameter("username");
        Company company = companyService.getCompanyByUsername(username);
        if (company != null) {
            if (company.isCompanyEnabled() && company.isCompanyNonLocked()) {
                if (company.getCompanyFailedAttempt() < CompanyService.companyMaxFailAttempts) {
                    companyService.increaseCompanyFailedAttempts(company);
                } else {
                    companyService.lockCompanyForAttempts(company);
                    exception = new LockedException("Your company's account has been locked due to 3 failed attempts."
                            + " It will be unlocked after 24 hours.");
                }
            } else if (!company.isCompanyNonLocked()) {
                if (companyService.unlockCompanyForAttempts(company)) {
                    exception = new LockedException("Your company's account has been unlocked. Please try to login again.");
                }
            }

        }
        super.setDefaultFailureUrl("/company/login?error");
        super.onAuthenticationFailure(request, response, exception);
    }
}
