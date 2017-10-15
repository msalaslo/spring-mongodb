
package com.msl.mongo.domain.companies;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Stoneable {

    public String name;
    public String permalink;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stoneable() {
    }

    /**
     * 
     * @param permalink
     * @param name
     */
    public Stoneable(String name, String permalink) {
        super();
        this.name = name;
        this.permalink = permalink;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("permalink", permalink).toString();
    }

}
