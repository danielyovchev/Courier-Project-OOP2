package project.courier.service.interfaces;

import project.courier.data.entity.Shipment;

import java.util.List;

public interface ShipmentDelivery {
    void deliver(List<Shipment> shipments);
    void receive(List<Shipment> shipments);
}
