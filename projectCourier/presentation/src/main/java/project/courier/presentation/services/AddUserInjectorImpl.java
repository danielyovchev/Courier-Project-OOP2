package project.courier.presentation.services;

import project.courier.service.AddUserOperation;
import project.courier.service.interfaces.AddUserInterface;

public class AddUserInjectorImpl implements AddUserInjector {
    @Override
    public AddUserInterface getService() {
        return new AddUserOperation();
    }
}
