package project.courier.data.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.courier.data.entity.Company;
import project.courier.data.util.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyRepositoryImpl implements CompanyRepository {

    @Override
    public void save(Company company) {
        Session session = DBUtils.openSession();
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
        Session session = DBUtils.openSession();
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
    public void delete(Company company) {
        Session session = DBUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try {
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
        Session session = DBUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Company company = new Company();
        try {
            company = session.createQuery("SELECT a from Company a where a.id='"+id+"'", Company.class).getSingleResult();
        }
        catch (Exception e){
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
        Session session = DBUtils.openSession();
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

    @Override
    public boolean existsByBulstatAndName(String name, String bulstat) {
        Session session = DBUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Optional<Company> company = Optional.of(new Company());
        try {
            company = session.createQuery("SELECT a from Company a where a.name='"+name+"' AND a.bulstat='"+bulstat+"'", Company.class)
                    .getResultList().stream().findFirst();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return company.isPresent();
    }

    @Override
    public Optional<Company> findByName(String name) {
        Session session = DBUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Company company = new Company();
        try {
            company = session.createQuery("SELECT a from Company a where a.name='"+name+"'", Company.class).getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(company);
    }
}
