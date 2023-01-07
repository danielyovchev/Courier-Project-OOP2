package project.courier.service.interfaces;

import project.courier.service.model.ShipmentModel;

import java.time.LocalDate;
import java.util.List;

public interface ShipmentProvider {
    List<ShipmentModel> getShipmentsBetweenDates(LocalDate date1, LocalDate date2);
    ShipmentModel getShipment(Long id);
    List<ShipmentModel> getCustomerShipments(Long id);
}
