package project.courier.data.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.courier.data.entity.Office;
import project.courier.data.util.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OfficeRepositoryImpl implements OfficeRepository {
    private final DBUtils dbUtils;

    public OfficeRepositoryImpl(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void save(Office office) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(office);

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
    public void update(Office office) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(office);

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
    public void delete(Office office) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete( office);

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
    public Optional<Office> findById(long id) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Office office = new Office();
        try {
            office = session.createQuery("SELECT a from Office a where a.id='"+id+"'", Office.class).getSingleResult();
        } catch ( Exception e) {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(office);
    }

    @Override
    public Optional<Office> findByCity(String city) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Office office = new Office();

        try
        {
            office = session.createQuery("SELECT a from Office a where a.city='"+city+"'", Office.class).getSingleResult();
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(office);
    }

    @Override
    public List<Office> findAllByCity(String city) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Office> offices = new ArrayList<>();
        try {
            offices = session.createQuery("SELECT a from Office a where a.city='"+city+"'", Office.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return offices;
    }

    @Override
    public Optional<Office> findByCityAndCompany(String city, Long companyId) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Office office = new Office();
        try {
            office = session.createQuery("SELECT a from Office a where a.city='"+city+"' and a.companyId='"+companyId+"'", Office.class).getSingleResult();
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(office);
    }

    @Override
    public List<Office> findAllByCompany(Long id) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Office> offices = new ArrayList<>();
        try {
            offices = session.createQuery("SELECT a from Office a where a.companyId='"+id+"'", Office.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return offices;
    }

    @Override
    public List<Office> findAll() {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Office> offices = new ArrayList<>();
        try {
            offices = session.createQuery("SELECT a from Office a", Office.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return offices;
    }
}
