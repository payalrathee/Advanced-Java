package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.RegisterBean;

public class RegisterDao {

	public static boolean register(RegisterBean b)
	{
		try
		{
			Configuration config=new Configuration();
			config.configure();
			SessionFactory sessionFactory=config.buildSessionFactory();
			Session session=sessionFactory.openSession();
			session.save(b);
			Transaction t=session.beginTransaction();
			t.commit();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}
}
