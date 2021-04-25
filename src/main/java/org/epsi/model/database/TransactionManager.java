package org.epsi.model.database;

import org.epsi.model.Produit;
import org.epsi.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TransactionManager
{

    private final SessionFactory sessionFactory;
    public TransactionManager(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public void createNewUser(User user)
    {
        Session     session     = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();

    }
}
