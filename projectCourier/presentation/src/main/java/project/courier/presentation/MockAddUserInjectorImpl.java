package project.courier.presentation;

import project.courier.service.MockAddUserOperation;
import project.courier.service.interfaces.AddUserInterface;

public class MockAddUserInjectorImpl implements MockAddUserInjector {
    @Override
    public AddUserInterface getService() {
        return new MockAddUserOperation();
    }
}
