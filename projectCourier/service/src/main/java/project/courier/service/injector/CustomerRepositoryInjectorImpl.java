package project.courier.service.injector;

import project.courier.data.repository.CustomerRepository;
import project.courier.data.repository.CustomerRepositoryImpl;
import project.courier.data.util.DBUtils;
import project.courier.service.injector.interfaces.CustomerRepositoryInjector;

public class CustomerRepositoryInjectorImpl implements CustomerRepositoryInjector {
    @Override
    public CustomerRepository getCustomerRepository() {
        return new CustomerRepositoryImpl(new DBUtils());
    }
}
