package p;

import beans.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import sessionFactory.SessionFactoryProvider;

import java.util.Arrays;
import java.util.List;

public class HQLDemo {
    public static void main(String[] args) {
        SessionFactory factory= SessionFactoryProvider.provideSessionFactory();
        Session session= factory.openSession();
        Transaction tx=session.beginTransaction();

        //fetch all
//        Query query=session.createQuery("from Student");
//        List<Student> students=query.list();
//        for(Student s : students)
//            System.out.println(s);

        //fetch one
//        Query query=session.createQuery("from Student where id=:i");
//        query.setParameter("i",1);
//        Student s=(Student) query.uniqueResult();
//        System.out.println(s);

        //update
//        Query query=session.createQuery("update Student set name=:n where id=:i");
//        query.setParameter("n","Karan");
//        query.setParameter("i",2);
//        query.executeUpdate();

        //delete
//        Query query=session.createQuery("delete from Student where id=:i");
//        query.setParameter("i",1);
//        query.executeUpdate();

        //sql queries
        NativeQuery query=session.createSQLQuery("select * from student");
        List<Object[]> list=query.list();
        for(Object[] s:list)
            System.out.println(Arrays.toString(s));

        tx.commit();
    }
}
