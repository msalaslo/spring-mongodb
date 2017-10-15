
package com.msl.mongo.domain.companies;

import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Image {

    public List<List<List<Integer>>> availableSizes = null;
    public Object attribution;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param availableSizes
     * @param attribution
     */
    public Image(List<List<List<Integer>>> availableSizes, Object attribution) {
        super();
        this.availableSizes = availableSizes;
        this.attribution = attribution;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("availableSizes", availableSizes).append("attribution", attribution).toString();
    }

}
