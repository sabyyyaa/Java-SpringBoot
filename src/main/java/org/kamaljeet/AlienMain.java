package org.kamaljeet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;


public class AlienMain {
    public static void main(String[] args) {
        Alien alien = new Alien();

        alien.setAname("Kamal");
        alien.setTech("Java");
        alien.setAid(1);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.kamaljeet.Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(alien);

        tx.commit();

        session.close();
        sf.close();
        System.out.println("Data stored successfully.");
    }
}
