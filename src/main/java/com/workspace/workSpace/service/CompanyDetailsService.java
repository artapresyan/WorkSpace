package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Company;
import com.workspace.workSpace.entity.CompanyDetails;
import com.workspace.workSpace.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CompanyDetailsService implements UserDetailsService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Company company= companyRepository.getByCompanyUsername(username);
            if (company!=null)
                return new CompanyDetails(company);
            else
                throw new UsernameNotFoundException ("Company Not Found");
    }
}
