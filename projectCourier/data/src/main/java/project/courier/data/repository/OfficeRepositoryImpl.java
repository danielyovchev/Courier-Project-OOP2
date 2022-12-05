package project.courier.data.repository;

import project.courier.data.entity.Office;
import project.courier.data.util.DBUtils;

import java.util.List;
import java.util.Optional;

public class OfficeRepositoryImpl implements OfficeRepository {
    private final DBUtils dbUtils;

    public OfficeRepositoryImpl(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void save(Office office) {

    }

    @Override
    public void update(Office office) {

    }

    @Override
    public void delete(Office office) {

    }

    @Override
    public Optional<Office> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Office> findAll() {
        return null;
    }
}
