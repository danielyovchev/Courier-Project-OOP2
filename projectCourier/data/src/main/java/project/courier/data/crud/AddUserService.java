package project.courier.data.crud;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.courier.data.entity.UserDB;
import project.courier.data.util.DBUtils;

public class AddUserService implements AddUserInterface{
    private final DBUtils dbUtils;

    public AddUserService(DBUtils dbUtils) {
        this.dbUtils = dbUtils;
    }
    @Override
    public void addUser(UserDB user){
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
