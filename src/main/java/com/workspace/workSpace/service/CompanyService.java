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
        Company newCompany=new Company(companyName,companyEmail,companyPhone,companyOfficeAddress,
                                        companyUsername,companyPassword,numOfEmployees);
        companyRepository.save(newCompany);
        return "Congratulations!"+companyName+" registered successfully.";
    }
    public String removeCompany(Long id){
        try {
            companyRepository.deleteById(id);
            return companyRepository.getById(id).getCompanyName()+" removed.";
        }catch (NoSuchElementException e){
            return "There is no company with that ID";
        }
    }

    public String editCompany(Long id,String companyName, String companyEmail, String companyPhone,
                              String companyOfficeAddress, String companyUsername,
                              String companyPassword, Long numOfEmployees){
        try {
            Company company = companyRepository.getById(id);
                company.setCompanyName(companyName);
                company.setCompanyPhone(companyPhone);
                company.setCompanyOfficeAddress(companyOfficeAddress);
                company.setCompanyUsername(companyUsername);
                company.setCompanyPassword(companyPassword);
            if (companyEmail !=null)
                company.setCompanyEmail(companyEmail);
            if (numOfEmployees!=0)
                company.setNumOfEmployees(numOfEmployees);
            companyRepository.save(company);
            return "Information successfully updated";

        }catch (NoSuchElementException e){
            return "There is no company with that ID";
        }
    }

}
