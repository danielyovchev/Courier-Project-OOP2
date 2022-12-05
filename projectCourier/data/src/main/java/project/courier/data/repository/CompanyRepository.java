package project.courier.data.repository;

import project.courier.data.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    void save(Company company);
    void update(Company company);
    void delete(Company company);
    Optional<Company> findById(long id);
    List<Company> findAll();
}
