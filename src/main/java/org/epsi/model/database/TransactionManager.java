package org.epsi.model.database;

import org.epsi.model.Product;
import org.epsi.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);

    }

    public Optional<User> getlogedUser(User user)
    {
        Session session = this.sessionFactory.getCurrentSession();

        CriteriaBuilder     criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> query           = criteriaBuilder.createQuery(User.class);
        Root<User>          root            = query.from(User.class);

        query.select(root).where(criteriaBuilder.equal(root.get("login"), user.getLogin()));
        query.select(root).where(criteriaBuilder.equal(root.get("password"), user.getPassword()));

        Query<User> queryResponse = session.createQuery(query);
        List<User>  results       = queryResponse.getResultList();

        if (results.size() != 0)
        {
            return Optional.ofNullable(results.get(0));
        }
        else
        {
            return Optional.empty();
        }
    }

    public List<Product> getAllProduct()
    {
        Session session = this.sessionFactory.getCurrentSession();

        CriteriaBuilder        criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query           = criteriaBuilder.createQuery(Product.class);
        Root<Product>          root            = query.from(Product.class);

        Query<Product> queryResponse = session.createQuery(query);

        return queryResponse.getResultList();

    }

    public Product getProduct(Integer id)
    {
        Session session = this.sessionFactory.getCurrentSession();

        return session.get(Product.class, id);

    }
}
