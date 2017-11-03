package com.msl.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msl.mongo.domain.promocion.Promocion;
import com.msl.mongo.domain.promocion.PromocionRepository;

@Service
public class PromocionService {
	@Autowired
	PromocionRepository repository;
	
    public List<Promocion> findByEmpresa(String empresa){
    	return repository.findByCempresa(empresa);
    }
    
    public List<Promocion> findByCentro(String centro){
    	return repository.findByCentrooo(centro);
    }
    
    public List<Promocion> findByDivision(String division){
    	return repository.findByCdivisio(division);
    }
    public List<Promocion> findByFamilia(String familia){
    	return repository.findByCfamilia(familia);
    }
	
	public Promocion save(Promocion product) {
		return repository.save(product);
	}

}
