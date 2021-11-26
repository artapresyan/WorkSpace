package com.workspace.workSpace.repository;

import com.workspace.workSpace.entity.Company;
import com.workspace.workSpace.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    List<Company> getByCompanyEmail(String companyEmail);
    List<Company> getByCompanyUsername(String companyUsername);
    List<Company> getByCompanyName(String companyName);
    List<Company> getByCompanyEmailAndCompanyPassword(String companyEmail,String companyPassword);
    List<Company> getByCompanyUsernameAndCompanyPassword(String companyUsername,String companyPassword);
}
