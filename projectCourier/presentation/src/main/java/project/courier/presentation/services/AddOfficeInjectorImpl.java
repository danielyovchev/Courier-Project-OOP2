package project.courier.presentation.services;

import project.courier.service.AddOfficeImpl;
import project.courier.service.interfaces.AddOffice;

public class AddOfficeInjectorImpl implements AddOfficeInjector {
    @Override
    public AddOffice addOffice() {
        return new AddOfficeImpl();
    }
}
