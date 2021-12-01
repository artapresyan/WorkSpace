package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Company;
import com.workspace.workSpace.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public void addCompany(String companyName, String companyEmail, String companyPhone,
                           String companyOfficeAddress, String companyUsername,
                           String companyPassword, String companyPasswordConfirmation) {
        if (companyRepository.getByCompanyUsername(companyUsername)==null &&
                companyRepository.getByCompanyName(companyName) == null &&
                companyRepository.getByCompanyEmail(companyEmail) == null) {
            if (companyName.matches(".{2,}") && companyUsername.matches("^(?=.{3,}[a-z])[a-z0-9]{4,30}$")
                    && companyOfficeAddress.matches("[\\w,/\\s&&[^_]]{4,}")
                    && companyPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")
                    && companyPhone.matches("374([99]|[98]|[97]|[96]|[95]|[94]|[93]" +
                    "|[91]|[77]|[60]|[55]|[44]|[43]|[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}")
                    && companyEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,}")
                    && companyPasswordConfirmation.matches(companyPassword)) {
                String bCryptCompanyPassword = bCryptPasswordEncoder.encode(companyPassword);
                Company newCompany = new Company(companyName, companyEmail, companyPhone, companyOfficeAddress,
                        companyUsername, bCryptCompanyPassword);
                companyRepository.save(newCompany);
            }
        }
    }

    public String removeCompany(Long companyId, String companyPassword) {
        try {
            if (bCryptPasswordEncoder.matches(companyPassword, companyRepository.getById(companyId).getCompanyPassword())) {
                String name = companyRepository.getById(companyId).getCompanyName();
                companyRepository.deleteById(companyId);
                return name + " removed.";
            } else
                return "Invalid Password";
        } catch (NoSuchElementException e) {
            return "ERROR 404";
        }
    }

    public String editCompany(Long companyId, String companyName, String companyEmail, String companyPhone,
                              String companyOfficeAddress, String companyUsername,
                              String companyPassword, String newCompanyPassword) {
        try {
            Company company = companyRepository.getById(companyId);
            if (bCryptPasswordEncoder.matches(companyPassword, company.getCompanyPassword())) {
                if (companyName != null && companyName.matches(".{2,}"))
                    company.setCompanyName(companyName);
                if (companyPhone != null && companyPhone.matches("374([99]|[98]|[97]|[96]|[95]|[94]|[93]" +
                        "|[91]|[77]|[60]|[55]|[44]|[43]|[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}"))
                    company.setCompanyPhone(companyPhone);
                if (companyOfficeAddress != null && companyOfficeAddress.matches("[\\w,/\\s&&[^_]]{4,}"))
                    company.setCompanyOfficeAddress(companyOfficeAddress);
                if (companyUsername != null && companyUsername.matches("^(?=.{3,}[a-z])[a-z0-9]{4,30}$"))
                    company.setCompanyUsername(companyUsername);
                if (newCompanyPassword != null && newCompanyPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)" +
                        "(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")) {
                    String bCryptNewCompanyPassword = bCryptPasswordEncoder.encode(newCompanyPassword);
                    company.setCompanyPassword(bCryptNewCompanyPassword);
                }
                if (companyEmail != null && companyEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,}"))
                    company.setCompanyEmail(companyEmail);
                companyRepository.save(company);
                return "Information successfully updated";
            } else
                return "Invalid password";
        } catch (NoSuchElementException e) {
            return "ERROR 404";
        }
    }

}
