package project.courier.presentation.services;

import project.courier.service.ShipmentReceiveImpl;
import project.courier.service.interfaces.ShipmentReceive;

public class ShipmentReceiveInjectorImpl implements ShipmentReceiveInjector {
    @Override
    public ShipmentReceive getShipmentReceive() {
        return new ShipmentReceiveImpl();
    }
}
