package org.example;

import beans.Pupil;
import beans.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sessionFactory.SessionFactoryProvider;

import java.util.Arrays;
import java.util.List;

public class HQLDemo {
    public static void main(String[] args) {
        SessionFactory factory= SessionFactoryProvider.provideSessionFactory();
        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();

        //join--One to One
//        Query query=session.createQuery("select e.name,a.city from Employee e join e.address a");
//        List<Object[]> list=query.list();
//        for(Object[] o:list)
//            System.out.println(Arrays.toString(o));

//        Query query=session.createQuery("select e.name,a.city from Address a join a.emp e");
//        List<Object[]> list=query.list();
//        for(Object[] o:list)
//            System.out.println(Arrays.toString(o));



        //join--One to Many
//        Query query=session.createQuery("select s.name,b.author from Student s join s.books b");
//        List<Object[]> list=query.list();
//        for(Object[] o:list)
//            System.out.println(Arrays.toString(o));

//        Query query=session.createQuery("select s.name,b.author from Book b join b.student s");
//        List<Object[]> list=query.list();
//        for(Object[] o:list)
//            System.out.println(Arrays.toString(o));

        //join--Many to Many
//        Query query=session.createQuery("select p.name,c.name from Pupil p join p.courses c");
//        List<Object[]> list=query.list();
//        for(Object[] o:list)
//            System.out.println(Arrays.toString(o));

//        Query query=session.createQuery("select c.name,p.name from Course c join c.pupils p");
//        List<Object[]> list=query.list();
//        for(Object[] o:list)
//            System.out.println(Arrays.toString(o));

        //pagination
        Query query=session.createQuery("from Pupil");
        query.setFirstResult(1);
        query.setMaxResults(2);
        List<Pupil> list=query.list();
        for(Pupil p:list)
            System.out.println(p.getName());



        tx.commit();
    }
}
