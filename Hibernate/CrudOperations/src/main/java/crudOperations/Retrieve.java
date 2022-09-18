package crudOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import beans.Student;
import utilities.SessionFactoryProvider;

public class Retrieve {
	public static void main(String[] args)
	{
		SessionFactory sessionFactory=SessionFactoryProvider.provideSessionFactory();
		Session session=sessionFactory.openSession();
		
		System.out.println("Fetching object using get:");
		Student s1=session.get(Student.class, 102);
		System.out.println(s1);
		System.out.println("Fetching object using load:");
		Student s2=session.load(Student.class,102);
		System.out.println(s2);
		
		sessionFactory.close();
	}


}
