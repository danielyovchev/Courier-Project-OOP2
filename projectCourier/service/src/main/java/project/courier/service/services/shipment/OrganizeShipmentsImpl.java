package project.courier.service.services.shipment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import project.courier.data.entity.Office;
import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentStatus;
import project.courier.service.injector.OfficeRepositoryInjectorImpl;
import project.courier.service.injector.ShipmentRepositoryInjectorImpl;
import project.courier.service.injector.interfaces.OfficeRepositoryInjector;
import project.courier.service.injector.interfaces.ShipmentRepositoryInjector;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * organizes the delivery in new thread
 */
public class OrganizeShipmentsImpl implements OrganizeShipments {
    private final ShipmentRepositoryInjector shipmentRepo = new ShipmentRepositoryInjectorImpl();
    private final OfficeRepositoryInjector officeRepo = new OfficeRepositoryInjectorImpl();
    private static final Logger logger = LogManager.getLogger(OrganizeShipmentsImpl.class);
    @Override
    public void run() {
        final ShipmentDelivery shipmentDelivery = new ShipmentDeliveryImpl();
        List<Office> offices = officeRepo.getOfficeRepository().findAll();
        offices.forEach(o -> {
            try {
                List<Shipment> toReject = shipmentRepo.getShipmentRepository()
                        .findByOfficeAndStatus(o.getId(), ShipmentStatus.SENT).stream().toList();
                shipmentDelivery.reject(toReject);
                logger.info("{} shipments from office {} rejected", toReject.size(), o.getCity());
                List<Shipment> shipments = shipmentRepo.getShipmentRepository()
                        .findByOfficeAndStatus(o.getId(), ShipmentStatus.IN_OFFICE).stream()
                        .toList();
                if(shipments.isEmpty()){
                    logger.info("No shipments for deliver from office {}", o.getCity());
                    return;
                }
                shipmentDelivery.deliver(shipments);
                logger.info("{} shipments from office {} sent", shipments.size() , o.getCity());
                TimeUnit.SECONDS.sleep(15);
                shipmentDelivery.receive(shipments);
                logger.info("{} shipments from office {} delivered",shipments.size() ,o.getCity());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
