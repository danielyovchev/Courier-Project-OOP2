package project.courier.service;

import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.interfaces.GetAllCompanies;

import java.util.List;

public class GetAllCompaniesImpl implements GetAllCompanies {

    final CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();
    @Override
    public List<String> getNames() {
        final CompanyRepositoryInjector injector = new CompanyRepositoryInjectorImpl();
        return injector.getCompanyRepository().findAll().stream().map(c -> c.getName()).toList();
    }

    @Override
    public String getCompanyFromCourier(String username) {
        final CourierRepositoryInjector courierRepositoryInjector = new CourierRepositoryInjectorImpl();
        final CompanyRepositoryInjector injector = new CompanyRepositoryInjectorImpl();
        return courierRepositoryInjector.getCourierRepository().findByUsername(username)
                .map(el -> injector.getCompanyRepository().findById(el.getCompanyId()))
                .map(c -> c.get().getName()).get();
    }

    @Override
    public List<Long> getAllId() {
        return companyRepositoryInjector.getCompanyRepository().findAll().stream().map(c -> c.getId()).toList();
    }
}
