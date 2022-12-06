package project.courier.presentation.services;

import project.courier.service.CompanyRegisterImpl;
import project.courier.service.interfaces.CompanyRegister;

public class CompanyRegisterInjectorImpl implements CompanyRegisterInjector {
    @Override
    public CompanyRegister register() {
        return new CompanyRegisterImpl();
    }
}
