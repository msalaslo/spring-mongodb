
package com.msl.mongo.domain.companies;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Office {

    public String description;
    public String address1;
    public String address2;
    public String zipCode;
    public String city;
    public String stateCode;
    public String countryCode;
    public Double latitude;
    public Double longitude;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Office() {
    }

    /**
     * 
     * @param description
     * @param zipCode
     * @param countryCode
     * @param stateCode
     * @param address1
     * @param longitude
     * @param address2
     * @param latitude
     * @param city
     */
    public Office(String description, String address1, String address2, String zipCode, String city, String stateCode, String countryCode, Double latitude, Double longitude) {
        super();
        this.description = description;
        this.address1 = address1;
        this.address2 = address2;
        this.zipCode = zipCode;
        this.city = city;
        this.stateCode = stateCode;
        this.countryCode = countryCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("description", description).append("address1", address1).append("address2", address2).append("zipCode", zipCode).append("city", city).append("stateCode", stateCode).append("countryCode", countryCode).append("latitude", latitude).append("longitude", longitude).toString();
    }

}
