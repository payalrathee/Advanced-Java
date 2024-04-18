package factoryProvider;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
	public static SessionFactory provideFactory()
	{
		Configuration config=new Configuration();
		config.configure();
		return config.buildSessionFactory();
	}

}
