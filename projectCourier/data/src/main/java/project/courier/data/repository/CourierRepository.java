package project.courier.data.repository;

import project.courier.data.entity.Courier;

import java.util.List;
import java.util.Optional;

public interface CourierRepository {
    void save(Courier courier);
    void update(Courier courier);
    void delete(Courier courier);
    Optional<Courier> findById(long id);
    Optional<Courier> findByUsername(String username);
    List<Courier> findAll();
}
