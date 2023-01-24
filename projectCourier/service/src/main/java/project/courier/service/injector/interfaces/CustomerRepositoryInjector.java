package project.courier.service.injector.interfaces;

import project.courier.data.repository.CustomerRepository;

public interface CustomerRepositoryInjector {
    CustomerRepository getCustomerRepository();
}
