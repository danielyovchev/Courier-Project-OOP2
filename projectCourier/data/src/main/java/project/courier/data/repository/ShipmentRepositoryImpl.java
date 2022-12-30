package project.courier.data.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.courier.data.entity.Shipment;
import project.courier.data.entity.enums.ShipmentStatus;
import project.courier.data.util.DBUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShipmentRepositoryImpl implements ShipmentRepository {
    private final DBUtils dbUtils;

    public ShipmentRepositoryImpl(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }

    @Override
    public void save(Shipment shipment) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(shipment);

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
    public void update(Shipment shipment) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(shipment);

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
    public void delete(Shipment shipment) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(shipment);

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
    public Optional<Shipment> findById(long id) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        Shipment shipment = new Shipment();

        try
        {
            shipment = session.createQuery("SELECT a from Shipment a where a.id='"+id+"'", Shipment.class).getSingleResult();
        }
        catch ( Exception e)
        {
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(shipment);
    }

    @Override
    public List<Shipment> findAll() {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Shipment> shipments = new ArrayList<>();
        try {
            shipments = session.createQuery("SELECT a from Shipment a", Shipment.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return shipments;
    }

    @Override
    public List<Shipment> findByOfficeAndStatus(Long id, ShipmentStatus status) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Shipment> shipments = new ArrayList<>();
        try {
            shipments = session.createQuery("SELECT a from Shipment a where a.officeId='"+id+"' and a.status='"+status+"'", Shipment.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return shipments;
    }

    @Override
    public List<Shipment> findByOfficeAndDate(Long id, LocalDate date) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<Shipment> shipments = new ArrayList<>();
        try {
            shipments = session.createQuery("SELECT a from Shipment a where a.officeId='"+id+"' and a.dateSent='"+date+"'", Shipment.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return shipments;
    }
}
