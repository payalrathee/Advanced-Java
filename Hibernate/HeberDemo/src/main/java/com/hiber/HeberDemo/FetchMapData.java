package com.hiber.HeberDemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import beans.Answer;
import beans.Question;
import beans.Trainee;
import beans.Trainer;
import factoryProvider.FactoryProvider;

public class FetchMapData {
	public static void main(String[] args)
	{
		SessionFactory factory=FactoryProvider.provideFactory();
		Session session=factory.openSession();
		
		Question q=session.get(Question.class, 1212);
		System.out.println("Question:"+q.getQues());
		Answer a=q.getAns();
		System.out.println("Answer is:"+a.getAns());
		
		Trainer t=session.get(Trainer.class, 102);
		System.out.println("Trainer:");
		System.out.println(t.getName());
		System.out.println("Trainees:");
		List<Trainee> trainees=(List)t.getTrainees();
		for(Trainee tr:trainees)
		{
			System.out.println(tr.getName());
		}
	}

}
