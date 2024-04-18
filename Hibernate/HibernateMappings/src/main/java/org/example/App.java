package org.example;

import beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryProvider;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory factory= SessionFactoryProvider.provideSessionFactory();
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();

        //*******************ONE TO ONE*********************
        //insert
//        Address adr=new Address(2,47,"ab4","Rohtak","Haryana","India",124001,null);
//        Employee e=new Employee(102,"Gaurav",adr);
//        adr.setEmp(e);
//        session.save(e);
//        session.save(adr);

        //update
//        Employee e=session.get(Employee.class,101);
//        Address adr=e.getAddress();
//        e.setName("Priyanka");
//        adr.setCity("Bhopal");
//        session.update(e);


        //delete
//        Employee e=session.get(Employee.class,101);
//        session.delete(e);

        //********************ONE TO MANY********************
//        Book b1=new Book(1,"Java","Kathy Sierra",null);
//        Book b2=new Book(2,"C","Denis Ritchie",null);
//        Book b3=new Book(3,"Math","NP Bali",null);
//        Book b4=new Book(4,"Math","RD Sharma",null);
//
//        List<Book> books=new ArrayList<>();
//        books.add(b1);books.add(b2);books.add(b3);books.add(b4);
//
//        Student s=new Student(101,"Ansh",books);
//        b1.setStudent(s);b2.setStudent(s);b3.setStudent(s);b4.setStudent(s);
//
//        session.save(s);



        //*****************MANY TO MANY********************
        Pupil p1=new Pupil(1011,"Sneha",null);
        Pupil p2=new Pupil(2012,"Ganesh",null);
        Pupil p3=new Pupil(2452,"Danish",null);
        Pupil p4=new Pupil(9932,"Prerna",null);
        List<Pupil> pupils1=new ArrayList<>();
        pupils1.add(p1);pupils1.add(p3);
        List<Pupil> pupils2=new ArrayList<>();
        pupils1.add(p2);pupils1.add(p4);


        Course c1=new Course(110,"Spring",2,null);
        Course c2=new Course(132,"Hibernate",1,null);
        Course c3=new Course(242,"Django",2,null);
        Course c4=new Course(562,"Mysql",1,null);
        List<Course> courses1=new ArrayList<>();
        courses1.add(c2);courses1.add(c3);
        List<Course> courses2=new ArrayList<>();
        courses2.add(c1);courses2.add(c4);

        p1.setCourses(courses1);
        p2.setCourses(courses2);
        p3.setCourses(courses1);
        p4.setCourses(courses2);

        c1.setPupils(pupils2);
        c2.setPupils(pupils1);
        c3.setPupils(pupils1);
        c4.setPupils(pupils2);

        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);

       // *****************EMBEDDABLE********************
//        Name name=new Name("Bhanu","Pratap","Singh");
//        Person p=new Person(1,name);
//        session.save(p);
//
        t.commit();

    }
}
