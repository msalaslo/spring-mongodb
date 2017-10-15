package com.msl.mongo.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.msl.mongo.domain.product.Product;
import com.msl.mongo.domain.product.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryLoaderTests {

    @Autowired
    ProductRepository repository;

    @Before
    public void setUp() {
        
    }
    
//    @Test
    public void deleteAll() {
    	repository.deleteAll();
        List<Product> result = repository.findAll();
        assertThat(result).hasSize(0);
    }
    
//    @Test
    public void load() {
        int numEmpresas = 14;
        int numCentros = 500;
        int numFamilias = 50;
        int numBarras = 10;
        int numTallas = 5;
        for (int empresa = 0; empresa < numEmpresas; empresa++) {
        	for (int centro = 0; centro < numCentros; centro++) {
        		for (int familia = 0; familia < numFamilias; familia++) {
					for (int barra = 0; barra < numBarras; barra++) {
						for (int talla = 0; talla < numTallas; talla++) {
							String ref = "" + empresa + centro + familia + barra + talla;
							Product product = new Product("NAME" + ref , "DESC" + ref, "EMP" + empresa, "CENT" + centro, "FAM" + familia, "BAR" + barra, "TAL" + talla);
							repository.save(product);
						}
//						System.out.println("Tallas cargadas:" + numTallas);
					}
//					System.out.println("Barras cargadas:" + numBarras);
				}
//        		System.out.println("Familias cargadas:" + numFamilias);
			}
        	System.out.println("Centros cargados:" + numCentros);
		}
        System.out.println("Empresa cargadas:" + numEmpresas);
        
        List<Product> result = repository.findByDescription("DESC1");
        assertThat(result).hasSize(1).extracting("name").contains("NAME1");
    }
    
    @Test
    public void findsByDescription() {

        List<Product> result = repository.findByDescription("DESC1");

        assertThat(result).hasSize(1).extracting("name").contains("NAME1");
    }
}