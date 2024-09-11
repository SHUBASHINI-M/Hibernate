package com.hexaware.hiber1.com.hexaware.hiber11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    SessionFactory fac;
    Session ses;
    Transaction tx;

    App() {
        fac = new Configuration().configure("hiber.cfg.xml").addAnnotatedClass(Book.class).buildSessionFactory();
        ses = fac.openSession();
    }

    void insertBook() {
        tx = ses.beginTransaction();

        Book b = new Book();
        b.setbNo(109); // Ensure this value is unique
        b.setName("React");
        b.setPrice(2000.9);

        ses.save(b);
        tx.commit();
    }
    
    
    
    void UpdateBkPriceByBNo() {
        int bn = 109;
        tx = ses.beginTransaction();
        
        Book b = ses.find(Book.class, bn);
        if (b != null) {
            b.setPrice(6000.0);
            ses.update(b);
            tx.commit();
        } else {
            System.out.println("Not Found");
        }
    }

    void RemoveByBNo() {
        int bn = 101;
        tx = ses.beginTransaction();
        Book b = ses.find(Book.class, bn);
        
        if (b != null) {
            ses.delete(b);
            tx.commit();
        } else {
            System.out.println("Not Found");
        }
    }


    public static void main(String[] args) {
        App app = new App();
        //app.insertBook();
        //app.RemoveByBNo();
        app.UpdateBkPriceByBNo();

        System.out.println("Welcome");
    }
}








//public class App {
//	
//	
//	
//	App()
//	{
//		
//	}
//    public static void main(String[] args) {
// 
//        Configuration configuration = new Configuration().configure("hiber.cfg.xml");
//        configuration.addAnnotatedClass(Book.class);
//
//        
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties()).build();
//
//       
//        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//      
//        Book b = new Book();
//        b.setbNo(107);
//        b.setName("dsa");
//        b.setPrice(2000.9);
//
//        session.save(b);
//        transaction.commit();
//
//        session.close();
//        sessionFactory.close();
//
//        System.out.println("Welcome");
//    }
//}
//
