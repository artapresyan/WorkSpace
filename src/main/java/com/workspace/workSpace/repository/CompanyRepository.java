package com.workspace.workSpace.repository;

import com.workspace.workSpace.entity.Company;
import com.workspace.workSpace.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company getByCompanyEmail(String companyEmail);
    Company getByCompanyUsername(String companyUsername);
    Company getByCompanyName(String companyName);
    Company getByCompanyEmailAndCompanyPassword(String companyEmail,String companyPassword);
    Company getByCompanyUsernameAndCompanyPassword(String companyUsername,String companyPassword);
}
