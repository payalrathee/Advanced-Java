package sessionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryProvider {
    private static SessionFactory factory;
    public static SessionFactory provideSessionFactory()
    {
        if(factory==null)
        {
            Configuration config=new Configuration();
            config.configure();
            factory=config.buildSessionFactory();
        }
        return factory;
    }
}
