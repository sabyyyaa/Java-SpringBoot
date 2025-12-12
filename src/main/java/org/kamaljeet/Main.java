package org.kamaljeet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        System.out.println("This repo is created to learn JDBC , MAVEN , HIBERNATE");
        Student s1 = new Student();
        s1.setName("kamal");
        s1.setAge(22);
        s1.setRollno(8);
        Student s2 = null;
/*
//Lengthy way to configure:
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.kamaljeet.Student.class);
        cfg.configure();
*/

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.kamaljeet.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();


        s2 = session.get(Student.class, 6);   //To fetch the data from DB

        Transaction tx = session.beginTransaction();

        //session.persist(s1);      //To store the data in table

        //session.merge(s1);        //To update the row and insert if it is not exist.

        session.remove(s2);         //To Delete the record from DB

        tx.commit();                //To save the changes to DB



        session.close();    //closing the session
        sf.close();         //closing the session factory

        System.out.println("Data saved successfully");
        //System.out.println(s1);


    }
}
