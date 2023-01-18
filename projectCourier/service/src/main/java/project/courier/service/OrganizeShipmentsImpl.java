package project.courier.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.Office;
import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentStatus;
import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;
import project.courier.service.interfaces.OrganizeShipments;
import project.courier.service.interfaces.ShipmentDelivery;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrganizeShipmentsImpl implements OrganizeShipments {
    private static final Logger logger = LogManager.getLogger(OrganizeShipmentsImpl.class);
    @Override
    public void run() {
        final ShipmentRepositoryInjector shipmentRepo = new ShipmentRepositoryInjectorImpl();
        final OfficeRepositoryInjector officeRepo = new OfficeRepositoryInjectorImpl();
        final ShipmentDelivery shipmentDelivery = new ShipmentDeliveryImpl();
        List<Office> offices = officeRepo.getOfficeRepository().findAll();
        offices.forEach(o -> {
            try {
                List<Shipment> shipments = shipmentRepo.getShipmentRepository()
                        .findByOfficeAndStatus(o.getId(), ShipmentStatus.IN_OFFICE).stream()
                        .toList();
                if(shipments.isEmpty()){
                    logger.warn("No shipments for deliver");
                    return;
                }
                shipmentDelivery.deliver(shipments);
                logger.info("Shipments sent");
                TimeUnit.MINUTES.sleep(1);
                shipmentDelivery.receive(shipments);
                logger.info("Shipments delivered");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
