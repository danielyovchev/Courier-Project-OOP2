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

    public static Session openSession(){
        return sessionFactory.openSession();
    }

    public static void closeSession(){
        sessionFactory.close();
    }
}
