package project.courier.service;

import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentStatus;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.ShipmentDelivery;

import java.time.LocalDate;
import java.util.List;

public class ShipmentDeliveryImpl implements ShipmentDelivery {
    final ShipmentRepositoryInjector shipmentRepo = new ShipmentRepositoryInjectorImpl();
    @Override
    public void deliver(List<Shipment> shipments) {
        shipments.stream()
                .peek(e -> e.setStatus(ShipmentStatus.SENT))
                .peek(e -> e.setDateReceived(LocalDate.now()))
                .forEach(e -> shipmentRepo.getShipmentRepository().update(e));
    }

    @Override
    public void receive(List<Shipment> shipments) {
        shipments.stream()
                .peek(e -> e.setStatus(ShipmentStatus.RECEIVED))
                .forEach(e -> shipmentRepo.getShipmentRepository().update(e));
    }
}
