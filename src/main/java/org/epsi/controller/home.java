package org.epsi.controller;

import org.epsi.MyEntity;
import org.epsi.model.Produit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class home
{
    @RequestMapping(path = "/", method = {GET,POST})
    public ModelAndView index(Model model)
    {

        ModelAndView result           = new ModelAndView("homeView");
        String       myEntityInstance = "je suis une très belle StrIIIIIIng";

        result.addObject("myInstance", myEntityInstance);
        return result;
    }

    /*@RequestMapping(path = "/t", method = {POST})
    public ModelAndView indexPost(@ModelAttribute MyEntity myEntity)
    {
        ModelAndView result           = new ModelAndView("homeView");
        String       myEntityInstance = "je suis une très belle StrIIIIIIng";

        result.addObject("myInstance", myEntityInstance);
        return result;
    }*/
}
