package org.epsi.controller;

import org.epsi.model.Product;
import org.epsi.model.User;
import org.epsi.model.database.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(path = "/product")
public class productController
{

    @Autowired
    TransactionManager transactionManager;

    @RequestMapping(path = "/{id}", method = {GET})
    public ModelAndView ShowproductId(Model model, @PathVariable String id)
    {
        Product product = transactionManager.getProduct(Integer.valueOf(id));
        return new ModelAndView("Product/productList", "productList", product);
    }


    @RequestMapping(path = "/", method = {GET})
    public ModelAndView Showproduct()
    {
        List<Product> product = transactionManager.getAllProduct();

        return new ModelAndView("Product/productList", "productList", product);
        
    }
}
