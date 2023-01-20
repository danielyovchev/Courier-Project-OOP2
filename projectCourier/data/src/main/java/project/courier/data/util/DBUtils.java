package project.courier.data.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtils {
    private static SessionFactory sessionFactory;
    static{
        try{
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable e)
        {
            e.printStackTrace();
        }
    }

    public Session openSession(){
//        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.openSession();
    }

    public void closeSession(){
        sessionFactory.close();
    }
}
