package project.courier.presentation.services;

import project.courier.service.CustomerRegisterImpl;
import project.courier.service.interfaces.CustomerRegister;

public class CustomerRegisterInjectorImpl implements CustomerRegisterInjector {
    @Override
    public CustomerRegister getService() {
        return new CustomerRegisterImpl();
    }
}
