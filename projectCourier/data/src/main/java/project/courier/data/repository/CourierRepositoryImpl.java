package project.courier.data.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.courier.data.entity.Courier;
import project.courier.data.entity.User;
import project.courier.data.util.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourierRepositoryImpl implements CourierRepository {
    private final DBUtils dbUtils;

    public CourierRepositoryImpl(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void save(Courier courier) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(courier);

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
    public void update(Courier courier) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try
        {
            session.update(courier);
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
    public void delete(Courier courier) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();

        try
        {
            session.delete(courier);
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
    public Optional<Courier> findById(long id) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Courier courier = new Courier();
        try {
            courier = session.createQuery("SELECT a from courier a where a.id='"+id+"'", Courier.class).getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(courier);
    }

    @Override
    public Optional<Courier> findByUsername(String username) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Courier courier = new Courier();
        try {
            courier = session.createQuery("SELECT a from courier a where a.username='"+username+"'", Courier.class).getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(courier);
    }
    @Override
    public List<Courier> findAll() {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Courier> couriers = new ArrayList<>();
        try {
            couriers = session.createQuery("SELECT a from courier a", Courier.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return couriers;
    }
}
