package project.courier.presentation.services;

import project.courier.service.services.shipment.ShipmentReceiveImpl;
import project.courier.service.services.shipment.ShipmentReceive;

public class ShipmentReceiveInjectorImpl implements ShipmentReceiveInjector {
    @Override
    public ShipmentReceive getShipmentReceive() {
        return new ShipmentReceiveImpl();
    }
}
