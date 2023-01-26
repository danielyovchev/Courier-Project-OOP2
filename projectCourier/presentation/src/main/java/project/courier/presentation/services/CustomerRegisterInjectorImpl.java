package project.courier.presentation.services;

import project.courier.service.services.customer.CustomerRegisterImpl;
import project.courier.service.services.customer.CustomerRegister;

public class CustomerRegisterInjectorImpl implements CustomerRegisterInjector {
    @Override
    public CustomerRegister getService() {
        return new CustomerRegisterImpl();
    }
}
