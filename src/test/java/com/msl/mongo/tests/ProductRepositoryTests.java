package com.msl.mongo.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.msl.mongo.domain.product.Product;
import com.msl.mongo.domain.product.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTests {

    @Autowired
    ProductRepository repository;

    Product silla, reloj, galletas;

    @Before
    public void setUp() {

//        repository.deleteAll();

        silla = repository.save(new Product("Silla Rower", "Silla de comedor"));
        silla = repository.save(new Product("Silla Rower", "Silla de jardín"));
        reloj = repository.save(new Product("Swatch 200", "Swatch 200 de pulsera"));
        galletas = repository.save(new Product("Galletas Maria 34", "Caja de galletas Maria"));
    }

    @Test
    public void setsIdOnSave() {

        Product dave = repository.save(new Product("Teléfono móvil E200", "Smart mobile 4G"));

        assertThat(dave.id).isNotNull();
    }

    @Test
    public void findsByDescription() {

        List<Product> result = repository.findByDescription("Silla de comedor");

        assertThat(result).hasSize(1).extracting("name").contains("Silla Rower");
    }

    @Test
    public void findsByExample() {

        Product probe = new Product("Silla Rower", null);

        List<Product> result = repository.findAll(Example.of(probe));

        assertThat(result).hasSize(2).extracting("description").contains("Silla de comedor", "Silla de jardín");
    }
    
    @Test
    public void findsByName() {

        List<Product> result = repository.findByName("Galletas Maria");

        assertThat(result).hasSize(7).extracting("description").contains("Caja de galletas Maria");
    }
    
    @Test
    public void checkSize() {
        List<Product> result = repository.findAll();
        System.out.println("Product repository size:" + result.size());
        assertThat(result).isNotNull();
    }
}