package project.courier.service;

import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentStatus;
import project.courier.service.interfaces.ShipmentDelivery;
import java.util.List;

public class ShipmentDeliveryImpl implements ShipmentDelivery {
    @Override
    public void deliver(List<Shipment> shipments) {
        shipments.forEach(e -> e.setStatus(ShipmentStatus.SENT));
    }
}
