package project.courier.data.repository;

import project.courier.data.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    void update(User user);
    void delete(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUserAndPass(String username, String password);
    List<User> findAll();

    Optional<User> findByUsername(String username);
}
