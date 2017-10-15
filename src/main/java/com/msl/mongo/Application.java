package com.msl.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.msl.mongo.domain.companies.CompanyRepository;
import com.msl.mongo.domain.customer.Customer;
import com.msl.mongo.domain.customer.CustomerRepository;
import com.msl.mongo.domain.product.Product;
import com.msl.mongo.domain.product.ProductRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		customerRepository.deleteAll();

		// save a couple of customers
		customerRepository.save(new Customer("Alice", "Smith", 1975));
		customerRepository.save(new Customer("Bob", "Smith", 1980));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerRepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customerRepository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		
		System.out.println("Customers found with findByYearOfBirth('1980'):");
		System.out.println("--------------------------------");
		for (Customer customer : customerRepository.findByYearOfBirth(1980)) {
			System.out.println(customer);
		}
		
		// fetch all companies
//		System.out.println("Companies found with findAll():");
//		System.out.println("-------------------------------");
//		for (Company company : companyRepository.findAll()) {
//			System.out.println(company);
//		}
//		System.out.println();
		System.out.println();
		// fetch an individual company
		System.out.println("company found with findByName('Geni'):");
		System.out.println("--------------------------------");
		System.out.println(companyRepository.findByName("Geni"));
		System.out.println();
		
		// fetch an individual product
		System.out.println("product found with findByName('Swatch 200'):");
		System.out.println(productRepository.findByName("Swatch 200"));
//        List<Product> result = productRepository.findAll();
//        System.out.println("Product repository size:" + result.size());

	}

}
