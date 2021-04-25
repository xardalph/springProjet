package org.epsi.controller;

import org.epsi.MyEntity;
import org.epsi.model.Produit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class home
{
    @RequestMapping(path = "/", method = {GET})
    public ModelAndView index(Model model)
    {
        return new ModelAndView("homeView", "myEntity", new MyEntity());
    }

    @RequestMapping(path = "/", method = {POST})
    public String indexPost(@ModelAttribute("MyEntity") MyEntity myEntity,
                                  BindingResult result, ModelMap model)
    {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("attributA", myEntity.getAttributA());

        return "entityView";
    }
}
