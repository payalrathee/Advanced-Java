package p;

import beans.Employee;
import beans.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import sessionFactory.SessionFactoryProvider;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory factory= SessionFactoryProvider.provideSessionFactory();
        Session session=factory.openSession();
        Transaction t=session.beginTransaction();

        //insert student
        //Student s=new Student(1,"Ansh");
        //session.save(s);
        //s.setName("Harsh");

        //update
        //Student s=new Student(1,"Bhanu");
        //session.update(s);

        //retrieve
//        Student s=session.get(Student.class,1);
//        System.out.println(s);
//
//        Student s1=session.load(Student.class,1);
//        System.out.println(s1);
//
//        Student s2=session.load(Student.class,1);
//        System.out.println(s2);
//
//        s.setName("Payal");
//        s1.setName("Harsh");
//        s2.setName("Sneha");

        //delete
//        Student s=new Student();
//        s.setId(1);
//        session.delete(s);
//
//        s.setName("Anu");

        Employee e=new Employee(101,"Danish");
        session.save(e);

        t.commit();
        session.close();


    }
}
