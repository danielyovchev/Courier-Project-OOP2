package project.courier.data.repository;

import project.courier.data.entity.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentRepository {
    void save(Shipment shipment);
    void update(Shipment shipment);
    void delete(Shipment shipment);
    Optional<Shipment> getById(long id);
    List<Shipment> getAll();
}
