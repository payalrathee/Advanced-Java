package connections;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
	public static SessionFactory factory;
	private SessionFactoryProvider() {}
	
	public static SessionFactory provideFactory()
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