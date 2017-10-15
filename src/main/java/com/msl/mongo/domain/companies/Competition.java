
package com.msl.mongo.domain.companies;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Competition {

    public Competitor competitor;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Competition() {
    }

    /**
     * 
     * @param competitor
     */
    public Competition(Competitor competitor) {
        super();
        this.competitor = competitor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("competitor", competitor).toString();
    }

}
