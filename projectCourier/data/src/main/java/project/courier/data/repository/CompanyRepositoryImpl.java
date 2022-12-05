package project.courier.data.repository;

import project.courier.data.entity.Company;
import project.courier.data.util.DBUtils;

import java.util.List;
import java.util.Optional;

public class CompanyRepositoryImpl implements CompanyRepository {
    private final DBUtils dbUtils;

    public CompanyRepositoryImpl(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void save(Company company) {

    }

    @Override
    public void update(Company company) {

    }

    @Override
    public void delete(Company company) {

    }

    @Override
    public Optional<Company> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Company> findAll() {
        return null;
    }
}
