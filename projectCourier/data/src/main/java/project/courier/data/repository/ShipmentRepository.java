package project.courier.data.repository;

import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ShipmentRepository {
    void save(Shipment shipment);
    void update(Shipment shipment);
    void delete(Shipment shipment);
    Optional<Shipment> findById(long id);
    List<Shipment> findAll();
    List<Shipment> findByOfficeAndStatus(Long id, ShipmentStatus status);
    List<Shipment> findByOfficeAndDate(Long id, LocalDate date);
}
