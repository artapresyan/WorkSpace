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
                             String companyPassword, int numOfEmployees){
        if (companyName.matches(".{2,}") && companyOfficeAddress.matches("[\\w,/\\s&&[^_]]{4,}")
                && companyUsername.matches("^(?=.{3,}[a-z])[a-z0-9]{4,30}$")
                && companyPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$")
                && companyPhone.matches("[+374]{4}([99]|[98]|[97]|[96]|[95]|[94]|[93]" +
                    "|[91]|[77]|[60]|[55]|[44]|[43]|[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}")
                && companyEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,}")) {
            Company newCompany = new Company(companyName, companyEmail, companyPhone, companyOfficeAddress,
                    companyUsername, companyPassword, numOfEmployees);
            companyRepository.save(newCompany);
            return "Congratulations! " + companyName + " registered successfully.";
        }else
            return "ERROR 404";
    }

    public String removeCompany(Long id, String password){
        try {
            if (password.equals(companyRepository.getById(id).getCompanyPassword())) {
                companyRepository.deleteById(id);
                return companyRepository.getById(id).getCompanyName() + " removed.";
            }else
                return "Invalid Password";
        }catch (NoSuchElementException e){
            return "ERROR 404";
        }
    }

    public String editCompany(Long id,String companyName, String companyEmail, String companyPhone,
                              String companyOfficeAddress, String companyUsername,
                              String companyPassword, int numOfEmployees){
        try {
            Company company = companyRepository.getById(id);
            if (companyName.matches("^[A-Z][a-z]{2,}"))
                company.setCompanyName(companyName);
            if ( companyPhone.matches("[+374]{4}([99]|[98]|[97]|[96]|[95]|[94]|[93]" +
                    "|[91]|[77]|[60]|[55]|[44]|[43]|[41]|[33]|[12]|[11]|[10]){2}[0-9]{6}"))
                company.setCompanyPhone(companyPhone);
            if (companyOfficeAddress.matches("[\\w,/\\s&&[^_]]{4,}"))
                company.setCompanyOfficeAddress(companyOfficeAddress);
            if (companyUsername.matches("[a-z]{7,}|[a-z]{3,}[a-z0-9]{4,30}"))
                company.setCompanyUsername(companyUsername);
            if (companyPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$"))
                company.setCompanyPassword(companyPassword);
            if (companyEmail.matches("^[a-z][a-z0-9-_.]+[a-z0-9]+@[a-z]+\\.[a-z.]{2,}"))
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
