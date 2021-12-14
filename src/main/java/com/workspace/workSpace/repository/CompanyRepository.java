package com.workspace.workSpace.repository;

import com.workspace.workSpace.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company getByCompanyEmail(String companyEmail);

    Company getByCompanyUsername(String companyUsername);

    Company getByCompanyName(String companyName);
}
