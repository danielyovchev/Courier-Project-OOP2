package project.courier.presentation.services;

import project.courier.service.services.user.AddUserOperation;
import project.courier.service.services.user.AddUserInterface;

public class AddUserInjectorImpl implements AddUserInjector {
    @Override
    public AddUserInterface getService() {
        return new AddUserOperation();
    }
}
