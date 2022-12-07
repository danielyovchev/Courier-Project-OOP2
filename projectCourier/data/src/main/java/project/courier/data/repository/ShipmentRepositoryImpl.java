package project.courier.data.repository;

import project.courier.data.entity.Shipment;
import project.courier.data.util.DBUtils;

import java.util.List;
import java.util.Optional;

public class ShipmentRepositoryImpl implements ShipmentRepository {
    private final DBUtils dbUtils;

    public ShipmentRepositoryImpl(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void save(Shipment shipment) {

    }

    @Override
    public void update(Shipment shipment) {

    }

    @Override
    public void delete(Shipment shipment) {

    }

    @Override
    public Optional<Shipment> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Shipment> findAll() {
        return null;
    }
}
