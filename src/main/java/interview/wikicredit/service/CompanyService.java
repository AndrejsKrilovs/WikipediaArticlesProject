package interview.wikicredit.service;

import interview.wikicredit.data.Company;
import interview.wikicredit.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Company service to provide company information
 */
@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    /**
     * Gets all companies from database
     * @return list of companies
     */
    public List<Company> getCompanyList() {
        return companyRepository.findAll();
    }

    /**
     * Finds company by identifier
     * @param companyId is a company identifier
     * @return company from database or error message
     */
    public Company findCompanyById(Integer companyId) {
        String errorMessage = String.format("Company %d bot found!", companyId);
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException(errorMessage));
    }

    /**
     * Adds new company to database
     * @param companyToAdd company to add
     * @return added company or error message
     */
    public Company addCompany(Company companyToAdd) {
        boolean checkForDuplicate = companyRepository.findAll().stream()
                .anyMatch(company -> companyToAdd.getName().equals(company.getName()));

        if(checkForDuplicate) {
            throw new DuplicateKeyException("Company already exists in database!");
        }

        Objects.requireNonNull(companyToAdd, "Company instance cannot be empty!");

        if(companyToAdd.getName().isBlank()) {
            throw new RuntimeException("Company name cannot be empty!");
        }

        return companyRepository.save(companyToAdd);
    }
}
