package project.courier.service;

import project.courier.data.entity.Company;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.interfaces.CompanyRegister;
import project.courier.service.model.CompanyModel;

public class CompanyRegisterImpl implements CompanyRegister {
    @Override
    public void addCompany(CompanyModel companyModel) {
        final CompanyRepositoryInjector injector = new CompanyRepositoryInjectorImpl();
        Company company = new Company();
        company.setName(companyModel.getName());
        company.setBulstat(companyModel.getBulstat());
        injector.getCompanyRepository().save(company);
    }
}
