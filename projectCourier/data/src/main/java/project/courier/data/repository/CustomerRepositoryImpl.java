package project.courier.data.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.courier.data.entity.Customer;
import project.courier.data.util.DBUtils;

import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository{
    private final DBUtils dbUtils;

    public CustomerRepositoryImpl(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void save(Customer customer) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(customer);

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
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public Optional<Customer> findById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
