package SingletonHibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by programmer on 02/07/17.
 */
public class HibernateConnection {

   private static SessionFactory sessionFactory =null;



    private HibernateConnection(){



    }
    public static SessionFactory GetConnection(){
if(sessionFactory==null){
    sessionFactory = new Configuration().configure().buildSessionFactory();


}

    return     sessionFactory;
    }


}
