package com.workspace.workSpace.service;

import com.workspace.workSpace.entity.Company;
import com.workspace.workSpace.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getCompanies(){
       return companyRepository.findAll();
    }

    public String addCompany(String companyName, String companyEmail, String companyPhone,
                             String companyOfficeAddress, String companyUsername,
                             String companyPassword, Long numOfEmployees){
        if (companyName.matches("^[A-Z][a-z]+") && companyOfficeAddress.matches("[\\w,/\\s&&[^_]]+")
                && companyUsername.matches("[a-z]{7,}|[a-z]{3,}[a-z0-9]{4,}")
                && companyPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")
                && companyPhone.matches("([0]|[374]{3}|[+374]{4})([99]|[98]|[97]|[96]|[95]|[94]|[93]" +
                    "|[91]|[77]|[60]|[55]|[44]|[43]|[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}")
                && companyEmail.matches("^[a-z][a-z0-9-_\\.]+[a-z0-9]+@[a-z]+\\.[a-z]{2,3}")) {
            Company newCompany = new Company(companyName, companyEmail, companyPhone, companyOfficeAddress,
                    companyUsername, companyPassword, numOfEmployees);
            companyRepository.save(newCompany);
            return "Congratulations! " + companyName + " registered successfully.";
        }else
            return "ERROR 404";
    }

    public String removeCompany(Long id){
        try {
            companyRepository.deleteById(id);
            return companyRepository.getById(id).getCompanyName()+" removed.";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }

    public String editCompany(Long id,String companyName, String companyEmail, String companyPhone,
                              String companyOfficeAddress, String companyUsername,
                              String companyPassword, Long numOfEmployees){
        try {
            Company company = companyRepository.getById(id);
            if (companyName.matches("^[A-Z][a-z]+"))
                company.setCompanyName(companyName);
            if ( companyPhone.matches("([0]|[374]{3}|[+374]{4})([99]|[98]|[97]|[96]|[95]|[94]|[93]" +
                    "|[91]|[77]|[60]|[55]|[44]|[43]|[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}"))
                company.setCompanyPhone(companyPhone);
            if (companyOfficeAddress.matches("[\\w,/\\s&&[^_]]+"))
                company.setCompanyOfficeAddress(companyOfficeAddress);
            if (companyUsername.matches("[a-z]{7,}|[a-z]{3,}[a-z0-9]{4,}"))
                company.setCompanyUsername(companyUsername);
            if (companyPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$"))
                company.setCompanyPassword(companyPassword);
            if (companyEmail.matches("^[a-z][a-z0-9-_\\.]+[a-z0-9]+@[a-z]+\\.[a-z]{2,3}"))
                company.setCompanyEmail(companyEmail);
            if (numOfEmployees!=0)
                company.setNumOfEmployees(numOfEmployees);
            companyRepository.save(company);
            return "Information successfully updated";

        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }

}
