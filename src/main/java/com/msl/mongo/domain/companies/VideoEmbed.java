
package com.msl.mongo.domain.companies;

import org.apache.commons.lang.builder.ToStringBuilder;

public class VideoEmbed {

    public String embedCode;
    public String description;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VideoEmbed() {
    }

    /**
     * 
     * @param description
     * @param embedCode
     */
    public VideoEmbed(String embedCode, String description) {
        super();
        this.embedCode = embedCode;
        this.description = description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("embedCode", embedCode).append("description", description).toString();
    }

}
