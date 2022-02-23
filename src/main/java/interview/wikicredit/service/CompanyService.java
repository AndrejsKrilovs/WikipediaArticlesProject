package interview.wikicredit.service;

import interview.wikicredit.data.Company;
import interview.wikicredit.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

/**
 * Company service to provide company information
 */
@Service
@RequiredArgsConstructor
public class CompanyService {
    private final static String COMPANY_NOT_FOUND_EXCEPTION = "Company %s not found!";
    private final static String DUPLICATE_COMPANY_EXCEPTION = "Company %s already exists in database!";
    private final static String COMPANY_NAME_VALIDATE_EXCEPTION = "Company name cannot be empty!";

    private final CompanyRepository companyRepository;

    /**
     * Gets all companies from database
     * @return list of companies
     */
    public List<Company> getCompanyList() {
        return companyRepository.findAll();
    }

    /**
     * Finds company by name
     * @param companyName is a name of company
     * @return company from database or error message
     */
    public Company findCompanyByName(String companyName) {
        String errorMessage = String.format(COMPANY_NOT_FOUND_EXCEPTION, companyName);
        return companyRepository.findByName(companyName)
                .orElseThrow(() -> new EntityNotFoundException(errorMessage));
    }

    /**
     * Adds new company to database
     * @param companyToAdd company to add
     * @return added company or error message
     */
    public Company addCompany(Company companyToAdd) {
        boolean checkForDuplicate = companyRepository.findAll().stream()
                .anyMatch(company -> companyToAdd.getCompanyName().equals(company.getCompanyName()));

        if(checkForDuplicate) {
            throw new DuplicateKeyException(String.format(DUPLICATE_COMPANY_EXCEPTION, companyToAdd.getCompanyName()));
        }

        if(companyToAdd.getCompanyName().isBlank()) {
            throw new ValidationException(COMPANY_NAME_VALIDATE_EXCEPTION);
        }

        Optional<Company> companyOptional = Optional.of(companyToAdd);
        companyOptional.ifPresent(companyRepository::save);

        return companyToAdd;
    }
}
