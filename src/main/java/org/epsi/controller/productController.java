package org.epsi.controller;

import org.epsi.model.Product;
import org.epsi.model.User;
import org.epsi.model.database.TransactionManager;
import org.epsi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping(path = "/product")
public class productController
{

    @Autowired
    TransactionManager transactionManager;

    @Autowired
    UserService userService;


    @RequestMapping(path = "/", method = {GET})
    public ModelAndView Showproduct()
    {
        List<Product> product = transactionManager.getAllProduct();

        return new ModelAndView("Product/productList", "productList", product);

    }

    @RequestMapping(path = "/{id}", method = {GET})
    public ModelAndView ShowproductId(@PathVariable String id)
    {
        Product product = transactionManager.getProduct(Integer.valueOf(id));
        return new ModelAndView("Product/productshow", "product", product);
    }

    @RequestMapping(path = "/update/{id}", method = GET)
    public ModelAndView getUpdateProduct(@PathVariable String id)
    {
        Product product = transactionManager.getProduct(Integer.valueOf(id));

        return new ModelAndView("Product/productCreate", "product", product);
    }

    @RequestMapping(path = "/{id}", method = {POST})
    public ModelAndView updateProduct(@ModelAttribute("Product") Product product, BindingResult result, @PathVariable String id)
    {
        //need to update data in database
        return new ModelAndView("Product/productList", "productList", product);
    }

    @RequestMapping(path = "/delete/{id}", method = GET)
    public RedirectView deleteProduct(@PathVariable String id, HttpServletRequest req)
    {
        // a new method to check if user is logged in ?
        if (!userService.checkUserConnection(req)){
            return new RedirectView("/user/login");
        }
        //need to delete a row in database
        transactionManager.deleteProduct(Integer.valueOf(id));
        return new RedirectView("/product/");

    }

    @RequestMapping(path = "/create", method = POST)
    public RedirectView createProduct(@ModelAttribute("Product") Product product,
                                    BindingResult result )
    {
        //TODO : authentifier l'utilisateur

        if (result.hasErrors())
        {
            return new RedirectView("/product/create");
        }

        transactionManager.storeNewObject(product);
        return new RedirectView("/product/");


    }

    @RequestMapping(path = "/create", method = GET)
    public ModelAndView getCreateProduct()
    {
        return new ModelAndView("Product/productCreate", "product", new Product());

    }





}
