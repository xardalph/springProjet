package org.epsi.service;


import org.epsi.model.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class UserService
{
    public boolean checkUserConnection(HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        return session.getAttribute("user") != null && session.getAttribute("user").getClass() == User.class;


    }
}
