package connections;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionFactoryProvider {
	public static SessionFactory factory;
	private SessionFactoryProvider() {}
	
	public static SessionFactory provideFactory()
	{
		if(factory==null)
		{
			Configuration config=new Configuration().configure();
			ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			factory=config.buildSessionFactory(reg);
		}
		return factory;
	}

}
