package project.courier.data.repository;

import project.courier.data.entity.Courier;
import project.courier.data.util.DBUtils;

import java.util.List;
import java.util.Optional;

public class CourierRepositoryImpl implements CourierRepository {
    private final DBUtils dbUtils;

    public CourierRepositoryImpl(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void save(Courier courier) {

    }

    @Override
    public void update(Courier courier) {

    }

    @Override
    public void delete(Courier courier) {

    }

    @Override
    public Optional<Courier> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Courier> findAll() {
        return null;
    }
}
