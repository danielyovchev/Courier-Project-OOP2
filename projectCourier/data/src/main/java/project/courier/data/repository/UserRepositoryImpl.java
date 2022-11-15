package project.courier.data.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.courier.data.entity.User;
import project.courier.data.util.DBUtils;

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
}
