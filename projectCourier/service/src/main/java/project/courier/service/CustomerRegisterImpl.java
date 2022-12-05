package project.courier.service;

import project.courier.data.entity.Customer;
import project.courier.service.injector.CustomerRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CustomerRepositoryInjector;
import project.courier.service.interfaces.CustomerRegister;
import project.courier.service.model.CustomerModel;

public class CustomerRegisterImpl implements CustomerRegister {
    @Override
    public void registerCustomer(final CustomerModel customerModel) {
        final CustomerRepositoryInjector injector = new CustomerRepositoryInjectorImpl();
        Customer customer = new Customer();
        customer.setFirstName(customerModel.getFirstName());
        customer.setLastName(customerModel.getLastName());
        customer.setEmail(customerModel.getEmail());
        injector.getCustomerRepository().save(customer);
    }
}
