package project.courier.service;


import project.courier.data.repository.CourierRepository;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.CourierRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.CourierRepositoryInjector;
import project.courier.service.interfaces.CourierProvider;
import project.courier.service.model.CourierModel;

import java.util.List;

public class CourierProviderImpl implements CourierProvider
{
    CourierRepositoryInjector injector = new CourierRepositoryInjectorImpl();
    CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();
    @Override
    public List<CourierModel> getAllCouriers() {
        return injector.getCourierRepository().findAll().stream().map(c -> CourierModel.builder()
                .courierId(c.getId())
                .firstName(c.getFirstName())
                .lastName(c.getLastName())
                .username(c.getUsername())
                .companyName(companyRepositoryInjector.getCompanyRepository().findById(c.getId()).get().getName())
                .build()).toList();
    }
}
