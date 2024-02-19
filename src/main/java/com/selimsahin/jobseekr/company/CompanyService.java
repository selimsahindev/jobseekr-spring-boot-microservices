package com.selimsahin.jobseekr.company;

import java.util.List;

/*
 *  @Author: selimsahindev
 */
public interface CompanyService {
    List<Company> findAll();
    Company findById(int id);

    Company createCompany(Company company);

    boolean updateCompany(int id, Company company);
    boolean deleteCompanyById(int id);
}
