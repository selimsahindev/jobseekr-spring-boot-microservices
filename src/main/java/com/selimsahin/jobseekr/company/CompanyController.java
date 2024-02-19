package com.selimsahin.jobseekr.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *  @Author: selimsahindev
 */
@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getJobById(@PathVariable int id) {
        return ResponseEntity.ok(companyService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.createCompany(company));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable int id, @RequestBody Company company) {
        boolean isUpdated = companyService.updateCompany(id, company);
        if (isUpdated) {
            return ResponseEntity.ok("Company updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable int id) {
        boolean isDeleted = companyService.deleteCompanyById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Company deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
