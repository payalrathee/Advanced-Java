package com.hiber.HeberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import beans.Address;
import beans.Student;
import factoryProvider.FactoryProvider;

public class EmbdDemo {
	public static void main(String[] args)
	{
		SessionFactory factory=FactoryProvider.provideFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		Student s1=new Student();
		s1.setId(101);
		s1.setName("amit");
		Address addr1=new Address();
		addr1.setHno(121);addr1.setSector(14);addr1.setCity("rohtak");addr1.setCountry("India");addr1.setState("Haryana");
		s1.setAddr(addr1);
		session.save(s1);
		
		Student s2=new Student();
		s2.setId(102);
		s2.setName("ajay");
		Address addr2=new Address();
		addr2.setHno(123);addr2.setSector(14);addr2.setCity("rohtak");addr2.setCountry("India");addr2.setState("Haryana");
		s2.setAddr(addr2);
		session.save(s2);
		
		t.commit();
		session.close();
	}

}
