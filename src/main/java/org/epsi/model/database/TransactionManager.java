package org.epsi.model.database;

import org.epsi.model.Produit;
import org.epsi.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TransactionManager
{

    private final SessionFactory sessionFactory;

    public TransactionManager(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public void createNewUser(Object user)
    {
        Session     session     = this.sessionFactory.getCurrentSession();
        session.save(user);

    }

    public Optional<User> getlogUser(User user)
    {
        Session                         session = this.sessionFactory.getCurrentSession();
        //session.createQuery("select * from User where login == " + user.getGogin + "and" );
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User>          root  = query.from(User.class);

        query.select(root).where(criteriaBuilder.equal(root.get("login"), user.getLogin()));
        query.select(root).where(criteriaBuilder.equal(root.get("password"), user.getPassword()));

        Query<User> queryResponse = session.createQuery(query);
        List<User>  results       = queryResponse.getResultList();

        if(results.size() != 0){
            return Optional.ofNullable(results.get(0));
        }
        else{
            return Optional.empty();
        }


                //createCriteria(User.class).add(Restrictions.add(collect("password").containAll(user.getPassword())));

    }
}
