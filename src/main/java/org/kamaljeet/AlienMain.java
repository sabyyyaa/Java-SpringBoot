package org.kamaljeet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

import java.util.Arrays;


public class AlienMain {
    public static void main(String[] args) {
        //Alien Objects:
        Alien a1 = new Alien();
        Alien a2 = new Alien();
        Alien a3 = new Alien();
        //Laptop Objects:
        Laptop l1 = new Laptop();
        Laptop l2 = new Laptop();
        Laptop l3 = new Laptop();

        a1.setAname("Kamal");
        a1.setTech("Java");
        a1.setAid(101);

        a2.setAname("sabya");
        a2.setTech("python");
        a2.setAid(102);

        a3.setAname("Igloo");
        a3.setTech("C++");
        a3.setAid(103);

        l1.setId(1);
        l1.setBrand("HP");
        l1.setModel("Pavilion");
        l1.setRam(16);

        l2.setId(2);
        l2.setBrand("Dell");
        l2.setModel("xps");
        l2.setRam(8);

        l3.setId(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook Air");
        l3.setRam(32);

        l1.setAliens(Arrays.asList(a1,a2));
        l2.setAliens(Arrays.asList(a2,a3));
        l3.setAliens(Arrays.asList(a1,a3));

        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l3,l2));
        a3.setLaptops(Arrays.asList(l1,l3));


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.kamaljeet.Alien.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(l3);

        session.persist(a1);
        session.persist(a2);
        session.persist(a3);

        tx.commit();

        session.close();
        sf.close();
        System.out.println("Data stored successfully.");
    }
}
