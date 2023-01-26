package project.courier.service.services.shipment;

import project.courier.service.model.ShipmentTableModel;

import java.time.LocalDate;
import java.util.List;

public interface ShipmentProvider {
    List<ShipmentTableModel> getShipmentsBetweenDates(Long id, LocalDate date1, LocalDate date2);
    ShipmentTableModel getShipment(Long id);
    List<ShipmentTableModel> getCustomerShipments(Long id);
}
