
package com.msl.mongo.domain.companies;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Acquisition {

    public Object priceAmount;
    public String priceCurrencyCode;
    public Object termCode;
    public String sourceUrl;
    public String sourceDescription;
    public Integer acquiredYear;
    public Integer acquiredMonth;
    public Integer acquiredDay;
    public AcquiringCompany acquiringCompany;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Acquisition() {
    }

    /**
     * 
     * @param sourceDescription
     * @param priceAmount
     * @param priceCurrencyCode
     * @param acquiredYear
     * @param acquiredMonth
     * @param acquiringCompany
     * @param termCode
     * @param sourceUrl
     * @param acquiredDay
     */
    public Acquisition(Object priceAmount, String priceCurrencyCode, Object termCode, String sourceUrl, String sourceDescription, Integer acquiredYear, Integer acquiredMonth, Integer acquiredDay, AcquiringCompany acquiringCompany) {
        super();
        this.priceAmount = priceAmount;
        this.priceCurrencyCode = priceCurrencyCode;
        this.termCode = termCode;
        this.sourceUrl = sourceUrl;
        this.sourceDescription = sourceDescription;
        this.acquiredYear = acquiredYear;
        this.acquiredMonth = acquiredMonth;
        this.acquiredDay = acquiredDay;
        this.acquiringCompany = acquiringCompany;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("priceAmount", priceAmount).append("priceCurrencyCode", priceCurrencyCode).append("termCode", termCode).append("sourceUrl", sourceUrl).append("sourceDescription", sourceDescription).append("acquiredYear", acquiredYear).append("acquiredMonth", acquiredMonth).append("acquiredDay", acquiredDay).append("acquiringCompany", acquiringCompany).toString();
    }

}
