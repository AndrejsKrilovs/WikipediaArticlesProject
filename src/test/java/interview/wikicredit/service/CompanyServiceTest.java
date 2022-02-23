package interview.wikicredit.service;

import interview.wikicredit.data.Company;
import interview.wikicredit.repository.CompanyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

public class CompanyServiceTest {
    private final CompanyRepository companyRepository = Mockito.mock(CompanyRepository.class);
    private final CompanyService companyService = new CompanyService(companyRepository);

    @Test
    public void getCompanies() {
        Company company1 = new Company(1, "Company 1");
        Company company2 = new Company(2, "Company 2");
        Mockito.doReturn(List.of(company1, company2)).when(companyRepository.findAll());

        List<Company> companies = companyService.getCompanyList();
        Assert.assertFalse("Company list should not be empty!", companies.isEmpty());
    }

    @Test
    public void getCompanyEmptyList() {
        Mockito.doReturn(List.of()).when(companyRepository.findAll());

        List<Company> companies = companyService.getCompanyList();
        Assert.assertTrue("Company list should be empty!", companies.isEmpty());
    }

    @Test
    public void addCompanySuccess() {
        Company companyToAdd = new Company(1, "CompanyToAdd");
        companyService.addCompany(companyToAdd);
        Mockito.verify(companyRepository, Mockito.times(1)).save(companyToAdd);
    }

    @Test
    public void addDuplicateCompany() {
        Company companyToAdd = new Company(1, "CompanyToAdd");
        Mockito.doReturn(List.of(companyToAdd)).when(companyRepository.findAll());
        companyService.addCompany(companyToAdd);
        Mockito.verify(companyRepository, Mockito.times(0)).save(companyToAdd);
    }

}