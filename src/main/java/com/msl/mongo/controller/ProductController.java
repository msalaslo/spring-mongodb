package com.msl.mongo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.msl.mongo.domain.product.Product;
import com.msl.mongo.service.ProductService;

@Controller
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger("com.msl.mongo.controller.ProductController");
	
	@Autowired
	ProductService service;
	
    @RequestMapping("/product")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        if(null != name) {
        	logger.debug("Buscando productos por nombre...");
        	List<Product> products = service.findByName(name);
        	logger.debug("Productos encontrados:" + products.size());
        	model.addAttribute("products", products);
        }
        model.addAttribute("name", name);
        return "product";
    }
}
