package project.courier.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.Customer;
import project.courier.service.injector.CompanyRepositoryInjectorImpl;
import project.courier.service.injector.CustomerRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.CompanyRepositoryInjector;
import project.courier.service.injector.interfaces.CustomerRepositoryInjector;
import project.courier.service.interfaces.CustomerRegister;
import project.courier.service.model.CustomerModel;

public class CustomerRegisterImpl implements CustomerRegister {
    private static final Logger logger = LogManager.getLogger(CustomerRegisterImpl.class);
    @Override
    public void registerCustomer(final CustomerModel customerModel) {
        final CustomerRepositoryInjector injector = new CustomerRepositoryInjectorImpl();
        final CompanyRepositoryInjector companyRepositoryInjector = new CompanyRepositoryInjectorImpl();
        final Long companyId = companyRepositoryInjector.getCompanyRepository().findByName(customerModel.getCompany()).get().getId();
        Customer customer = new Customer();
        customer.setFirstName(customerModel.getFirstName());
        customer.setLastName(customerModel.getLastName());
        customer.setEmail(customerModel.getEmail());
        customer.setPhone(customerModel.getPhone());
        customer.setCompanyId(companyId);
        injector.getCustomerRepository().save(customer);
        logger.info("Customer "+customerModel.getFirstName()+" "+customerModel.getLastName()+" registered");
    }
}
