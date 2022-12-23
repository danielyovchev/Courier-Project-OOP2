package project.courier.service;

import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentStatus;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.ShipmentDelivery;
import java.util.List;

public class ShipmentDeliveryImpl implements ShipmentDelivery {
    @Override
    public void deliver(List<Shipment> shipments) {
        final ShipmentRepositoryInjector shipmentRepo = new ShipmentRepositoryInjectorImpl();
        shipments.stream()
                .peek(e -> e.setStatus(ShipmentStatus.SENT))
                .forEach(e -> shipmentRepo.getShipmentRepository().update(e));
    }
}
