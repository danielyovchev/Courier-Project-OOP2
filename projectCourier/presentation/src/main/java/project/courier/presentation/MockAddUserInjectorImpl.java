package project.courier.presentation;

import project.courier.service.MockAddUserOperation;
import project.courier.service.interfaces.MockAddUserInterface;

public class MockAddUserInjectorImpl implements MockAddUserInjector {
    @Override
    public MockAddUserInterface getService() {
        return new MockAddUserOperation();
    }
}
