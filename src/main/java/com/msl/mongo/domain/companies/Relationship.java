
package com.msl.mongo.domain.companies;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Relationship {

    public Boolean isPast;
    public String title;
    public Person person;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Relationship() {
    }

    /**
     * 
     * @param person
     * @param title
     * @param isPast
     */
    public Relationship(Boolean isPast, String title, Person person) {
        super();
        this.isPast = isPast;
        this.title = title;
        this.person = person;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("isPast", isPast).append("title", title).append("person", person).toString();
    }

}
