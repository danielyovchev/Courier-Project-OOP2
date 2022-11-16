package project.courier.data.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.courier.data.entity.User;
import project.courier.data.util.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final DBUtils dbUtils;

    public UserRepositoryImpl(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }
    @Override
    public void save(User user){
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(user);

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
    public void update(User user) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
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
    public void delete(User user) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(user);
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
    public Optional<User> findById(Long id) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        try {
            user = session.createQuery("SELECT a from User a where id="+id.toString(), User.class).getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(user);
    }

    @Override
    public List<User> findAll() {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        List<User> users = new ArrayList<>();
        try {
            users = session.createQuery("SELECT a from User a", User.class).getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return users;
    }

    @Override
    public Optional<User> findByUserAndPass(String username, String password) {
        Session session = dbUtils.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        try {
            user = session.createQuery("SELECT a from User a where username="+username+" AND password="+password, User.class).getSingleResult();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            transaction.commit();
            session.close();
        }
        return Optional.of(user);
    }
}
