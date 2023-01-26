package project.courier.service.services.shipment;

import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentStatus;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;

import java.time.LocalDate;
import java.util.List;

/**
 * simulates delivery of shipments
 */
public class ShipmentDeliveryImpl implements ShipmentDelivery {
    private final ShipmentRepositoryInjector shipmentRepo = new ShipmentRepositoryInjectorImpl();
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
                .peek(e -> e.setStatus(ShipmentStatus.DELIVERED))
                .forEach(e -> shipmentRepo.getShipmentRepository().update(e));
    }

    @Override
    public void reject(List<Shipment> shipments) {
        shipments.stream()
                .peek(shipment -> shipment.setStatus(ShipmentStatus.REJECTED))
                .peek(shipment -> shipment.setDateReceived(LocalDate.now()))
                .forEach(shipment -> shipmentRepo.getShipmentRepository().update(shipment));
    }
}
