package project.courier.service;

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

public class OrganizeShipmentsImpl implements OrganizeShipments {
    @Override
    public void organize() {
        final ShipmentRepositoryInjector shipmentRepo = new ShipmentRepositoryInjectorImpl();
        final OfficeRepositoryInjector officeRepo = new OfficeRepositoryInjectorImpl();
        final ShipmentDelivery shipmentDelivery = new ShipmentDeliveryImpl();
        List<Office> offices = officeRepo.getOfficeRepository().findAll();
        offices.forEach(o -> {
            List<Shipment> shipments = shipmentRepo.getShipmentRepository()
                    .findByOfficeAndStatus(o.getId(), ShipmentStatus.IN_OFFICE).stream().toList();
            shipmentDelivery.deliver(shipments);
        });

    }
}
