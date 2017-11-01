package com.msl.mongo.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.msl.mongo.domain.promocion.Promocion;
import com.msl.mongo.domain.promocion.PromocionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PromocionRepositoryTests {

    @Autowired
    PromocionRepository repository;

    Promocion silla, reloj, galletas;

    @Before
    public void setUp() {

//        repository.deleteAll();

        silla = repository.save(new Promocion("001", "0037", "46", "0133", "000", "00000", "000", "14331002", "123456789012345678901234567"));
        silla = repository.save(new Promocion("001", "0037", "46", "0133", "000", "00000", "000", "14331002", "223456789012345678901234567"));
        silla = repository.save(new Promocion("001", "0037", "46", "0133", "000", "00000", "000", "14331002", "323456789012345678901234567"));
        galletas = repository.save(new Promocion("001", "0037", "46", "0133", "000", "00000", "000", "14331002", "423456789012345678901234567"));
    }

    @Test
    public void setsIdOnSave() {
        Promocion promocion = repository.save(new Promocion("001", "0037", "46", "0133", "000", "00000", "000", "14331002", "523456789012345678901234567"));
        assertThat(promocion.id).isNotNull();
    }

    @Test
    public void findsByEmpresa() {
        List<Promocion> result = repository.findByEmpresa("001");
        assertThat(result).extracting("centro").contains("0037");
    }

//    @Test
//    public void findsByExample() {
//
//        Product probe = new Product("Silla Rower", null);
//
//        List<Product> result = repository.findAll(Example.of(probe));
//
//        assertThat(result).hasSize(2).extracting("description").contains("Silla de comedor", "Silla de jardín");
//    }
    
    
    @Test
    public void checkSize() {
        List<Promocion> result = repository.findAll();
        System.out.println("Product repository size:" + result.size());
        assertThat(result).isNotNull();
    }
}