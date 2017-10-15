
package com.msl.mongo.domain.companies;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Investment {

    public Object company;
    public FinancialOrg financialOrg;
    public Object person;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Investment() {
    }

    /**
     * 
     * @param financialOrg
     * @param person
     * @param company
     */
    public Investment(Object company, FinancialOrg financialOrg, Object person) {
        super();
        this.company = company;
        this.financialOrg = financialOrg;
        this.person = person;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("company", company).append("financialOrg", financialOrg).append("person", person).toString();
    }

}
