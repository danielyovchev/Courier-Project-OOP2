package project.courier.data.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.courier.data.entity.Customer;
import project.courier.data.util.DBUtils;



import java.util.ArrayList;
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
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(customer);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void delete(Customer customer) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(customer);

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
    public Optional<Customer> findById(long id) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();

        try
        {
            customer = session.createQuery("SELECT a from Customer a where a.id='"+id+"'", Customer.class).getSingleResultOrNull();
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(customer);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Optional<Customer> customer = Optional.of(new Customer());
        try
        {
            customer = session.createQuery("SELECT a from Customer a where a.email='"+email+"'", Customer.class).getResultList().stream().findFirst();
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return customer;
    }

    @Override
    public Optional<Customer> findByCompanyId(long companyId) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();

        try
        {
            customer = session.createQuery("SELECT a from Customer a where a.companyId='"+companyId+"'", Customer.class).getSingleResult();
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(customer);
    }

    public List<Customer> findAllByCompanyID(long companyId)  {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customers = new ArrayList<>();
        try {
            customers = session.createQuery("SELECT a from Customer a where a.companyId='"+companyId+"'", Customer.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return customers;
    }
    @Override
    public List<Customer> findAll() {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Customer> customers = new ArrayList<>();
        try {
            customers = session.createQuery("SELECT a from Customer a", Customer.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return customers;
    }

}
