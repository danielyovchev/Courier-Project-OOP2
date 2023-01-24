package project.courier.service;

import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.CustomerRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.CustomerRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.CustomerProvider;
import project.courier.service.model.CustomerTableModel;

import java.util.List;

/**
 * service that provides list of customers
 */
public class CustomerProviderImpl implements CustomerProvider {
    private final CustomerRepositoryInjector injector = new CustomerRepositoryInjectorImpl();
    private final ShipmentRepositoryInjector shipmentRepositoryInjector = new ShipmentRepositoryInjectorImpl();
    private final CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();
    public List<CustomerTableModel> getAllCompanyCustomers(String company) {
        final Long companyId = companyRepositoryInjector.getCompanyRepository().findByName(company).get().getId();
        return injector.getCustomerRepository().findAllByCompanyID(companyId).stream()
                .map(s -> CustomerTableModel.builder()
                        .customerId(s.getId())
                        .name(s.getFirstName()+" "+s.getLastName())
                        .shipmentsCount(shipmentRepositoryInjector.getShipmentRepository().findAllByCustomer(s.getId()).size())
                        .build())
                .toList();
        //to refactor id creation
    }
}
