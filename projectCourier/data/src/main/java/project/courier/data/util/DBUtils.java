package project.courier.data.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtils {
    private SessionFactory sessionFactory;

    public Session openSession(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory.openSession();
    }

    public void closeSession(){
        sessionFactory.close();
    }
}
