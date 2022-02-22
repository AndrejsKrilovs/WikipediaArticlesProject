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
    private final static String COMPANY_NOT_FOUND_EXCEPTION = "Company %d not found!";
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
     * Finds company by identifier
     * @param companyId is a company identifier
     * @return company from database or error message
     */
    public Company findCompanyById(Integer companyId) {
        String errorMessage = String.format(COMPANY_NOT_FOUND_EXCEPTION, companyId);
        return companyRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException(errorMessage));
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
            throw new DuplicateKeyException(String.format(DUPLICATE_COMPANY_EXCEPTION, companyToAdd.getName()));
        }

        if(companyToAdd.getName().isBlank()) {
            throw new ValidationException(COMPANY_NAME_VALIDATE_EXCEPTION);
        }

        Optional<Company> companyOptional = Optional.of(companyToAdd);
        companyOptional.ifPresent(companyRepository::save);

        return companyToAdd;
    }
}
