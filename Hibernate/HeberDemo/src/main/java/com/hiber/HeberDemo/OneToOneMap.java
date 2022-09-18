package com.hiber.HeberDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import beans.Answer;
import beans.Question;
import factoryProvider.FactoryProvider;

public class OneToOneMap {
	public static void main(String[] args)
	{
		SessionFactory factory=FactoryProvider.provideFactory();
		Session session=factory.openSession();
		Transaction t=session.beginTransaction();
		
		Question q1=new Question();
		q1.setQid(1212);
		q1.setQues("What is full form of JSP");
		Answer a1=new Answer();
		a1.setAid(301);
		a1.setAns("Java Server Pages");
		a1.setQues(q1);
		session.save(a1);
		q1.setAns(a1);
		session.save(q1);
		
		Question q2=new Question();
		q2.setQid(38738);
		q2.setQues("What is full form JVM");
		Answer a2=new Answer();
		a2.setAid(302);
		a2.setAns("Java Virtual Machine");
		a2.setQues(q2);
		session.save(a2);
		q2.setAns(a2);
		session.save(q2);
		
		t.commit();
	}

}
