package project.courier.data.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBUtils {
    private static SessionFactory sessionFactory;
    private void setSessionFactory(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public Session openSession(){
        return sessionFactory.openSession();
    }
    public void closeSession(){
        sessionFactory.close();
    }
}
