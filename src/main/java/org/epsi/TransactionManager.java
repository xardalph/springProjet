package org.epsi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Component
@Transactional
public class TransactionManager {

    @Autowired
    private SessionFactory sessionFactory;

    public void createNew() {

        Produit produit = new Produit();
        produit.setCode_Produit(8858);
        long millis = System.currentTimeMillis();
        produit.setDate_Limite_Conso(new Date(millis));

        Session session =  this.sessionFactory.getCurrentSession();
        session.save(produit);

    }
}
