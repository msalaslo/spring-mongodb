package com.msl.mongo.domain.customer;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.msl.mongo.domain.customer.Customer;
import com.msl.mongo.domain.customer.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository repository;

    Customer dave, oliver, carter;

    @Before
    public void setUp() {

        repository.deleteAll();

        dave = repository.save(new Customer("Dave", "Matthews", 1976));
        oliver = repository.save(new Customer("Oliver August", "Matthews", 1976));
        carter = repository.save(new Customer("Carter", "Beauford", 1978));
    }

    @Test
    public void setsIdOnSave() {

        Customer dave = repository.save(new Customer("Dave", "Matthews", 1976));

        assertThat(dave.id).isNotNull();
    }

    @Test
    public void findsByLastName() {

        List<Customer> result = repository.findByLastName("Beauford");

        assertThat(result).hasSize(1).extracting("firstName").contains("Carter");
    }

    @Test
    public void findsByExample() {

        Customer probe = new Customer(null, "Matthews", 1976);

        List<Customer> result = repository.findAll(Example.of(probe));

        assertThat(result).hasSize(2).extracting("firstName").contains("Dave", "Oliver August");
    }
    
    @Test
    public void findsByYearOfBirth() {

        List<Customer> result = repository.findByYearOfBirth(1976);

        assertThat(result).hasSize(2).extracting("firstName").contains("Dave");
    }
}