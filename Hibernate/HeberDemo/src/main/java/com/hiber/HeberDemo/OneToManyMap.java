package com.hiber.HeberDemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import beans.Trainee;
import beans.Trainer;
import factoryProvider.FactoryProvider;

public class OneToManyMap {
	public static void main(String[] args)
	{
		SessionFactory factory=FactoryProvider.provideFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		Trainer tr1=new Trainer();
		tr1.setId(102);
		tr1.setName("Naveen");
		
		List<Trainee> trainees=new ArrayList<Trainee>();
		Trainee t1=new Trainee();
		t1.setId(1220);t1.setName("Payal");t1.setTrainer(tr1);
		session.save(t1);trainees.add(t1);
		
		Trainee t2=new Trainee();
		t2.setId(1221);t2.setName("Rahul");t2.setTrainer(tr1);
		session.save(t2);trainees.add(t2);
		
		Trainee t3=new Trainee();
		t3.setId(1222);t3.setName("Preeti");t3.setTrainer(tr1);
		session.save(t3);trainees.add(t3);
		
		tr1.setTrainees(trainees);
		session.save(tr1);
		
		t.commit();
		factory.close();
	}

}
