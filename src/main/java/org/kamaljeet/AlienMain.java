package org.kamaljeet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.util.Arrays;


public class AlienMain {
    public static void main(String[] args) {
        Alien alien = new Alien();
        Laptop l1 = new Laptop();
        Laptop l2 = new Laptop();
        alien.setAname("Kamal");
        alien.setTech("Java");
        alien.setAid(101);

        l1.setId(1);
        l1.setBrand("HP");
        l1.setModel("Pavilion");
        l1.setRam(16);

        l2.setId(2);
        l2.setBrand("Dell");
        l2.setModel("xps");
        l2.setRam(8);
        alien.setLaptops(Arrays.asList(l1,l2));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.kamaljeet.Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(alien);

        tx.commit();

        session.close();
        sf.close();
        System.out.println("Data stored successfully.");
    }
}
