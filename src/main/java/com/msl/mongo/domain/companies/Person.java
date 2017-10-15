
package com.msl.mongo.domain.companies;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Person {

    public String firstName;
    public String lastName;
    public String permalink;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Person() {
    }

    /**
     * 
     * @param lastName
     * @param permalink
     * @param firstName
     */
    public Person(String firstName, String lastName, String permalink) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.permalink = permalink;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("firstName", firstName).append("lastName", lastName).append("permalink", permalink).toString();
    }

}
