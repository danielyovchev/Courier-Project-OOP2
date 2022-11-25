package project.courier.data.repository;

import project.courier.data.entity.Office;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository {
    void save(Office office);
    void update(Office office);
    void delete(Office office);
    Optional<Office> getById(long id);
    List<Office> getAll();
}
