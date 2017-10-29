package com.msl.mongo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msl.mongo.domain.product.Product;
import com.msl.mongo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger("com.msl.mongo.controller.ProductController");
	
	@Autowired
	ProductService service;
	
	@GetMapping(path = "/find")
    public List<Product> getProducts(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        if(null != name) {
        	logger.debug("Buscando productos por nombre...");
        	return service.findByName(name);
        }
        return null;
    }
}
