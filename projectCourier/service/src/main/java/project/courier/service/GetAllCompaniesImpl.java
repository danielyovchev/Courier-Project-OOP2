package project.courier.service;

import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.interfaces.GetAllCompanies;

import java.util.List;

public class GetAllCompaniesImpl implements GetAllCompanies {
    @Override
    public List<String> getNames() {
        final CompanyRepositoryInjector injector = new CompanyRepositoryInjectorImpl();
        return injector.getCompanyRepository().findAll().stream().map(c -> c.getName()).toList();
    }
}
