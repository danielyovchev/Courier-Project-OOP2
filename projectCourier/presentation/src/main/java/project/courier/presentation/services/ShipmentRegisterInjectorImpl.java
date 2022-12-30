package project.courier.presentation.services;

import project.courier.service.ShipmentRegisterImpl;
import project.courier.service.interfaces.ShipmentRegister;

public class ShipmentRegisterInjectorImpl implements ShipmentRegisterInjector {
    @Override
    public ShipmentRegister register() {
        return new ShipmentRegisterImpl();
    }
}
