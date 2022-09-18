package com.hiber.HeberDemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import beans.Employee;
import beans.Project;
import factoryProvider.FactoryProvider;

public class ManytoManyMap {
	public static void main(String[] args)
	{
		SessionFactory factory=FactoryProvider.provideFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		List<Project> projects=new ArrayList<Project>();
		Project p1=new Project();
		p1.setId(101);p1.setName("EComm");
		projects.add(p1);session.save(p1);
		Project p2=new Project();
		p2.setId(102);p2.setName("BlockChain");
		projects.add(p2);session.save(p2);
		
		List<Employee> emps=new ArrayList<Employee>();
		Employee e1=new Employee();
		e1.setId(10);e1.setName("Neha");
		emps.add(e1);session.save(e1);
		Employee e2=new Employee();
		e2.setId(11);e2.setName("Harsh");
		emps.add(e2);session.save(e2);
		
		p1.setEmp(emps);p2.setEmp(emps);
		e1.setProjects(projects);e2.setProjects(projects);
		
		t.commit();
		factory.close();
		
	}

}
