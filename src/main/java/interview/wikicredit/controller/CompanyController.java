package interview.wikicredit.controller;

import interview.wikicredit.data.Company;
import interview.wikicredit.service.CompanyService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Company endpoint representation
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/company.svc")
public class CompanyController {
    private final CompanyService companyService;

    /**
     * Endpoint for show company data
     * @return list of companies
     */
    @GetMapping
    public List<Company> getCompanyList() {
        return companyService.getCompanyList();
    }

    /**
     * Endpoint for find company
     * @param id is a company identifier
     * @return company from database
     */
    @GetMapping("/Company({id})")
    public Company getCompany(@PathVariable Integer id) {
        return companyService.findCompanyById(id);
    }

    /**
     * Endpoint for adding company.
     * @param company is object with company attributes
     * @return added company data
     */
    @PostMapping
    public Company addNewCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }
}