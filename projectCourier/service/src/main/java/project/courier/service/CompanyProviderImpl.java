package project.courier.service;

import project.courier.data.repository.ShipmentRepository;
import project.courier.data.repository.ShipmentRepositoryImpl;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.interfaces.CompanyProvider;
import project.courier.service.model.CompanyTableModel;

import java.util.List;

public class CompanyProviderImpl implements CompanyProvider {
    final CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();
    @Override
    public List<CompanyTableModel> getAllCompanies() {
        return companyRepositoryInjector.getCompanyRepository().findAll().stream().
                map(company -> CompanyTableModel.builder().companyId(company.getId()).shipmentCount(1)
                        .build()).toList();
    }

    @Override
    public long getCurrentCompanyIdByName(String name) {
        return companyRepositoryInjector.getCompanyRepository().findByName(name).get().getId();
    }
}
