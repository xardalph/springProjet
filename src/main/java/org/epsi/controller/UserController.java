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
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.Option;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(path = "/user")
public class UserController

{
    @Autowired
    TransactionManager transactionManager;

    @RequestMapping(path = "/create", method = {GET})
    public ModelAndView ShowCreate(Model model)
    {
        return new ModelAndView("createUser", "user", new User());
    }

    @RequestMapping(path = "/create", method = {POST})
    public String CreateUser(@ModelAttribute("User") User user,
                             BindingResult result, ModelMap model, HttpServletRequest req)
    {
        if (result.hasErrors())
        {
            return "error";
        }
        model.addAttribute("Login", user.getLogin());

        //create user in database and log in.
        transactionManager.createNewUser(user);

        connectUser(user, req);

        return "User Added";
    }

    @RequestMapping(path = "/login", method = {GET})
    public ModelAndView ShowLogin(Model model)
    {
        return new ModelAndView("loginUser", "user", new User());
    }

    @RequestMapping(path = "/login", method = {POST})
    public RedirectView loginUser(@ModelAttribute("User") User user,
                             BindingResult result, ModelMap model, HttpServletRequest req, HttpServletResponse resp)
    {
        if (result.hasErrors())
        {
            return new RedirectView("/user/login");
        }

        connectUser(user, req);

        Optional<User> connectedUser = transactionManager.getlogUser(user);
        if (connectedUser.isPresent()){
            connectUser(connectedUser.get(), req);
            return new RedirectView("/user/showUser");

        }
        else {
            return new RedirectView("/user/login");

        }
    }


    @RequestMapping(path = "/showUser", method = {GET})
    public ModelAndView showUser(ModelMap model, HttpServletRequest req, HttpServletResponse resp)
    {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");


        return new ModelAndView("showUser", "user", user);
    }

    public void connectUser(User user, HttpServletRequest req){
        HttpSession session = req.getSession();
        session.setAttribute("user", user);

    }

}
