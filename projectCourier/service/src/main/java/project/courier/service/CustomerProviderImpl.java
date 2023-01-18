package project.courier.service;

import project.courier.service.injector.CustomerRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CustomerRepositoryInjector;
import project.courier.service.interfaces.CustomerProvider;
import project.courier.service.model.CustomerModel;
import project.courier.service.model.ShipmentModel;

import java.util.List;

public class CustomerProviderImpl implements CustomerProvider
{
    CustomerRepositoryInjector injector = new CustomerRepositoryInjectorImpl();
    public List<CustomerModel> getAllCompanyCustomers(Long companyId)
    {
        return injector.getCustomerRepository().findAllByCompanyID(companyId).stream()
                .map(s -> CustomerModel.builder()
                        .customerId(s.getId())
                        .firstName(s.getFirstName())
                        .lastName(s.getLastName())
                        .company(s.getCompanyId().toString())
                        .email(s.getEmail())
                        .phone(s.getPhone())
                        .build())
                .toList();
    }
}