package org.epsi.controller;

import org.epsi.model.Product;
import org.epsi.model.User;
import org.epsi.model.database.TransactionManager;
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
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(path = "/product")
public class productController
{

    @Autowired
    TransactionManager transactionManager;

    @RequestMapping(path = "/{id}", method = {GET})
    public ModelAndView ShowproductId(Model model, @PathVariable String id)
    {
        ArrayList<Product> product = new ArrayList<Product>();
        product.add(transactionManager.getProduct(Integer.valueOf(id)));
        return new ModelAndView("Product/productList", "productList", product);
    }

    @RequestMapping(path = "/", method = {GET})
    public ModelAndView Showproduct()
    {
        List<Product> product = transactionManager.getAllProduct();

        return new ModelAndView("Product/productList", "productList", product);

    }


    @RequestMapping(path = "/create", method = POST)
    public RedirectView createProduct(@ModelAttribute("Product") Product product,
                                    BindingResult result )
    {
        if (result.hasErrors())
        {
            return new RedirectView("/user/login");
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
