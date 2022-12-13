package project.courier.data.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.courier.data.entity.Company;
import project.courier.data.util.DBUtils;

import java.util.ArrayList;
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

            Session session = dbUtils.openSession();
            Transaction transaction = session.beginTransaction();
            try
            {
                session.update(company);
            }
            catch ( Exception e)
            {
                e.printStackTrace();
            }
            finally {
                transaction.commit();
                session.close();
            }
    }

    @Override
    public void delete(Company company)
    {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();

        try
        {
            session.delete(company);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }

    }

    @Override
    public Optional<Company> findById(long id) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Company company = new Company();

        try
        {
            company = session.createQuery("SELECT a from Company a where a.id='"+id+"'", Company.class).getSingleResult();
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(company);
    }

    @Override
    public List<Company> findAll() {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Company> companies = new ArrayList<>();
        try {
            companies = session.createQuery("SELECT a from Company a", Company.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return companies;
    }
}
