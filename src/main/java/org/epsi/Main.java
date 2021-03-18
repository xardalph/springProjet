package org.epsi;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.sql.Date;

public class Main {

    public static void main(String[] args) {
        ApplicationContext myApplicationContext = new AnnotationConfigApplicationContext("org.epsi");
        injected ttt = myApplicationContext.getBean(injected.class);
        System.out.println("hello world!");
        System.out.println(ttt.depend.test);

        Produit produit = new Produit();
        produit.setCode_Produit(5);
        long millis = System.currentTimeMillis();
        produit.setDate_Limite_Conso(new Date(millis));


        SessionFactory config = new Configuration().configure().buildSessionFactory();
        Session session = config.getCurrentSession();

        Transaction transaction = session.beginTransaction();
        session.save(produit);
        transaction.commit();


    }


}
