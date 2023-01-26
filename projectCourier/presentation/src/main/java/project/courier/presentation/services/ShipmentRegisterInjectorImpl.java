package project.courier.presentation.services;

import project.courier.service.services.shipment.ShipmentRegisterImpl;
import project.courier.service.services.shipment.ShipmentRegister;

public class ShipmentRegisterInjectorImpl implements ShipmentRegisterInjector {
    @Override
    public ShipmentRegister register() {
        return new ShipmentRegisterImpl();
    }
}
