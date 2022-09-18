package com.hiber.HeberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import beans.Student;
import factoryProvider.FactoryProvider;

public class FetchData {
	public static void main(String... args)
	{
		SessionFactory factory=FactoryProvider.provideFactory();
		Session session=factory.openSession();
		
		Student s=session.get(Student.class, 102);
		Student s1=session.get(Student.class, 102);
		System.out.println(s);
		System.out.println(s1);
		s.setName("Bhanu");
		System.out.println(s.getName());
		System.out.println(s1.getName());
		
//		Student s=session.load(Student.class, 102);
//		System.out.println(s.getName());
//		Student s1=session.load(Student.class, 101);
//		System.out.println(s1);
	}

}
