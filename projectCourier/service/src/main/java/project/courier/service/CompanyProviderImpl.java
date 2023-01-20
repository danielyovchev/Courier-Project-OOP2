package project.courier.service;

import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.model.CompanyTableModel;

import java.util.List;

/**
 * service that provides company
 */
public class CompanyProviderImpl implements CompanyProvider {
    final CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();
    @Override
    public List<CompanyTableModel> getAllCompanies() {
        return companyRepositoryInjector.getCompanyRepository().findAll().stream().
                map(company -> CompanyTableModel.builder().companyId(company.getId()).companyName(company.getName()).shipmentCount(1)
                        .build()).toList();
    }

    @Override
    public long getCurrentCompanyIdByName(String name) {
        return companyRepositoryInjector.getCompanyRepository().findByName(name).get().getId();
    }

    @Override
    public List<String> getNames() {
        return companyRepositoryInjector.getCompanyRepository().findAll().stream().map(c -> c.getName()).toList();
    }

    @Override
    public String getCompanyFromCourier(String username) {
        final CourierRepositoryInjector courierRepositoryInjector = new CourierRepositoryInjectorImpl();
        return courierRepositoryInjector.getCourierRepository().findByUsername(username)
                .map(el -> companyRepositoryInjector.getCompanyRepository().findById(el.getCompanyId()))
                .map(c -> c.get().getName()).get();
    }
}
