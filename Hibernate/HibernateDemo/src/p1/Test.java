package p1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class Test {
	public static void main(String... args) {
		try
		{
			Configuration config=new Configuration();
			config.configure();
			System.out.println(config);
			SessionFactory sessionFactory=config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			System.out.println(session);
			Student s=new Student();
			s.setId(101);
			s.setName("payal");
			session.save(s);
			Transaction t=session.beginTransaction();
			t.commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
