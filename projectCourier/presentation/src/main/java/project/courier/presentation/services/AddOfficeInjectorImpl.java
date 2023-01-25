package project.courier.presentation.services;

import project.courier.service.services.office.AddOfficeImpl;
import project.courier.service.services.office.AddOffice;

public class AddOfficeInjectorImpl implements AddOfficeInjector {
    @Override
    public AddOffice addOffice() {
        return new AddOfficeImpl();
    }
}
