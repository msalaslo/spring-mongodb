package com.msl.mongo.domain.customer;

import org.springframework.data.annotation.Id;


public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public int yearOfBirth;

	public Customer() {}

    public Customer(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s', yearOfBirth='%s']",
                id, firstName, lastName, yearOfBirth);
    }

}

