package project.courier.service;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import project.courier.data.entity.Company;
import project.courier.service.exceptions.CompanyExistsException;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.model.CompanyModel;
import project.courier.service.services.company.CompanyRegister;
import project.courier.service.services.company.CompanyRegisterImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CompanyRegisterTest {
    final CompanyRegister companyRegister = new CompanyRegisterImpl();
    final CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();
    private CompanyModel companyModel = new CompanyModel("Name", "123123");
    int initialSize = companyRepositoryInjector.getCompanyRepository().findAll().size();

    @Test
    public void addCompany() {
        Company company = new Company();
        company.setName(companyModel.getName());
        company.setBulstat(companyModel.getBulstat());
        companyRepositoryInjector.getCompanyRepository().save(company);
        assertNotEquals(initialSize, companyRepositoryInjector.getCompanyRepository().findAll().size());
    }

    @Test(expected = CompanyExistsException.class)
    public void addCompanyException(){
        CompanyModel companyModel = new CompanyModel("Name", "123123");
        companyRegister.addCompany(companyModel);
    }
    @Test
    public void deleteCompany(){
        Company company = companyRepositoryInjector.getCompanyRepository().findByName(companyModel.getName()).get();
        companyRepositoryInjector.getCompanyRepository().delete(company);
        assertEquals(initialSize, companyRepositoryInjector.getCompanyRepository().findAll().size());
    }
}