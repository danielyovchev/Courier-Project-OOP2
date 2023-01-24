package project.courier.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.enums.ShipmentStatus;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.ShipmentReceive;

import java.util.List;

public class ShipmentReceiveImpl implements ShipmentReceive {
    private static final Logger logger = LogManager.getLogger(OrganizeShipmentsImpl.class);
    private final ShipmentRepositoryInjector shipmentRepositoryInjector = new ShipmentRepositoryInjectorImpl();
    @Override
    public void shipmentReceive(List<Long> idList) {
        idList.stream()
                .map(i -> shipmentRepositoryInjector.getShipmentRepository().findById(i))
                .map(s -> s.get())
                .peek(shipment -> shipment.setStatus(ShipmentStatus.RECEIVED))
                .peek(shipment -> logger.info("Shipment {} is received", shipment.getId()))
                .forEach(shipment -> shipmentRepositoryInjector.getShipmentRepository().update(shipment));
    }
}
