package com.hiber.HeberDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.ABC;
import beans.Student;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	Configuration config=new Configuration();
    	config.configure();
        SessionFactory factory=config.buildSessionFactory();
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();
        
        Student s=new Student();
        s.setId(102);
        s.setName("payal");
        session.save(s);
        
        ABC abc=new ABC();
        abc.setRoll(12345);
        abc.setName("Bhanu");
        abc.setPwd("bhanu@123");
        abc.setDate(new Date());
        abc.setStudent(true);
        FileInputStream fis=new FileInputStream("src/main/java/hcijcij.PNG");
        byte[] b=new byte[fis.available()];
        fis.read(b);
        abc.setImg(b);
        session.save(abc);
        
        t.commit();
        session.close();
    }
}
