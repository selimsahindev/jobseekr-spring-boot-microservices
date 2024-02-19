package com.selimsahin.jobseekr.company;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/*
 *  @Author: selimsahindev
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findById(int id) {
        return companyRepository.findById((long) id).orElse(null);
    }

    @Override
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(int id, Company company) {
        Optional<Company> companyOptional = companyRepository.findById((long) id);
        if (companyOptional.isPresent()) {
            Company updatedCompany = companyOptional.get();
            updatedCompany.setName(company.getName());
            updatedCompany.setDescription(company.getDescription());
            companyRepository.save(updatedCompany);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCompanyById(int id) {
        try {
            companyRepository.deleteById((long) id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
