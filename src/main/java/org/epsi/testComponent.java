package org.epsi;

import org.epsi.model.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Date;

@Component
@Transactional
public class testComponent {


    public void createNew() {
        ApplicationContext myApplicationContext = new AnnotationConfigApplicationContext("org.epsi");
        SessionFactory bean = myApplicationContext.getBean(SessionFactory.class);
        Session session = bean.getCurrentSession();



        Produit produit = new Produit();
        produit.setCode_Produit(888);
        long millis = System.currentTimeMillis();
        produit.setDate_Limite_Conso(new Date(millis));

        session.beginTransaction();
        session.save(produit);

        session.close();


    }

}
