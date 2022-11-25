package project.courier.data.repository;

import project.courier.data.entity.Courier;

import java.util.List;
import java.util.Optional;

public interface CourierRepository {
    void save(Courier courier);
    void update(Courier courier);
    void delete(Courier courier);
    Optional<Courier> getById(long id);
    List<Courier> getAll();
}
