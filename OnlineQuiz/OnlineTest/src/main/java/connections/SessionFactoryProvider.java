package connections;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryProvider {
	private static SessionFactory factory;
	
	private SessionFactoryProvider() {}
	
	public static SessionFactory provideSessionFactory()
	{
		if (factory == null) {
		      try {
		        // Create StandardServiceRegistry
		        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
		        // Create MetadataSources
		        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
		        // Create Metadata
		        Metadata metadata = metadataSources.getMetadataBuilder().build();
		        // Create SessionFactory
		        factory = metadata.getSessionFactoryBuilder().build();
		      } catch (Exception e) {
		        System.out.println(e);
		      }
		    }
		return factory;
	}

}
