package org.epsi.controller;

import org.epsi.MyEntity;
import org.epsi.model.Produit;
import org.epsi.model.User;
import org.epsi.model.database.TransactionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(path = "/user")
public class UserController

{
    @Autowired
    SessionFactory sessionFactory;

    @RequestMapping(path = "/create", method = {GET})
    public ModelAndView ShowCreate(Model model)
    {
        return new ModelAndView("createUser", "user", new User());
    }

    @RequestMapping(path = "/create", method = {POST})
    public String CreateUser(@ModelAttribute("User") User user,
                            BindingResult result, ModelMap model)
    {
        if (result.hasErrors())
        {
            return "error";
        }
        model.addAttribute("Login", user.getLogin());

        //create user in database and log in.
          Session     session     = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();

        //transactionManager.createNewUser(user);


        return "User Added";
    }
}
