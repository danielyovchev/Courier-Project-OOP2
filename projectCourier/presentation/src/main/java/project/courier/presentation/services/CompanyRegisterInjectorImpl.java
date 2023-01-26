package project.courier.presentation.services;

import project.courier.service.services.company.CompanyRegisterImpl;
import project.courier.service.services.company.CompanyRegister;

public class CompanyRegisterInjectorImpl implements CompanyRegisterInjector {
    @Override
    public CompanyRegister register() {
        return new CompanyRegisterImpl();
    }
}
