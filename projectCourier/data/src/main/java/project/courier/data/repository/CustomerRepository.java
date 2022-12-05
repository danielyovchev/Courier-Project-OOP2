package project.courier.data.repository;

import project.courier.data.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void save(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
    Optional<Customer> findById(long id);
    List<Customer> findAll();
}
