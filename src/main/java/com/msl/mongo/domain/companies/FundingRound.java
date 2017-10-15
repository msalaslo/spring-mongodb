
package com.msl.mongo.domain.companies;

import java.util.List;
import org.apache.commons.lang.builder.ToStringBuilder;

public class FundingRound {

    public Integer id;
    public String roundCode;
    public String sourceUrl;
    public String sourceDescription;
    public Integer raisedAmount;
    public String raisedCurrencyCode;
    public Integer fundedYear;
    public Integer fundedMonth;
    public Integer fundedDay;
    public List<Investment> investments = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FundingRound() {
    }

    /**
     * 
     * @param id
     * @param fundedMonth
     * @param investments
     * @param fundedYear
     * @param fundedDay
     * @param sourceDescription
     * @param raisedCurrencyCode
     * @param raisedAmount
     * @param roundCode
     * @param sourceUrl
     */
    public FundingRound(Integer id, String roundCode, String sourceUrl, String sourceDescription, Integer raisedAmount, String raisedCurrencyCode, Integer fundedYear, Integer fundedMonth, Integer fundedDay, List<Investment> investments) {
        super();
        this.id = id;
        this.roundCode = roundCode;
        this.sourceUrl = sourceUrl;
        this.sourceDescription = sourceDescription;
        this.raisedAmount = raisedAmount;
        this.raisedCurrencyCode = raisedCurrencyCode;
        this.fundedYear = fundedYear;
        this.fundedMonth = fundedMonth;
        this.fundedDay = fundedDay;
        this.investments = investments;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("roundCode", roundCode).append("sourceUrl", sourceUrl).append("sourceDescription", sourceDescription).append("raisedAmount", raisedAmount).append("raisedCurrencyCode", raisedCurrencyCode).append("fundedYear", fundedYear).append("fundedMonth", fundedMonth).append("fundedDay", fundedDay).append("investments", investments).toString();
    }

}
