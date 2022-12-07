package project.courier.data.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(company);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
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