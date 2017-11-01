package com.msl.mongo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msl.mongo.domain.promocion.Promocion;
import com.msl.mongo.service.PromocionService;

@RestController
@RequestMapping("/promocion")
public class PromocionController {
	
	Logger logger = LoggerFactory.getLogger("com.msl.mongo.controller.PromocionController");
	
	@Autowired
	PromocionService service;
	
	@GetMapping(path = "/findByCentro")
    public List<Promocion> getProducts(@RequestParam(value="centro", required=false, defaultValue="0") String centro, Model model) {
        logger.debug("Buscando productos por nombre...");
        return service.findByCentro(centro);
    }
	
    @PostMapping(path = "/save")
    public ResponseEntity<Promocion> save(@RequestBody Promocion product) {
    	Promocion savedProduct = this.service.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}
